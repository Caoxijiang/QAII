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

import com.qaii.domain.DeptInfo;
import com.qaii.domain.PatProcess;
import com.qaii.domain.Patent;
import com.qaii.domain.Processimg;
import com.qaii.service.PatentService;
import com.qaii.service.ProcessService;
import com.qaii.service.ProcessimgService;
import com.qaii.util.AlertException;
import com.qaii.util.CountDatetoNowDays;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class PatentController {
	@Resource
	private PatentService patentService;
	@Resource
	private ProcessService processService;
	//增加专利信息
	@Resource
	private ProcessimgService processimgService;
	@ResponseBody
	@RequestMapping(value="addPatentInfo.do",produces="application/json;charset=UTF-8")
	public JsonResult addPatentInfo(HttpServletRequest req ,Patent patent) {
		PatentInfo(req, patent);
		int row = patentService.insert(patent);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//专利列表
	@ResponseBody
	@RequestMapping(value="findPatentInfo.do",produces="application/json;charset=UTF-8")
	public Layui findPatentInfo() {
		List<Patent> deptInfo=patentService.findAllPatentInfo();
		int count =deptInfo.size();
			if(deptInfo!=null) {
				return Layui.data(count, deptInfo);
			}else {
				return Layui.data(count, deptInfo);
			}
	}
	
	
	
	
	//专利详情
	@ResponseBody
	@RequestMapping(value="findPatentInfoById.do",produces="application/json;charset=UTF-8")
	public JsonResult findPatentInfoById(HttpServletRequest req,Patent patent) {
		patent.setId(Integer.valueOf(req.getParameter("id"))); 
		Patent row=patentService.selectByPrimaryKey(patent.getId());
		
			if(row!=null) {
				return new JsonResult(row);
			}else {
				return new JsonResult();
			}
	}
	
	
	//删除专利信息
    @ResponseBody
    @RequestMapping(value="dellPatentInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult dellPatentInfo(@RequestParam(value = "requestDate[]") Integer[] id ){
     	int row=patentService.deleteByPrimaryKey(id);
     
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
        
    }
    
    
    
	//修改部门信息
    @ResponseBody
    @RequestMapping(value="uptatePatentInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult uptatePatentInfo(HttpServletRequest req,Patent patent){
    	PatentInfo(req, patent);
    	patent.setId(Integer.parseInt(req.getParameter("id")));
     	int row=patentService.updateByPrimaryKey(patent);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
        
    }
    
	
	
	
    //增加专利流程信息
  	@ResponseBody
  	@RequestMapping(value="addProcessInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
  	public JsonResult addProcessInfo(HttpServletRequest req,PatProcess patp) {
  		patp.setPid(Integer.parseInt(req.getParameter("pid")));
  		patp.setDescription(req.getParameter("description"));
  		patp.setTitle(req.getParameter("title"));
  		patp.setTime(req.getParameter("time"));
  		int row = processService.addProcessInfo(patp);
      	if(row!=0) {
      		return  new JsonResult(row);
      	}else {
      		return  new JsonResult();
      		
      	}
  	}
	
	
    //增加专利流程信息
  	@ResponseBody
  	@RequestMapping(value="findAllProcessInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
  	public JsonResult findAllProcessInfo(HttpServletRequest req) {
  		
  		Integer pid=Integer.parseInt(req.getParameter("id"));
  		
  		List <PatProcess>list=processService.findProcessList(pid);
      	if(list!=null) {
      		return  new JsonResult(list);
      	}else {
      		return  new JsonResult();
      		
      	}
  	}
	
	
	
	
	
	// 資料上傳
	@ResponseBody
	@RequestMapping("/processupload.do")
	public Map<String, String> processupload(@RequestParam("file") MultipartFile[] files, Processimg img,
			HttpServletRequest req) throws Exception {
		// System.out.println(request.getParameter("name"));
		String insertype=req.getParameter("type");
		//项目id
		Integer oid = Integer.parseInt(req.getParameter("oid"));
		//步骤id
		Integer stepid = Integer.parseInt(req.getParameter("step"));
		//项目名称
		String patName = req.getParameter("patName");
		System.out.println(files);
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

			System.out.println("文件名：" + filename);
			// String path = request.getSession().getServletContext().getRealPath("/upload/"
			// + filename);// 存放位置
			String path = "C:/File/img/" + patName + "/" + oid + "/" + stepid;
			String dbpath="img/"+patName + "/" + oid + "/" + stepid;
			System.out.println("++++++" + path);
			File destFile = new File(path + "/" + filename);

			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			try {
				// FileUtils.copyInputStreamToFile(files[i].getInputStream(), destFile);//
				// 复制临时文件到指定目录下
				files[i].transferTo(destFile);
				if(insertype.equals("insert")) {
					img.setSid(stepid);
					img.setOid(oid);
					img.setPath(dbpath.toString()+"/"+filename.toString());
					img.setName(name);
					InsertProcessimg(img,result, destFile);
					result.put("code", "0");
					result.put("msg", "上传成功");
					result.put("url", destFile.getPath());
				}else if(insertype.equals("update")) {
					Integer id=Integer.parseInt(req.getParameter("id"));
					img.setPath(dbpath.toString()+"/"+filename.toString());
					img.setName(name);
					img.setId(id);
					updataProcessimg(img,result, destFile);
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
  	
  	//根據流程id獲取對應文件信息
	@ResponseBody
	@RequestMapping(value="findProessimg.do",produces="application/json;charset=UTF-8")
	public Layui findProessimg(HttpServletRequest req) {
		Integer sid=Integer.parseInt(req.getParameter("sid"));
		List<Processimg>img=processimgService.selectProimgList(sid);
		int count =img.size();
			if(img!=null) {
				return Layui.data(count, img);
			}else {
				return Layui.data(count, img);
			}
	}
  	
 	//删除专利信息
	@ResponseBody
	@RequestMapping(value="dellProessimg.do",produces="application/json;charset=UTF-8")
	public JsonResult dellProessimg(@RequestParam(value = "requestDate[]") Integer[] id) {
		int row=processimgService.deleteByPrimaryKey(id);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
  	
  	
  	
	
 	//重上传专利信息
	@ResponseBody
	@RequestMapping(value="updataProessimg.do",produces="application/json;charset=UTF-8")
	public JsonResult updataProessimg(@RequestParam(value = "requestDate") Processimg img) {
		
		int row=processimgService.updataProcessInfo(img);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
  	
	
	
	
	
	

	private void PatentInfo(HttpServletRequest req, Patent patent) {
		patent.setPatDept(req.getParameter("patDept"));
		patent.setPatType(req.getParameter("patType"));
		patent.setPatName(req.getParameter("patName"));
		patent.setPatAuthor(req.getParameter("patAuthor"));
		patent.setPatApplyper(req.getParameter("patApplyper"));
		patent.setPatTelltime(req.getParameter("patTelltime"));
		patent.setPatAgency(req.getParameter("patAgency"));
		patent.setPatPrepublishaudit(req.getParameter("patPrepublishaudit"));
		patent.setPatApplynum(req.getParameter("patApplynum"));
		patent.setPatApplytime(req.getParameter("patApplytime"));
		patent.setPatPublishnum(req.getParameter("patPublishtime"));
		patent.setPatAuthorzationtime(req.getParameter("patAuthorzationtime"));
		patent.setPatRemission(req.getParameter("patRemission"));
		patent.setPatCost(req.getParameter("patCost"));
		patent.setPatInvoiceper(req.getParameter("patInvoiceper"));
		patent.setPatDigest(req.getParameter("patDigest"));
		patent.setPatRemark(req.getParameter("patRemark"));
	}
	
	
	
	private void InsertProcessimg(Processimg img, Map<String, String> result, File dest) {
		int row=processimgService.insert(img);
		if(row > 0) {
			result.put("code", "0");
			result.put("msg", "上传成功");
		}else {
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}
	}  
	
	
	private void updataProcessimg(Processimg img, Map<String, String> result, File dest) {
		int row=processimgService.updataProcessInfo(img);
		if(row > 0) {
			result.put("code", "0");
			result.put("msg", "上传成功");
		}else {
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}
	} 
	
	//信息导入
	@RequestMapping(value="insertPatentByExcel.do")
	@ResponseBody
	public JsonResult insertByExcel(@RequestParam("file")MultipartFile file, Patent record) throws FileNotFoundException, IOException, CustomException, AlertException  {
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
					loadExcelData(record,list);
					patentService.insert(record);
					
				}
			}
		}catch(Exception e) {
			wookbook.close();
			e.printStackTrace();
			throw new CustomException("数据库异常!请检查文件格式!");			
		}
		wookbook.close();
		return new JsonResult("success");
		
	}
  	
	void loadExcelData(Patent record , List<String> list) {
		record.setPatDept(list.get(0));
		record.setPatType(list.get(1));
		record.setPatName(list.get(2));
		record.setPatDigest(list.get(3));
		record.setPatAuthor(list.get(4));
		record.setPatApplyper(list.get(5));
		record.setPatTelltime(list.get(6));
		record.setPatAgency(list.get(7));
		record.setPatPrepublishaudit(list.get(8));
		record.setPatApplynum(list.get(9));
		record.setPatApplytime(list.get(10));
		record.setPatPublishnum(list.get(11));
		record.setPatPublishtime(list.get(12));
		record.setPatAuthorzationtime(list.get(13));
		record.setPatRemission(list.get(14));
		record.setPatCost(list.get(15));
		record.setPatInvoiceper(list.get(16));
		record.setPatRemark(list.get(17));
		record.setPatPenner(list.get(18));
		record.setPatAgent(list.get(19));
	}
	
}
