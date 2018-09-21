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

import com.qaii.domain.Work;
import com.qaii.domain.Work;
import com.qaii.service.WorkService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class WorkController {
	
	@Resource
	private WorkService workService;
	//获取所有著作信息
	@RequestMapping(value="getAllWorkMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllWorkMsg() {
		List<Work> result=workService.getAllWorkMsg();
//			for(Work workware:result) {
//				CountDatetoNowDays.TranstoDate(emp);
//			}
		int count =result.size();
		if(result!=null) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, result);
		}
	}
	//删除著作信息
	@RequestMapping("dellWorkMsg.do")
	@ResponseBody
	public JsonResult dellWorkMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=workService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//跳转到著作详情页面
	@RequestMapping("toWorkDetails.do")
	public String toworkDetail() {
		
		return "page/science/";
	}
	
	//著作查看详情
	@RequestMapping(value="showWorkDetails.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult showworkDetails(Work work,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("userId"));
		//work.setId();
		work = workService.selectByPrimaryKey(userid);
		return new JsonResult(work);
	}
	
	//跳转到修改著作详情页面
	@RequestMapping("UpdateWork.do")
	public String toUpdatework() {
		return "page/science";
	}
	
	//修改著作信息功能
	@RequestMapping(value="updateWork.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateworks(Work work,HttpServletRequest req){	
		loadData(req, work);
		int row =workService.updateMsg(work);
		if(row>=1) {
			//String data="更新成功";
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
	}
	//绑定请求数据到bean中
	void loadData(HttpServletRequest req,Work work){
		work.setWorkType(req.getParameter("workType"));
		work.setWorkTopic(req.getParameter("workTopic"));
		work.setWorkAuthor(req.getParameter("workAuthor"));
		work.setWorkPublishhouse(req.getParameter("workPublishhouse"));
		work.setWorkPublishtime(req.getParameter("workPublishtime"));
		work.setWorkDept(req.getParameter("workDept"));
	}
	//添加著作信息功能
	@RequestMapping("addWork.do")
	public String Addwork(HttpServletRequest req,Work work) {
		loadData(req, work);		
		int row = workService.insertMsg(work);
		if(row>0) {
//						Map<String,String> map=new HashMap<>();
//						 map.put("url","intoPerSys.do");
//						 map.put("data", "提交成功");
			 
			//return new JsonResult();
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
		
	}
	
	//使用excel文件快捷导入软著数据
	@RequestMapping(value="insertWorkDatabyexcel.do")
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
					Work work = new Work();
					work=setWorkvalue(work, list);
					workService.insertMsg(work);
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
	public Work setWorkvalue(Work work,List<String> value) {
		work.setWorkType(value.get(0));
		work.setWorkTopic(value.get(1));
		work.setWorkAuthor(value.get(2));
		work.setWorkPublishhouse(value.get(3));
		work.setWorkPublishtime(value.get(4));
		work.setWorkDept(value.get(5));
		
		return work;
	}

}
