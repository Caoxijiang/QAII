package com.qaii.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.DeptInfo;
import com.qaii.domain.EmpInfo;
import com.qaii.service.DeptInfoService;
import com.qaii.service.EmpInfoService;
import com.qaii.service.impl.EmpInfoServiceImpl;
import com.qaii.util.CountDatetoNowDays;
import com.qaii.util.CustomException;
import com.qaii.util.Layui;

import net.sf.json.JSONObject;

@Controller
public class testCheckController {

	@Resource
	private EmpInfoService empinfo;
	@Resource
	private DeptInfoService deptinfo;
	
	@RequestMapping("tstchk.do")
	public String tstest() {
		
		return "page/testchk";
	}
	//将时间转为时间戳方法
	@RequestMapping(value="setdata.do",method=RequestMethod.POST)
	@ResponseBody
	public String outputStamp(@RequestParam(value="date",required=false)String date
			) throws CustomException, ParseException, FileNotFoundException, IOException {

		return CountDatetoNowDays.SDatetoStamp(date);
	}
	//将时间转为时间戳方法
	@RequestMapping(value="setdata2.do",method=RequestMethod.POST)
	@ResponseBody
	public String outputDate(@RequestParam(value="date",required=false)String date
			){
		return CountDatetoNowDays.StamptoDate(date);
	}
	
	@RequestMapping(value="getfile.do",method=RequestMethod.POST)
	@ResponseBody
	public void test(@RequestParam("file")MultipartFile file) throws FileNotFoundException, IOException, CustomException  {
		List<String> list =new ArrayList<>();
		String filename=file.getOriginalFilename();
		Workbook wookbook;
		//判断是不是excel文件
		if(!(filename.endsWith(".xls")||filename.endsWith(".xlsx")))
			throw new CustomException("This is not an Excel file!");
		//判断是03版还是07版excel
		if(filename.endsWith(".xls")) {
			wookbook=new HSSFWorkbook(file.getInputStream());
		}else {
			wookbook=new XSSFWorkbook(file.getInputStream());
		}
		Sheet sheet=wookbook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		for (int i=1;i<rows;i++) {
			Row row =sheet.getRow(i);
			int cells=sheet.getRow(0).getPhysicalNumberOfCells();
			if (row!=null) {
				list.clear();
				EmpInfo emp = new EmpInfo();
				for (int j=1;j<cells;j++) {
					Cell cell=row.getCell(j);
					if(cell!=null){
						cell.setCellType(Cell.CELL_TYPE_STRING);
						list.add(cell.toString());
					}else {
						list.add(null);
					}
				}
				emp=setEmpInfovalue(emp, list);
				empinfo.insert(emp);
			}
		}
		wookbook.close();
		
	}
	
	public EmpInfo setEmpInfovalue(EmpInfo empInfo,List<String> value) {
		empInfo.setEid(value.get(0));
		empInfo.setEmpNum(value.get(1));
		empInfo.setEmpName(value.get(2));
		empInfo.setEmpGender(value.get(3));
		empInfo.setEmpDept(value.get(4));
		empInfo.setEmpPosition(value.get(5));
		empInfo.setEmpHireStarttime(value.get(6));
		empInfo.setEmpIdcard(value.get(7));
		empInfo.setEmpIdcardEndtime(value.get(8));
		empInfo.setEmpEthnic(value.get(9));
		empInfo.setEmpPoliticallandscape(value.get(10));
		empInfo.setEmpMaritalstatus(value.get(11));
		empInfo.setEmpFirsteducation(value.get(12));
		empInfo.setEmpSecondeducation(value.get(13));
		empInfo.setEmpThirdeducation(value.get(14));
		empInfo.setEmpFirsteducationschool(value.get(15));
		empInfo.setEmpSecondeducationschool(value.get(16));
		empInfo.setEmpThirdeducationschool(value.get(17));
		empInfo.setEmpFirsteducationpro(value.get(18));
		empInfo.setEmpSecondeducationpro(value.get(19));
		empInfo.setEmpSecondeducationpro(value.get(20));
		empInfo.setEmpFirstgraduationtime(value.get(21));
		empInfo.setEmpSecondgraduationtime(value.get(22));
		empInfo.setEmpThirdgraduationtime(value.get(23));
		empInfo.setEmpJobtitle(value.get(24));
		empInfo.setEmpJobtitlelevel(value.get(25));
		empInfo.setEmpJobtitleobtaintime(value.get(26));
		empInfo.setEmpPhone(value.get(27));
		empInfo.setEmpEmergencycontactandphone(value.get(28));
		empInfo.setEmpFileaddress(value.get(29));
		empInfo.setEmpAccountaddress(value.get(30));
		empInfo.setEmpHomeaddress(value.get(31));
		empInfo.setEmpWorktype(value.get(32));
		empInfo.setEmpCompile(value.get(33));
		empInfo.setEmpInductiontime(value.get(34));
		empInfo.setEmpTryoutendtime(value.get(35));
		empInfo.setEmpContractendtime(value.get(36));
		empInfo.setEmpContractsignednum(Integer.parseInt(value.get(37)));
		empInfo.setEmpReturnee(value.get(38));
		empInfo.setEmpForeign(value.get(39));
		empInfo.setEmpRemarks(value.get(40));
		empInfo.setEmpReviewstatus(value.get(41));
		empInfo.setEmpStat(value.get(42));
		empInfo.setEmpDepartureTime(value.get(43));
		empInfo.setEmpTryStatus(value.get(44));
		empInfo.setEmpContractStatus(value.get(45));
		empInfo.setEmpTitle(value.get(46));
		return empInfo;
	}
	
}
