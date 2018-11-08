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

import com.qaii.domain.Govreward;
import com.qaii.domain.Govrewardprocess;
import com.qaii.domain.Govrewardprocessfile;
import com.qaii.service.GovRewardService;
import com.qaii.service.GovRewardProcessFileService;
import com.qaii.service.GovRewardProcessService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class RewardController {
	
	@Resource
	private GovRewardService govrewardService;
	@Resource
	private GovRewardProcessService processService;
	@Resource
	private GovRewardProcessFileService processfileService;
	
	//文件路径
	public final static String FILE_PATH= "C:/File/img/reward/";
	//数据库中记录的路径
	public final static String DATABASE_PATH="/img/reward/";
	
	//获取所有政府奖励信息
	@RequestMapping(value="getAllRewardMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllRewardMsg() {
		List<Govreward> result=govrewardService.getAllRewardMsg();
//			for(Softwarecopyright software:result) {
//				CountDatetoNowDays.TranstoDate(emp);
//			}
		int count =result.size();
		if(result!=null) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, result);
		}
	}
	//删除政府奖励信息
	@RequestMapping("dellRewardMsg.do")
	@ResponseBody
	public JsonResult dellRewardMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govrewardService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	
	//政府奖励查看详情
	@RequestMapping(value="showGovrewardDetails.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult showGovrewardDetails(Govreward govreward,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("id"));
		//Govreward.setId();
		govreward = govrewardService.selectByPrimaryKey(userid);
		return new JsonResult(govreward);
	}
	
	//修改政府奖励信息功能
	@RequestMapping(value="updateGovreward.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	String updateGovrewards(Govreward govreward,HttpServletRequest req){	
		loadData(req, govreward);
		int row =govrewardService.updateMsg(govreward);
		if(row>=1) {
			return  "page/science/inform/edit-succesdsci";
    	}else {
    		return "page/science/inform/edit-faildsci";
		}
	}
	//绑定请求数据到bean中
	void loadData(HttpServletRequest req,Govreward govreward){
		govreward.setRewardApplytime(req.getParameter("rewardApplytime"));
		govreward.setRewardSource(req.getParameter("rewardSource"));
		govreward.setRewardLevel(req.getParameter("rewardLevel"));
		govreward.setRewardName(req.getParameter("rewardName"));
		govreward.setRewardProjectname(req.getParameter("rewardProjectname"));
		govreward.setRewardDutyunit(req.getParameter("rewardDutyunit"));
		govreward.setRewardCooperationunit(req.getParameter("rewardCooperationunit"));
		govreward.setRewardManagedepart(req.getParameter("rewardManagedepart"));
		govreward.setRewardApplydepart(req.getParameter("rewardApplydepart"));
		govreward.setRewardAssumedepart(req.getParameter("rewardAssumedepart"));
		govreward.setRewardAward(req.getParameter("rewardAward"));
		govreward.setRewardAwardtime(req.getParameter("rewardAwardtime"));
		govreward.setRewardAwardnum(req.getParameter("rewardAwardnum"));
		govreward.setRewardFundtime(req.getParameter("rewardFundtime"));
	}
	//添加政府奖励信息功能
	@RequestMapping("addGovreward.do")
	String AddGovreward(HttpServletRequest req,Govreward govreward) {
		loadData(req, govreward);		
		int row = govrewardService.insertMsg(govreward);
		if(row>0) {
			return  "page/science/inform/add-succesdsci";
    	}else {
    		return "page/science/inform/add-faildsci";
		}
		
	}
	
	
	//使用excel文件快捷导入政府奖励数据
	@RequestMapping(value="insertGovrewardDatabyexcel.do")
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
					Govreward govreward = new Govreward();
					govreward=setGovrewardvalue(govreward, list);
					if(govreward.getRewardApplytime()!=null)
						govreward.setRewardApplytime(govreward.getRewardApplytime().replace("/", "-"));
					if(govreward.getRewardAwardtime()!=null)
						govreward.setRewardAwardtime(govreward.getRewardAwardtime().replace("/", "-"));
					if(govreward.getRewardFundtime()!=null)
						govreward.setRewardFundtime(govreward.getRewardFundtime().replace("/", "-"));
					govrewardService.insertMsg(govreward);
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
	public Govreward setGovrewardvalue(Govreward govreward,List<String> value) {
		govreward.setRewardApplytime(value.get(0));
		govreward.setRewardSource(value.get(1));
		govreward.setRewardLevel(value.get(2));
		govreward.setRewardName(value.get(3));
		govreward.setRewardProjectname(value.get(4));
		govreward.setRewardDutyunit(value.get(5));
		govreward.setRewardCooperationunit(value.get(6));
		govreward.setRewardManagedepart(value.get(7));
		govreward.setRewardApplydepart(value.get(8));
		govreward.setRewardAssumedepart(value.get(9));
		govreward.setRewardAward(value.get(10));
		govreward.setRewardAwardtime(value.get(11));
		govreward.setRewardAwardnum(value.get(12));
		govreward.setRewardFundtime(value.get(13));
		
		return govreward;
	}
	
	//添加奖励资料审核流程信息
  	@RequestMapping(value="addGovrewardprocess.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
  	@ResponseBody
  	public JsonResult addProcessInfo(HttpServletRequest req,Govrewardprocess patp) {
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
  	
  	//显示所有奖励审核流程信息
  	@ResponseBody
  	@RequestMapping(value="getGovrewardprocess.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
  	public JsonResult findAllProcessInfo(HttpServletRequest req) {
  		
  		Integer pid=Integer.parseInt(req.getParameter("id"));
  		
  		List<Govrewardprocess>list=processService.getAllMsgBypid(pid);
      	if(list!=null) {
      		return  new JsonResult(list);
      	}else {
      		return  new JsonResult();
      		
      	}
  	}
	
  	//审核资料上传
  	@ResponseBody
	@RequestMapping("/Govrewardprocessupload.do")
	public Map<String, String> processupload(@RequestParam("file") MultipartFile[] files, Govrewardprocessfile img,
			HttpServletRequest req) throws Exception {
		// System.out.println(request.getParameter("name"));
		String insertype=req.getParameter("type");
		Integer oid = Integer.parseInt(req.getParameter("oid"));
		Integer stepid = Integer.parseInt(req.getParameter("step"));
		String rewardName = new String(req.getParameter("rewardName").getBytes("ISO-8859-1"),"utf-8");
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
			String path = FILE_PATH + rewardName + "/" + oid + "/" + stepid;
			String dbpath = DATABASE_PATH + rewardName + "/" + oid + "/" + stepid;
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
					InsertGovrewardprocessfile(img,result, destFile);
					result.put("code", "0");
					result.put("msg", "上传成功");
					result.put("url", destFile.getPath());
				}else if(insertype.equals("update")) {
					updataGovrewardprocessfile(img,result, destFile);
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
  	
  	private void InsertGovrewardprocessfile(Govrewardprocessfile img, Map<String, String> result, File dest) {
		int row=processfileService.insertMsg(img);
		if(row > 0) {
			result.put("code", "0");
			result.put("msg", "上传成功");
		}else {
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}
	} 
  	
  	private void updataGovrewardprocessfile(Govrewardprocessfile img, Map<String, String> result, File dest) {
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
	@RequestMapping(value="getrewardfile.do",produces="application/json;charset=UTF-8")
	public Layui findProessimg(HttpServletRequest req) {
		Integer sid=Integer.parseInt(req.getParameter("sid"));
		List<Govrewardprocessfile>img=processfileService.getAllMsg(sid);
		int count =img.size();
		
		return Layui.data(count, img);

	}
  	
  	//删除流程文件
  	@ResponseBody
	@RequestMapping(value="dellrewardfile.do",produces="application/json;charset=UTF-8")
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
	@RequestMapping(value="uprewardfile.do",produces="application/json;charset=UTF-8")
	public JsonResult updataProessimg(@RequestParam(value = "requestDate") Govrewardprocessfile img) {
		
		int row=processfileService.updateMsg(img);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}

}
