package com.qaii.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

import com.qaii.domain.Govplatform;
import com.qaii.domain.Govplatform;
import com.qaii.service.GovPlatformService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class PlatformController {
	
	@Resource
	private GovPlatformService govplatformService;
	//获取所有资助平台信息
	@RequestMapping(value="getAllPlatformMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllPlatformMsg() {
		List<Govplatform> result=govplatformService.getAllPlatformMsg();
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
	//删除资助平台信息
	@RequestMapping("dellPlatformMsg.do")
	@ResponseBody
	public JsonResult dellPlatformMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govplatformService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//跳转到资助平台详情页面
	@RequestMapping("toGovplatformDetails.do")
	public String toGovplatformDetail() {
		
		return "page/science/";
	}
	
	//资助平台查看详情
	@RequestMapping(value="showGovplatformDetails.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult showGovplatformDetails(Govplatform govplatform,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("userId"));
		//Govplatform.setId();
		govplatform = govplatformService.selectByPrimaryKey(userid);
		return new JsonResult(govplatform);
	}
	
	//跳转到修改资助平台详情页面
	@RequestMapping("UpdateGovplatform.do")
	public String toUpdateGovplatform() {
		return "page/science";
	}
	
	//修改资助平台信息功能
	@RequestMapping(value="updateGovplatform.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateGovplatforms(Govplatform govplatform,HttpServletRequest req){	
		loadData(req, govplatform);
		int row =govplatformService.updateMsg(govplatform);
		if(row>=1) {
			//String data="更新成功";
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
	}
	//绑定请求数据到bean中
	void loadData(HttpServletRequest req,Govplatform govplatform){
		govplatform.setGovplatApplytime(req.getParameter("govplatApplytime"));
		govplatform.setGovplatSource(req.getParameter("govplatSource"));
		govplatform.setGovplatLevel(req.getParameter("govplatLevel"));
		govplatform.setGovplatName(req.getParameter("govplatName"));
		govplatform.setGovplatImplementtime(req.getParameter("govplatImplementtime"));
		govplatform.setGovplatDutyunit(req.getParameter("govplatDutyunit"));
		govplatform.setGovplatCooperationunit(req.getParameter("govplatCooperationunit"));
		govplatform.setGovplatManagedepart(req.getParameter("govplatManagedepart"));
		govplatform.setGovplatApplydepart(req.getParameter("govplatApplydepart"));
		govplatform.setGovplatAssumedepart(req.getParameter("govplatAssumedepart"));
		govplatform.setGovplatPlatformper(req.getParameter("govplatPlatformper"));
		govplatform.setGovplatProjectapproval(req.getParameter("govplatProjectapproval"));
		govplatform.setGovplatApprovalnum(req.getParameter("govplatApprovalnum"));
		govplatform.setGovplatSubvention(req.getParameter("govplatSubvention"));
		govplatform.setGovplatFundtime(req.getParameter("govplatFundtime"));
		govplatform.setGovplatMiddleresult(req.getParameter("govplatMiddleresult"));
		govplatform.setGovplatYearresult(req.getParameter("govplatYearresult"));
		govplatform.setGovplatEndresult(req.getParameter("govplatEndresult"));
		govplatform.setGovplatRemark(req.getParameter("govplatRemark"));
		govplatform.setGovplatFile(req.getParameter("govplatFile"));
	}
	//添加资助平台信息功能
	@RequestMapping("addGovplatform.do")
	public String AddGovplatform(HttpServletRequest req,Govplatform govplatform) {
		loadData(req, govplatform);		
		int row = govplatformService.insertMsg(govplatform);
		if(row>0) {
//							Map<String,String> map=new HashMap<>();
//							 map.put("url","intoPerSys.do");
//							 map.put("data", "提交成功");
			 
			//return new JsonResult();
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
		
	}
	
	//使用excel文件快捷导入自助平台数据
	@RequestMapping(value="insertGovplatformDatabyexcel.do")
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
					Govplatform govplatform = new Govplatform();
					govplatform=setGovplatformvalue(govplatform, list);
					if(govplatform.getGovplatApplytime()!=null)
						govplatform.setGovplatApplytime(govplatform.getGovplatApplytime().replace("/", "-"));
					if(govplatform.getGovplatImplementtime()!=null)
						govplatform.setGovplatImplementtime(govplatform.getGovplatImplementtime().replace("/", "-"));
					if(govplatform.getGovplatFundtime()!=null)
						govplatform.setGovplatFundtime(govplatform.getGovplatFundtime().replace("/", "-"));
					govplatformService.insertMsg(govplatform);
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
	public Govplatform setGovplatformvalue(Govplatform govplatform,List<String> value) {
		govplatform.setGovplatApplytime(value.get(0));
		govplatform.setGovplatSource(value.get(1));
		govplatform.setGovplatLevel(value.get(2));
		govplatform.setGovplatName(value.get(3));
		govplatform.setGovplatImplementtime(value.get(4));
		govplatform.setGovplatDutyunit(value.get(5));
		govplatform.setGovplatCooperationunit(value.get(6));
		govplatform.setGovplatManagedepart(value.get(7));
		govplatform.setGovplatApplydepart(value.get(8));
		govplatform.setGovplatAssumedepart(value.get(9));
		govplatform.setGovplatPlatformper(value.get(10));
		govplatform.setGovplatProjectapproval(value.get(11));
		govplatform.setGovplatApprovalnum(value.get(12));
		govplatform.setGovplatSubvention(value.get(13));
		govplatform.setGovplatFundtime(value.get(14));
		govplatform.setGovplatMiddleresult(value.get(15));
		govplatform.setGovplatYearresult(value.get(16));
		govplatform.setGovplatEndresult(value.get(17));
		govplatform.setGovplatRemark(value.get(18));
		govplatform.setGovplatFile(value.get(19));
		
		return govplatform;
	}

}
