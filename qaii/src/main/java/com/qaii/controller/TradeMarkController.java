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

import com.qaii.domain.Trademark;
import com.qaii.domain.Trademark;
import com.qaii.service.TradeMarkService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class TradeMarkController {
	@Resource
	private TradeMarkService trademarkService;
	
	//获取所有商标信息
	@RequestMapping(value="getAllTradeMarkMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllTradeMarkMsg() {
		List<Trademark> result=trademarkService.getAllTradeMarkMsg();
//			for(trademarkwarecopyright trademarkware:result) {
//				CountDatetoNowDays.TranstoDate(emp);
//			}
		int count =result.size();
		if(result!=null) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, result);
		}
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
	
	//跳转到商标详情页面
	@RequestMapping("toTradeMarkDetails.do")
	public String toTradeMarkDetail() {
		
		return "page/science/";
	}
	
	//商标查看详情
	@RequestMapping(value="showTradeMarkDetails.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult showTradeMarkDetails(Trademark trademark,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("userId"));
		//trademark.setId();
		trademark = trademarkService.selectByPrimaryKey(userid);
		return new JsonResult(trademark);
	}
	
	//跳转到修改商标详情页面
	@RequestMapping("UpdateTradeMark.do")
	public String toUpdateTrademark() {
		return "page/science";
	}
	
	//修改商标信息功能
	@RequestMapping(value="updateTrademark.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateTrademarks(Trademark Trademark,HttpServletRequest req){	
		loadData(req, Trademark);
		int row =trademarkService.updatetrademark(Trademark);
		if(row>=1) {
			//String data="更新成功";
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
	}
	//绑定请求数据到bean中
	void loadData(HttpServletRequest req,Trademark Trademark){
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
	public String AddTrademark(HttpServletRequest req,Trademark trademark) {
		loadData(req, trademark);		
		int row = trademarkService.insertMsg(trademark);
		if(row>0) {
//				Map<String,String> map=new HashMap<>();
//				 map.put("url","intoPerSys.do");
//				 map.put("data", "提交成功");
			 
			//return new JsonResult();
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
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

}
