package com.qaii.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.qaii.domain.Softwarecopyright;
import com.qaii.domain.Softwarecopyright;
import com.qaii.domain.User;
import com.qaii.service.SoftwarecopyrightService;
import com.qaii.util.AlertException;
import com.qaii.util.CountDatetoNowDays;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class SoftwareController {
	
	@Resource
	private SoftwarecopyrightService softwareService;

	//获取所有软著信息
	@RequestMapping(value="getAllSoftwareMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllSoftwareMsg() {
		List<Softwarecopyright> result=softwareService.getAllSoftwareMsg();
//			for(Softwarecopyright software:result) {
//				CountDatetoNowDays.TranstoDate(soft);
//			}
		int count =result.size();
		if(result!=null) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, result);
		}
	}
		
	//软著信息删除功能
	@RequestMapping("dellsoftMsg.do")
	@ResponseBody
	public JsonResult dellSoftMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=softwareService.dellsoftMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//跳转到软著详情页面
	@RequestMapping("toSoftDetails.do")
	public String toSoftDetail() {
		
		return "page/science/";
	}
	
	//软著查看详情
	@RequestMapping(value="showSoftDetails.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult showSoftDetails(Softwarecopyright soft,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("userId"));
		//soft.setId();
		soft = softwareService.selectByPrimaryKey(userid);
		return new JsonResult(soft);
	}
	
	//跳转到修改软著详情页面
	@RequestMapping("UpdateSoft.do")
	public String toUpdateSoft() {
		return "page/science";
	}
	
	//修改软著信息功能
	@RequestMapping(value="updatesofts.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updatesofts(Softwarecopyright soft,HttpServletRequest req){	
		loadData(req, soft);
		int row =softwareService.updateSoft(soft);
		if(row>=1) {
			//String data="更新成功";
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
	}
	void loadData(HttpServletRequest req,Softwarecopyright soft){
		soft.setSoftDept(req.getParameter("softDept"));
		soft.setSoftCode(req.getParameter("softCode"));
		soft.setSoftName(req.getParameter("softName"));
		soft.setSoftWriter(req.getParameter("softWriter"));
		soft.setSoftAuthor(req.getParameter("softAuthor"));
		soft.setSoftAgency(req.getParameter("softAgency"));
		soft.setSoftDevelopendtime(req.getParameter("softDevelopendtime"));
		soft.setSoftFirstpublishtime(req.getParameter("softFirstpublishtime"));
		soft.setSoftNum(req.getParameter("softNum"));
		soft.setSoftCertificatetime(req.getParameter("softCertificatetime"));
		soft.setSoftCost(req.getParameter("softCost"));
		soft.setSoftInvoiceper(req.getParameter("softInvoiceper"));
		soft.setSoftUpdatetime(req.getParameter("softUpdatetime"));
		soft.setSoftRemark(req.getParameter("softRemark"));
	}
	//添加软著信息功能
	@RequestMapping("addSoft.do")
	public String AddSoft(HttpServletRequest req,Softwarecopyright soft) {
		loadData(req, soft);		
		int row = softwareService.insertSoft(soft);
		if(row>0) {
//			Map<String,String> map=new HashMap<>();
//			 map.put("url","intoPerSys.do");
//			 map.put("data", "提交成功");
			 
			//return new JsonResult();
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
		
	}
	
	//使用excel文件快捷导入软著数据
	@RequestMapping(value="insertSoftDatabyexcel.do")
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
					Softwarecopyright soft = new Softwarecopyright();
					soft=setSoftwarecopyrightvalue(soft, list);
					if(soft.getSoftDevelopendtime()!=null)
					soft.setSoftDevelopendtime(soft.getSoftDevelopendtime().replace("/", "-"));
					if(soft.getSoftFirstpublishtime()!=null)
					soft.setSoftFirstpublishtime(soft.getSoftFirstpublishtime().replace("/", "-"));
					if(soft.getSoftCertificatetime()!=null)
					soft.setSoftCertificatetime(soft.getSoftCertificatetime().replace("/", "-"));
					if(soft.getSoftUpdatetime()!=null)
					soft.setSoftUpdatetime(soft.getSoftUpdatetime().replace("/", "-"));	
					softwareService.insertSoft(soft);
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
	public Softwarecopyright setSoftwarecopyrightvalue(Softwarecopyright Softwarecopyright,List<String> value) {
		Softwarecopyright.setSoftDept(value.get(0));
		Softwarecopyright.setSoftCode(value.get(1));
		Softwarecopyright.setSoftName(value.get(2));
		Softwarecopyright.setSoftWriter(value.get(3));
		Softwarecopyright.setSoftAuthor(value.get(4));
		Softwarecopyright.setSoftAgency(value.get(5));
		Softwarecopyright.setSoftDevelopendtime(value.get(6));
		Softwarecopyright.setSoftFirstpublishtime(value.get(7));
		Softwarecopyright.setSoftNum(value.get(8));
		Softwarecopyright.setSoftCertificatetime(value.get(9));
		Softwarecopyright.setSoftCost(value.get(10));
		Softwarecopyright.setSoftInvoiceper(value.get(11));
		Softwarecopyright.setSoftUpdatetime(value.get(12));
		Softwarecopyright.setSoftRemark(value.get(13));
		
		return Softwarecopyright;
	}
}
