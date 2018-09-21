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

import com.qaii.domain.Govfund;
import com.qaii.domain.Govfund;
import com.qaii.service.GovFundService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class FundController {

	@Resource
	private GovFundService govfundService;
	//获取所有基金信息
	@RequestMapping(value="getAllFundMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllFundMsg() {
		List<Govfund> result=govfundService.getAllFundMsg();
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
	//删除基金信息
	@RequestMapping("dellFundMsg.do")
	@ResponseBody
	public JsonResult dellFundMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govfundService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//跳转到基金详情页面
	@RequestMapping("toGovfundDetails.do")
	public String toGovfundDetail() {
		
		return "page/science/";
	}
	
	//基金查看详情
	@RequestMapping(value="showGovfundDetails.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult showGovfundDetails(Govfund govfund,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("userId"));
		//Govfund.setId();
		govfund = govfundService.selectByPrimaryKey(userid);
		return new JsonResult(govfund);
	}
	
	//跳转到修改基金详情页面
	@RequestMapping("UpdateGovfund.do")
	public String toUpdateGovfund() {
		return "page/science";
	}
	
	//修改基金信息功能
	@RequestMapping(value="updateGovfund.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateGovfunds(Govfund govfund,HttpServletRequest req){	
		loadData(req, govfund);
		int row =govfundService.updateMsg(govfund);
		if(row>=1) {
			//String data="更新成功";
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
	}
	//绑定请求数据到bean中
	void loadData(HttpServletRequest req,Govfund govfund){
		govfund.setGovfundApplytime(req.getParameter("govfundApplytime"));
		govfund.setGovfundSource(req.getParameter("govfundSource"));
		govfund.setGovfundLevel(req.getParameter("govfundLevel"));
		govfund.setGovfundName(req.getParameter("govfundName"));
		govfund.setGovfundImplementtime(req.getParameter("govfundImplementtime"));
		govfund.setGovfundConstructunit(req.getParameter("govfundConstructunit"));
		govfund.setGovfundManagedepart(req.getParameter("govfundManagedepart"));
		govfund.setGovfundApplydepart(req.getParameter("govfundApplydepart"));
		govfund.setGovfundPass(req.getParameter("govfundPass"));
		govfund.setGovfundWrittentime(req.getParameter("govfundWrittentime"));
		govfund.setGovfundFundlimit(req.getParameter("govfundFundlimit"));
		govfund.setGovfundFund(req.getParameter("govfundFund"));
		govfund.setGovfundFundtime(req.getParameter("govfundFundtime"));
		govfund.setGovfundMiddleresult(req.getParameter("govfundMiddleresult"));
		govfund.setGovfundEndresult(req.getParameter("govfundEndresult"));
		govfund.setGovfundRemark(req.getParameter("govfundRemark"));
		govfund.setGovfundFile(req.getParameter("govfundFile"));
	}
	//添加基金信息功能
	@RequestMapping("addGovfund.do")
	public String AddGovfund(HttpServletRequest req,Govfund govfund) {
		loadData(req, govfund);		
		int row = govfundService.insertMsg(govfund);
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
	
	//使用excel文件快捷导入基金数据
	@RequestMapping(value="insertGovfundDatabyexcel.do")
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
					Govfund govfund = new Govfund();
					govfund=setGovfundvalue(govfund, list);
					if(govfund.getGovfundApplytime()!=null)
						govfund.setGovfundApplytime(govfund.getGovfundApplytime().replace("/", "-"));
					if(govfund.getGovfundImplementtime()!=null)
						govfund.setGovfundImplementtime(govfund.getGovfundImplementtime().replace("/", "-"));
					if(govfund.getGovfundWrittentime()!=null)
						govfund.setGovfundWrittentime(govfund.getGovfundWrittentime().replace("/", "-"));
					if(govfund.getGovfundFundtime()!=null)
						govfund.setGovfundFundtime(govfund.getGovfundFundtime().replace("/", "-"));
					govfundService.insertMsg(govfund);
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
	public Govfund setGovfundvalue(Govfund govfund,List<String> value) {
		govfund.setGovfundApplytime(value.get(0));
		govfund.setGovfundSource(value.get(1));
		govfund.setGovfundLevel(value.get(2));
		govfund.setGovfundName(value.get(3));
		govfund.setGovfundImplementtime(value.get(4));
		govfund.setGovfundConstructunit(value.get(5));
		govfund.setGovfundManagedepart(value.get(6));
		govfund.setGovfundApplydepart(value.get(7));
		govfund.setGovfundPass(value.get(8));
		govfund.setGovfundWrittentime(value.get(9));
		govfund.setGovfundFundlimit(value.get(10));
		govfund.setGovfundFund(value.get(11));
		govfund.setGovfundFundtime(value.get(12));
		govfund.setGovfundMiddleresult(value.get(13));
		govfund.setGovfundEndresult(value.get(14));
		govfund.setGovfundRemark(value.get(15));
		govfund.setGovfundFile(value.get(16));

		
		return govfund;
	}
}
