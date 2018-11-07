package com.qaii.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qaii.domain.PatProcess;
import com.qaii.domain.Processimg;
import com.qaii.domain.Trademarkprocessfile;
import com.qaii.domain.Trademark;
import com.qaii.domain.TrademarkImg;
import com.qaii.domain.Trademarkprocess;
import com.qaii.domain.Trademarkprocessfile;
import com.qaii.domain.Trademark;
import com.qaii.service.TradeMarkService;
import com.qaii.service.TrademarkImgService;
import com.qaii.service.TrademarkProcessFileService;
import com.qaii.service.TrademarkProcessService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class TradeMarkController {
	@Resource
	private TradeMarkService trademarkService;
	@Resource
	private TrademarkImgService tradeimgService;
	@Resource
	private TrademarkProcessService processService;
	@Resource
	private TrademarkProcessFileService processfileService;
	
	//获取所有商标信息
	@RequestMapping(value="getAllTradeMarkMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllTradeMarkMsg() {
		List<Trademark> result=trademarkService.getAllTradeMarkMsg();
		int count =result.size();
		return Layui.data(count, result);
	}
	//删除商标信息
	@RequestMapping("dellTradeMarkMsg.do")
	@ResponseBody
	public JsonResult dellTradeMarkMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=trademarkService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	

	//商标查看详情
	@RequestMapping(value="showTradeMarkDetails.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult showTradeMarkDetails(Trademark trademark,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("id"));
		//trademark.setId();
		trademark = trademarkService.selectByPrimaryKey(userid);
		return new JsonResult(trademark);
	}
	
	//修改商标信息功能
	@RequestMapping(value="updateTrademark.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	String updateTrademarks(Trademark Trademark,HttpServletRequest req){	
		Trademark.setId(Integer.parseInt(req.getParameter("userId")));
		loadData(req, Trademark);
		int row =trademarkService.updatetrademark(Trademark);
		if(row>=1) {
			return  "page/science/inform/edit-succesdsci";
    	}else {
    		return "page/science/inform/edit-faildsci";
		}
	}
	//绑定请求数据到bean中
	void loadData(HttpServletRequest req,Trademark Trademark){
		if(!(req.getParameter("imageVal")==""))
			Trademark.setEid(Integer.parseInt(req.getParameter("imageVal")));
		Trademark.setTradmDept(req.getParameter("tradmDept"));
		Trademark.setTradmCode(req.getParameter("tradmCode"));
		Trademark.setTradmPngandexplain(req.getParameter("tradmPngandexplain"));
		Trademark.setTradmApplyper(req.getParameter("tradmApplyper"));
		Trademark.setTradmAgency(req.getParameter("tradmAgency"));
		Trademark.setTradmType(req.getParameter("tradmType"));
		Trademark.setTradmItem(req.getParameter("tradmItem"));
		Trademark.setTradmApplynum(req.getParameter("tradmApplynum"));
		Trademark.setTradmApplytime(req.getParameter("tradmApplytime"));
		Trademark.setTradmRegistertime(req.getParameter("tradmRegistertime"));
		Trademark.setTradmValidtime(req.getParameter("tradmValidtime"));
		Trademark.setTradmCost(req.getParameter("tradmCost"));
		Trademark.setTradmInvoiceper(req.getParameter("tradmInvoiceper"));
		Trademark.setTradmStatusfollow(req.getParameter("tradmStatusfollow"));
		Trademark.setTradmUpdatetime(req.getParameter("tradmUpdatetime"));
	}
	//添加商标信息功能
	@RequestMapping("addTrademark.do")
	String AddTrademark(HttpServletRequest req,Trademark trademark) {
		loadData(req, trademark);		
		int row = trademarkService.insertMsg(trademark);
		if(row>0) {
			return  "page/science/inform/add-succesdsci";
    	}else {
    		return "page/science/inform/add-faildsci";
		}
		
	}
	
	//使用excel文件快捷导入商标数据
	@RequestMapping(value="insertTradeDatabyexcel.do")
	@ResponseBody
	public Layui test(@RequestParam("file")MultipartFile file) throws FileNotFoundException, IOException, CustomException, AlertException  {
		Layui result = null;
		List<String> list =new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String filename=file.getOriginalFilename();
		Workbook wookbook;
		//判断是不是excel文件
		if(!(filename.endsWith(".xls")||filename.endsWith(".xlsx")))
			throw new AlertException("请选择excel格式的文件！");
		//判断是03版还是07版excel
		if(filename.endsWith(".xls")) {
			wookbook=new HSSFWorkbook(file.getInputStream());
		}else {
			wookbook=new XSSFWorkbook(file.getInputStream());
		}
		try {
			Sheet sheet=wookbook.getSheet("Sheet1");
			int rows = sheet.getPhysicalNumberOfRows();
			for (int i=1;i<rows;i++) {
				Row row =sheet.getRow(i);
				int cells=sheet.getRow(0).getPhysicalNumberOfCells();
				if (row!=null) {
					list.clear();
					for (int j=0;j<cells;j++) {
						Cell cell=row.getCell(j);
						if(cell!=null){
							int cellType=cell.getCellType();
							switch(cellType) {
								case Cell.CELL_TYPE_BLANK: 	//单元格式为空白
									cell.setCellType(Cell.CELL_TYPE_STRING);
									break;
								case Cell.CELL_TYPE_BOOLEAN: //布尔
									cell.setCellType(Cell.CELL_TYPE_BOOLEAN);
									break;
								case Cell.CELL_TYPE_ERROR: 	//错误
									cell.setCellValue("错误");
									break;
								case Cell.CELL_TYPE_FORMULA: //公式
									cell.setCellType(Cell.CELL_TYPE_STRING);
									break;
								case Cell.CELL_TYPE_NUMERIC: 	//日期、数字
									if (DateUtil.isCellDateFormatted(cell))
										cell.setCellValue(sdf.format(cell.getDateCellValue()));
									else {
										cell.setCellType(Cell.CELL_TYPE_STRING);
									}
									break;
								case Cell.CELL_TYPE_STRING:		//文本
									cell.setCellType(Cell.CELL_TYPE_STRING);
							}
							list.add(cell.toString());
						}else {
							list.add(null);
						}
					}
					Trademark trade = new Trademark();
					trade=setTrademarkvalue(trade, list);
					if(trade.getTradmRegistertime()!=null)
					trade.setTradmRegistertime(trade.getTradmRegistertime().replace("/", "-"));
					if(trade.getTradmApplytime()!=null)
					trade.setTradmApplytime(trade.getTradmApplytime().replace("/", "-"));
					if(trade.getTradmUpdatetime()!=null)
					trade.setTradmUpdatetime(trade.getTradmUpdatetime().replace("/", "-"));
					trademarkService.insertMsg(trade);
					result=result.data(1, null);
					
				}
			}
		}catch(Exception e) {
			wookbook.close();
			e.printStackTrace();
			throw new CustomException("数据库异常!请检查文件格式!");			
		}
		wookbook.close();
		return result;
		
	}
	public Trademark setTrademarkvalue(Trademark Trademark,List<String> value) {
		Trademark.setTradmDept(value.get(0));
		Trademark.setTradmCode(value.get(1));
		Trademark.setTradmPngandexplain(value.get(2));
		Trademark.setTradmApplyper(value.get(3));
		Trademark.setTradmAgency(value.get(4));
		Trademark.setTradmType(value.get(5));
		Trademark.setTradmItem(value.get(6));
		Trademark.setTradmApplynum(value.get(7));
		Trademark.setTradmApplytime(value.get(8));
		Trademark.setTradmRegistertime(value.get(9));
		Trademark.setTradmValidtime(value.get(1));
		Trademark.setTradmCost(value.get(11));
		Trademark.setTradmInvoiceper(value.get(12));
		Trademark.setTradmStatusfollow(value.get(13));
		Trademark.setTradmUpdatetime(value.get(14));
		
		return Trademark;
	}
	
	//商标图片上传
	@RequestMapping("/tradeupload.do")  
	@ResponseBody
    public Map<String,String> upload(@RequestParam("file") MultipartFile file , TrademarkImg trade,HttpServletRequest request) throws Exception{  
  //  System.out.println(request.getParameter("name"));  
    Map<String,String> result=new HashMap<>();
    if(file.isEmpty()) {
    	result.put("code", "1");
    	result.put("msg", "文件为空");
    }
    String uuid = UUID.randomUUID().toString().replaceAll("-","");    
    //获得文件类型（可以判断如果不是图片，禁止上传）    
    String contentType=trade.getFile().getContentType();    
    //获得文件后缀名   
    String suffixName=contentType.substring(contentType.indexOf("/")+1);  
    //得到 文件名  
    String fileName=uuid+"."+suffixName; 
    
  //  String fileName=file.getOriginalFilename();
    int size=(int)file.getSize();
  //  System.out.println(fileName+":---"+size);
    String path="C:/File/img/TradeMark/Symbol";
    File dest =new File(path+"/"+fileName);
    if(!dest.getParentFile().exists()) {
    	dest.getParentFile().mkdirs();
    }
    try {
		file.transferTo(dest);//保存文件
		trade.setPath("img/TradeMark/Symbol/"+fileName);
		InserttradeImg(trade, result, dest);
		result.put("code", "0");
		result.put("msg", "上传成功");
		result.put("url", dest.getPath());
	} catch (IllegalStateException e) {
		// TODO: handle exception
		e.printStackTrace();
		result.put("code", "1");
    	result.put("msg", "上传失败");
	}catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
		result.put("code", "1");
    	result.put("msg", "上传失败");
	}
    
    return result;  

    }
	
	private void InserttradeImg(TrademarkImg trade, Map<String, String> result, File dest) {
		int row=tradeimgService.insertmsg(trade);
		if(row > 0) {
			int eid=trade.getId();
			if(eid>=1) {
				result.put("code", "0");
				result.put("msg", "上传成功");
				result.put("eid",trade.getId().toString() );
				result.put("url", dest.getPath());
				
			}else {
				result.put("code", "1");
		    	result.put("msg", "上传失败");
			}
		}else {
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}
	}  
	
	//添加商标资料审核流程信息
  	@RequestMapping(value="addtradeProcess.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
  	@ResponseBody
  	public JsonResult addProcessInfo(HttpServletRequest req,Trademarkprocess patp) {
  		patp.setPid(Integer.parseInt(req.getParameter("pid")));
  		patp.setDescription(req.getParameter("description"));
  		patp.setTitle(req.getParameter("title"));
  		patp.setTime(req.getParameter("time"));
  		int row = processService.addProcess(patp);
      	if(row!=0) {
      		return  new JsonResult(row);
      	}else {
      		return  new JsonResult();
      		
      	}
  	}
  	
  	//显示所有商标审核流程信息
  	@ResponseBody
  	@RequestMapping(value="getTradeProcess.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
  	public JsonResult findAllProcessInfo(HttpServletRequest req) {
  		
  		Integer pid=Integer.parseInt(req.getParameter("id"));
  		
  		List<Trademarkprocess>list=processService.getAllMsgBypid(pid);
      	if(list!=null) {
      		return  new JsonResult(list);
      	}else {
      		return  new JsonResult();
      		
      	}
  	}
	
  	//审核资料上传
  	@ResponseBody
	@RequestMapping("/tradeprocessupload.do")
	public Map<String, String> processupload(@RequestParam("file") MultipartFile[] files, Trademarkprocessfile img,
			HttpServletRequest req) throws Exception {
		// System.out.println(request.getParameter("name"));
		String insertype=req.getParameter("type");
		Integer oid = Integer.parseInt(req.getParameter("oid"));
		Integer stepid = Integer.parseInt(req.getParameter("step"));
		String tradmDept = new String(req.getParameter("tradmDept").getBytes("ISO-8859-1"),"utf-8");
		Map<String, String> result = new HashMap<>();
		if (files != null && files.length < 0) {
			result.put("code", "1");
			result.put("msg", "文件为空");
		}

		for (int i = 0; i < files.length; i++) {
			 String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
			 
			 String name=files[i].getOriginalFilename();
			// 取文件格式后缀名
			//String type = files[i].getOriginalFilename();
			 
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			 
			String filename = uuid + type;// 取当前时间戳作为文件名

			// String path = request.getSession().getServletContext().getRealPath("/upload/"
			// + filename);// 存放位置
			String path = "C:/File/img/TradeMark/File/" + tradmDept + "/" + oid + "/" + stepid;
			String dbpath="/img/TradeMark/File/"+tradmDept + "/" + oid + "/" + stepid;
			System.out.println("++++++" + path);
			File destFile = new File(path + "/" + filename);

			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			try {
				// FileUtils.copyInputStreamToFile(files[i].getInputStream(), destFile);//
				// 复制临时文件到指定目录下
				files[i].transferTo(destFile);
				img.setSid(stepid);
				img.setOid(oid);
				img.setPath(dbpath.toString()+"/"+filename.toString());
				img.setName(name);
				
				if(insertype.equals("insert")) {
					InsertTrademarkprocessfile(img,result, destFile);
					result.put("code", "0");
					result.put("msg", "上传成功");
					result.put("url", destFile.getPath());
				}else if(insertype.equals("update")) {
					updataTrademarkprocessfile(img,result, destFile);
					result.put("code", "0");
					result.put("msg", "上传成功");
					result.put("url", destFile.getPath());
				}
				

			} catch (IOException e) {
				e.printStackTrace();
				result.put("code", "1");
				result.put("msg", "上传失败");
			}
		}

		return result;

	}
  	
  	private void InsertTrademarkprocessfile(Trademarkprocessfile img, Map<String, String> result, File dest) {
		int row=processfileService.insertMsg(img);
		if(row > 0) {
			result.put("code", "0");
			result.put("msg", "上传成功");
		}else {
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}
	} 
  	
  	private void updataTrademarkprocessfile(Trademarkprocessfile img, Map<String, String> result, File dest) {
		int row=processfileService.updateMsg(img);
		if(row > 0) {
			result.put("code", "0");
			result.put("msg", "上传成功");
		}else {
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}
	} 
  	
  	//显示流程文件列表
  	@ResponseBody
	@RequestMapping(value="gettrademarkfile.do",produces="application/json;charset=UTF-8")
	public Layui findProessimg(HttpServletRequest req) {
		Integer sid=Integer.parseInt(req.getParameter("sid"));
		List<Trademarkprocessfile>img=processfileService.getAllMsg(sid);
		int count =img.size();
		
		return Layui.data(count, img);

	}
  	
  	//删除流程文件
  	@ResponseBody
	@RequestMapping(value="delltradefile.do",produces="application/json;charset=UTF-8")
	public JsonResult dellProessimg(@RequestParam(value = "requestDate[]") Integer[] id) {
		int row=processfileService.deleteByPrimaryKey(id);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}

  	//重新上传流程文件
  	@ResponseBody
	@RequestMapping(value="uptradefile.do",produces="application/json;charset=UTF-8")
	public JsonResult updataProessimg(@RequestParam(value = "requestDate") Trademarkprocessfile img) {
		
		int row=processfileService.updateMsg(img);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
}
