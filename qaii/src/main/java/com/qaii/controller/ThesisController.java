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

import com.qaii.domain.Thesis;
import com.qaii.domain.Thesis;
import com.qaii.service.ThesisService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class ThesisController {

	@Resource
	private ThesisService thesisService;

	//获取所有论文信息
	@RequestMapping(value="getAllThesisMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllThesisMsg() {
		List<Thesis> result=thesisService.getAllThesisMsg();
//		for(Thesis thesisware:result) {
//			CountDatetoNowDays.TranstoDate(emp);
//		}
		int count =result.size();
		if(result!=null) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, result);
		}
	}
	//删除论文信息
	@RequestMapping("dellThesisMsg.do")
	@ResponseBody
	public JsonResult dellThesisMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=thesisService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//跳转到论文详情页面
	@RequestMapping("toThesisDetails.do")
	public String toThesisDetail() {
		
		return "page/science/";
	}
	
	//论文查看详情
	@RequestMapping(value="showThesisDetails.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult showThesisDetails(Thesis thesis,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("userId"));
		//thesis.setId();
		thesis = thesisService.selectByPrimaryKey(userid);
		return new JsonResult(thesis);
	}
	
	//跳转到修改论文详情页面
	@RequestMapping("UpdateThesis.do")
	public String toUpdatethesis() {
		return "page/science";
	}
	
	//修改论文信息功能
	@RequestMapping(value="updateThesis.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updatethesiss(Thesis thesis,HttpServletRequest req){	
		loadData(req, thesis);
		int row =thesisService.updateMsg(thesis);
		if(row>=1) {
			//String data="更新成功";
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
	}
	//绑定请求数据到bean中
	void loadData(HttpServletRequest req,Thesis thesis){
		thesis.setSisSubject(req.getParameter("sisSubject"));
		thesis.setSisAuthor(req.getParameter("sisAuthor"));
		thesis.setSisUnits(req.getParameter("sisUnits"));
		thesis.setSisPublishlocation(req.getParameter("sisPublishlocation"));
		thesis.setSisPublishtime(req.getParameter("sisPublishtime"));
		thesis.setSisStatus(req.getParameter("sisStatus"));
		thesis.setSisDept(req.getParameter("sisDept"));
	}
	//添加论文信息功能
	@RequestMapping("addThesis.do")
	public String Addthesis(HttpServletRequest req,Thesis thesis) {
		loadData(req, thesis);		
		int row = thesisService.insertMsg(thesis);
		if(row>0) {
//					Map<String,String> map=new HashMap<>();
//					 map.put("url","intoPerSys.do");
//					 map.put("data", "提交成功");
			 
			//return new JsonResult();
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
		
	}
	
	//使用excel文件快捷导入论文数据
	@RequestMapping(value="insertThesisDatabyexcel.do")
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
					Thesis thesis = new Thesis();
					thesis=setThesisvalue(thesis, list);
					if(thesis.getSisPublishtime()!=null)
					thesis.setSisPublishtime(thesis.getSisPublishtime().replace("/", "-"));
					thesisService.insertMsg(thesis);
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
	public Thesis setThesisvalue(Thesis thesis,List<String> value) {
		thesis.setSisSubject(value.get(0));
		thesis.setSisAuthor(value.get(1));
		thesis.setSisUnits(value.get(2));
		thesis.setSisPublishlocation(value.get(3));
		thesis.setSisPublishtime(value.get(4));
		thesis.setSisStatus(value.get(5));
		thesis.setSisDept(value.get(6));
		
		return thesis;
	}
}
