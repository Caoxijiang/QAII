package com.qaii.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.qaii.domain.IncubatorRecord;
import com.qaii.service.IncubatorRecordService;
import com.qaii.util.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.Incubator;
import com.qaii.domain.IncubatorFile;
import com.qaii.domain.StockEquity;
import com.qaii.service.IncubatorFileService;
import com.qaii.service.IncubatorService;
import com.qaii.service.StockEquityService;

@Controller
public class IndustryController {
	private static String PATH="C:/File/img/industry/";
	private static String URL="https://www.zmadmin.top/";
	@Resource
	private IncubatorService incubatorService;
	@Resource
	private IncubatorFileService incubatorFileService;
	@Resource
	private StockEquityService stockEquityService;
	@Resource
	private IncubatorRecordService incubatorRecordService;


	Incubator incubator2=new Incubator();
	
	
	@RequestMapping("industry.do")
	public String science(){
		return "page/industry/industry";
	}
	//产业化处数据可视化界面
	@RequestMapping("/indexIndustry.do")
	public String indexIndustry(){
		return "page/industry/indexIndustry";
	}
	//孵化企业界面
	@RequestMapping("hatchmumber.do")
	public ModelAndView hatchmumber(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String args=req.getParameter("id");
		result.add(args);
		return new ModelAndView ("page/industry/hatch/hatchmumber","Info",result);
	}
	//孵化企业变更时间修改界面（修改界面之内）
	@RequestMapping("/hatchchangetime.do")
	public ModelAndView hatchchangetime(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String args=req.getParameter("id");
		result.add(args);
		return new ModelAndView( "page/industry/hatch/hatchchangetime","Info",result);
	}
	//孵化企业变更修改界面
	@RequestMapping("/hatchshare.do")
	public ModelAndView hatchshare(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String args=req.getParameter("id");
		result.add(args);
		return new ModelAndView ("page/industry/hatch/hatchshare","Info",result);
	}
	//孵化企业文件重新上传
	@RequestMapping("/hatchfilereload.do")
	public ModelAndView hatchfilereload(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String fid=req.getParameter("fid");
		String nid=req.getParameter("nid");
		String type=req.getParameter("imgtype1");
		result.add(fid);
		result.add(nid);
		result.add(type);
		return new ModelAndView ("page/industry/hatch/hatchfilereload","Info",result);
	}
	//孵化企业文件重新上传-发表电子版
	@RequestMapping("/hatchfilereload2.do")
	public ModelAndView hatchfilereload2(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String fid=req.getParameter("fid");
		String nid=req.getParameter("nid");
		String type=req.getParameter("imgtype2");
		result.add(fid);
		result.add(nid);
		result.add(type);
		return new ModelAndView("page/industry/hatch/hatchfilereload2","Info",result);
	}

	//孵化企业添加界面
	@RequestMapping("/hatchAdd.do")
	public String hatchAdd(){
		return "page/industry/hatch/hatchAdd";
	}
	//孵化企业成员添加界面
	@RequestMapping("/hatch.do")
	public String hatch(){
		return "page/industry/hatch/hatch";	
	}
	//孵化企业查看详情界面
	//@ResponseBody
	@RequestMapping(value="hatchCheck.do")
	public ModelAndView hatchCheck(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String args=req.getParameter("id");
		result.add(args);
		return new ModelAndView("page/industry/hatch/hatchCheck","Info",result);
	}
	//孵化企业修改界面
	@RequestMapping("hatchEdit.do")
	public ModelAndView hatchEdit(HttpServletRequest req) throws UnsupportedEncodingException{
		req.setCharacterEncoding("UTF-8");
		List<String> result=new ArrayList<String>();
		String args=req.getParameter("id");
		result.add(args);
		return new ModelAndView("page/industry/hatch/hatchEdit","Info",result);
	}
	//合作情况管理界面
	@RequestMapping("/innovate.do")
	public String innovate(){
		return "page/industry/innovate/innovate";
	}
	//合作情况管理界面添加
	@RequestMapping("/innovateAdd.do")
	public String innovateAdd(){
		return "page/industry/innovate/innovateAdd";
	}

	//合作情况管理界面重新上传
	@RequestMapping("/innovatefilereload.do")
	public String innovatefilereload(){
		return "page/industry/innovate/innovatefilereload";
	}
	//消息管理
	@RequestMapping("/indnews.do")
	public String indnews(){
		return "page/industry/indnews";
	}

	//合作情况管理界面查看详情
	@RequestMapping("/innovateCheck.do")
	public String innovateCheck(){
		return "page/industry/innovate/innovateCheck";
	}
	//合作情况管理界面修改
	@RequestMapping("/innovateEdit.do")
	public String innovateEdit(){
		return "page/industry/innovate/innovateEdit";
	}

	//院获奖情况界面
	@RequestMapping("/institute.do")
	public String institute(){
		return "page/industry/honor/institute/institute";
	}
	//院获奖情况界面 添加
	@RequestMapping("/instituteAdd.do")
	public String instituteAdd(){
		return "page/industry/honor/institute/instituteAdd";
	}

	//院获奖情况界面重新上传
	@RequestMapping("/institutefilereload.do")
	public String institutefilereload(){
		return "page/industry/honor/institute/institutefilereload";
	}

	//院获奖情况界面 查看详情
	@RequestMapping("/instituteCheck.do")
	public String instituteCheck(){
		return "page/industry/honor/institute/instituteCheck";
	}
	//院获奖情况界面  修改
	@RequestMapping("/instituteEdit.do")
	public String instituteEdit(){
		return "page/industry/honor/institute/instituteEdit";
	}

	//孵化企业获奖情况界面
	@RequestMapping("/incubate.do")
	public String incubate(){
		return "page/industry/honor/incubate/incubate";
	}
	//孵化企业获奖情况界面 添加
	@RequestMapping("/incubateAdd.do")
	public String incubateAdd(){
		return "page/industry/honor/incubate/incubateAdd";
	}

	//孵化企业获奖情况界面 重新上传
	@RequestMapping("/incubatefilereload.do")
	public String incubatefilereload(){
		return "page/industry/honor/incubate/incubatefilereload";
	}

	//孵化企业获奖情况界面查看详情
	@RequestMapping("/incubateCheck.do")
	public String incubateCheck(){
		return "page/industry/honor/incubate/incubateCheck";
	}

	//孵化企业获奖情况界面修改
	@RequestMapping("/incubateEdit.do")
	public String incubateEdit(){
		return "page/industry/honor/incubate/incubateEdit";
	}
	//个人获奖界面
	@RequestMapping("/person.do")
	public String person(){
		return "page/industry/honor/person/person";
	}
	//个人获奖界面 修改
	@RequestMapping("/personEdit.do")
	public String personEdit(){
		return "page/industry/honor/person/personEdit";
	}
	//个人获奖界面 查看详情
	@RequestMapping("/personCheck.do")
	public String personCheck(){
		return "page/industry/honor/person/personCheck";
	}
	//个人获奖界面 添加
	@RequestMapping("/personAdd.do")
	public String personAdd(){
		return "page/industry/honor/person/personAdd";
	}

	//个人获奖界面 重新上传
	@RequestMapping("/personfilereload.do")
	public String personfilereload(){
		return "page/industry/honor/person/personfilereload";
	}


	//服务企业管理界面
	@RequestMapping("/serviceFirm.do")
	public String serviceFirm(){
		return "page/industry/serviceFirm/serviceFirm";
	}
	//服务企业管理添加界面
	@RequestMapping("/serviceFirmAdd.do")
	public String serviceFirmAdd(){
		return "page/industry/serviceFirm/serviceFirmAdd";
	}

	//服务企业管理重现上传
	@RequestMapping("/serviceFirmfilereload.do")
	public String serviceFirmfilereload(){
		return "page/industry/serviceFirm/serviceFirmfilereload";
	}

	//服务企业管理查看详情界面
	@RequestMapping("/serviceFirmCheck.do")
	public String serviceFirmCheck(){
		return "page/industry/serviceFirm/serviceFirmCheck";
	}
	//服务企业管理修改界面
	@RequestMapping("/serviceFirmEdit.do")
	public String serviceFirmEdit(){
		return "page/industry/serviceFirm/serviceFirmEdit";
	}

	//消息管理
	/*@RequestMapping("/indnews.do")
	public String indnews(){
		return "page/industry/indnews";
	}*/

	// 孵化企业管理添加接口
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertIndustryInfo.do")
	public String insertIndustryInfo(@RequestParam("file") MultipartFile[] files, HttpServletRequest req)
			throws UnsupportedEncodingException, ParseException {
		req.setCharacterEncoding("utf-8");
		Incubator incubator = new Incubator();
		IncubatorFile iFile = new IncubatorFile();
		IncubatorFile iFile1 = new IncubatorFile();
		List<IncubatorFile> iFlists = new ArrayList<>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		ImgLoadResult imgLoadResult = new ImgLoadResult(files).invoke();
		if (imgLoadResult.is()) return "page/industry/inform/addFaildind";
		list2 = imgLoadResult.getList2();
		Map<String, Object> result = imgLoadResult.getResult();
		try {
			IncubatorInfo(req, incubator);
			list = (List<Map<String, Object>>) result.get("0");
			if (list != null) {
				// String file1=list.get(0).get("oleName").toString();
				iFile.setFileName(list.get(0).get("oldName").toString());
				iFile.setFilePath(list.get(0).get("URL").toString());
				iFile.setFileStyle("License");
				iFlists.add(iFile);
			}else {
				iFlists.add(iFile);
			}

			if (list2 != null) {
				iFile1.setFileName(list2.get(0).get("oldName").toString());
				iFile1.setFilePath(list2.get(0).get("URL").toString());
				iFile1.setFileStyle("Electronic");
			}
			String isThousandSailEnterprise = req.getParameter("isThousandSailEnterprise");
			incubator.setIsThousandSailEnterprise(new Byte(isThousandSailEnterprise));
			incubator.setIsBillionEnterprise(new Byte(req.getParameter("isBillionEnterprise")));

			byte isHighTechnologyEnterprise = new Byte(req.getParameter("isHighTechnologyEnterprise"));

			if (isHighTechnologyEnterprise == 0) {
				incubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
				if (list2 != null) {
					String path = list2.get(0).get("URL").toString();
					String filename = list2.get(0).get("newName").toString();
					FileLoadUtils.delFile(path, filename);
				}
			} else {
				incubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
				incubator.setCertificateTime(CountDatetoNowDays.StrconversionData(req.getParameter("certificateTime")));
				incubator.setCertificateCode(req.getParameter("certificateCode"));
				iFlists.add(iFile1);
			}
			byte isTechnologyEnterprise = new Byte(req.getParameter("isTechnologyEnterprise"));
			if (isTechnologyEnterprise == 0) {
				incubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
			} else {
				incubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
				incubator.setIncomingRegistrationCode(req.getParameter("incomingRegistrationCode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "page/industry/inform/addFaildind";

		}

		if((iFlists.get(0).getFileName())!=null){
			int row = incubatorService.insert(incubator);
			if (row > 0 ) {
				iFile.setIncubatorId(incubator.getId());
				iFile1.setIncubatorId(incubator.getId());
				int args = incubatorFileService.insert(iFlists);
				if (args > 0) {
					return "page/industry/inform/addSuccesdind";
				} else {
					return "page/industry/inform/addFaildind";
				}
			} else {
				return "page/industry/inform/addFaildind";
			}
		}else{
			return "page/industry/inform/addFaildind";
		}



	}

	//添加股东信息
	@RequestMapping(value="addShareholderInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String addShareholderInfo(HttpServletRequest req) throws UnsupportedEncodingException, ParseException {
		req.setCharacterEncoding("UTF-8");
		StockEquity stockEquity=new StockEquity();
		try {	
			stockEquity.setShareholderName(req.getParameter("shareholderName"));
			stockEquity.setContributionProportion(req.getParameter("contributionProportion"));
			stockEquity.setContributionTime(CountDatetoNowDays.StrconversionData(req.getParameter("contributionTime")));
			stockEquity.setShareholderPosition(req.getParameter("shareholderPosition"));
			stockEquity.setIncubatorId(Integer.parseInt(req.getParameter("id")));
			//这里为新增字段，在向股东表插入数据的时候默认值（0代表未处理，1代表已处理）
			stockEquity.setStatus(0);
		} catch (Exception e) {
			return ConstantUtil.INDUSTRY_INSERT_FAILD;
		}
		int row=stockEquityService.insert(stockEquity);
		if(row>0) {
			return ConstantUtil.INDUSTRY_INSERT_SUCCESS;
		}else {
			return ConstantUtil.INDUSTRY_INSERT_FAILD;
		}
	}
	
			
	
	//孵化企业管理页面
	@ResponseBody
	@RequestMapping(value="selectIndusInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui selectIndusInfo(HttpServletRequest request ) {
		List<Incubator> incubator=incubatorService.selectAlllist();
			int count =incubator.size();
			transDate(incubator);
			if(incubator!=null) {
				return Layui.data(count, incubator);
			}else {
				return Layui.data(count, incubator);
			}
		
		}

	private void transDate(List<Incubator> incubator) {
		Iterator<Incubator> ite = incubator.iterator();
		while(ite.hasNext()){
			Incubator incub = ite.next();
			incub.setIsThousand(incub.getIsThousandSailEnterprise() == 1?"是":"否");
			incub.setIsHighTechnology(incub.getIsHighTechnologyEnterprise() == 1?"是":"否");
			incub.setIsBillion(incub.getIsBillionEnterprise() == 1?"是":"否");
		}
	}


	//孵化企业详情页面
	@ResponseBody
	@RequestMapping(value="selectIndusCheckInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult selectIndusCheckInfo(HttpServletRequest req) throws UnsupportedEncodingException {
			req.setCharacterEncoding("UTF-8");
			Incubator incubator=new Incubator();
			List<IncubatorFile> iFile=new ArrayList<>();
			List<Object>list=new ArrayList<>();
			Integer id=Integer.parseInt(req.getParameter("id"));
			incubator= incubatorService.selectByPrimaryKey(id);
			iFile=incubatorFileService.selectByPrimaryKey(id);
			for (IncubatorFile file :iFile){
				String o1= file.getFilePath();
				String o2=o1.substring(8);
				file.setFilePath(URL+o2);
			}
//			System.out.println(iFile.get(0).getFileName());
			incubator2=incubator;
			list.add(incubator);
			list.add(iFile);
			if(incubator!=null) {
				return new JsonResult(list);
			}else {
				return new JsonResult();
			}
					
		}
	
	//孵化企业股东详情页面
	@ResponseBody
	@RequestMapping(value="selectIndusStackInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui selectIndusStackInfo(HttpServletRequest req) throws UnsupportedEncodingException {
			req.setCharacterEncoding("UTF-8");
			List<StockEquity> stockEquity=new ArrayList<>();
			Integer id=Integer.parseInt(req.getParameter("id"));
			stockEquity=stockEquityService.selectByPrimaryKey(id);
			int count =stockEquity.size();
			if(stockEquity!=null) {
				return Layui.data(count, stockEquity);
			}else {
				return Layui.data(count, stockEquity);
			}
		
		}
	
	
	//更新孵化企业信息
	@RequestMapping(value="updateIndusInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateIndusInfo(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		Incubator oldImcubator=incubator2;
		Integer idString=oldImcubator.getId();
		Incubator newIncubator=new Incubator();
		newIncubator.setId(idString);
		Map<String,String>result=new HashMap<>();
		try {
			IncubatorInfo(req, newIncubator);
			byte isTechnologyEnterprise = new Byte(req.getParameter("isTechnologyEnterprise"));
			if (isTechnologyEnterprise == 0) {
				newIncubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
			} else {
				newIncubator.setIsTechnologyEnterprise(isTechnologyEnterprise);
				newIncubator.setIncomingRegistrationCode(req.getParameter("incomingRegistrationCode"));
			}
			byte isHighTechnologyEnterprise = new Byte(req.getParameter("isHighTechnologyEnterprise"));
			if (isHighTechnologyEnterprise == 0) {
				newIncubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
			}else {
				newIncubator.setIsHighTechnologyEnterprise(isHighTechnologyEnterprise);
				newIncubator.setCertificateTime(CountDatetoNowDays.StrconversionData(req.getParameter("certificateTime")));
				newIncubator.setCertificateCode(req.getParameter("certificateCode"));
			}
			
			String isThousandSailEnterprise = req.getParameter("isThousandSailEnterprise");
			newIncubator.setIsThousandSailEnterprise(new Byte(isThousandSailEnterprise));
			newIncubator.setIsBillionEnterprise(new Byte(req.getParameter("isBillionEnterprise")));
		} catch (ParseException e) {
			e.printStackTrace();
			return ConstantUtil.INDUSTRY_EDIT_FAILD;
		}

		int row= incubatorService.updateByPrimaryKeySelective(newIncubator);
		if(row>0) {
			BeanChangeUtil<T> tBeanChangeUtil=new BeanChangeUtil<>();
 			List<Map<String, Object>> strlist=tBeanChangeUtil.contrastObj(oldImcubator,newIncubator,idString.toString());
	        if (strlist.size()==0) {
	        	String recordmsg="";
	        	result.put("recordmsg",recordmsg);
	        	return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
	        } else {
	        	List<IncubatorRecord> list=new ArrayList<>();
				String time=DateUtils.getFullDate();
				Date times=DateUtils.parseStringToDate(time);
	        	for (Map map :strlist){
					Object list_name=map.get("list_name");
					Object old_name=map.get("old_name");
					Object new_name=map.get("new_name");
					Object pid=map.get("id");
					IncubatorRecord incubatorRecord=new IncubatorRecord();
					incubatorRecord.setListName(list_name.toString());
					incubatorRecord.setChangedTime(times);
					incubatorRecord.setOldName(old_name.toString());
					incubatorRecord.setNewName(new_name.toString());
					incubatorRecord.setPid(Integer.parseInt(pid.toString()));
					list.add(incubatorRecord);
				}
	        	int rows=incubatorRecordService.insert(list);
	        	if(rows!=0){
					String recordmsg="SSUCCESS";
					String recordres=strlist.toString();
					result.put("recordmsg",recordmsg);
					result.put("recordres",recordmsg);
					return ConstantUtil.INDUSTRY_EDIT_SUCCESS;
				}else{
					String recordmsg="DBERROR";
					result.put("recordmsg",recordmsg);
					return ConstantUtil.INDUSTRY_EDIT_FAILD;
				}

	        }
		}else {
			return ConstantUtil.INDUSTRY_EDIT_FAILD;
		}




	}

	//删除孵化企业管理
	@ResponseBody
	@RequestMapping(value="dellIndusStackInfo.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult dellIndusStackInfo(@RequestParam(value = "requestDate[]") Integer[] id) throws UnsupportedEncodingException {

		int row=incubatorService.deleteByPrimaryKey(id);
		if(row!=0) {
			return  new JsonResult(row);
		}else {
			return  new JsonResult();

		}
	}

	//更新孵化企业营业执照
	@RequestMapping(value="updateLicense.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateLicense(@RequestParam("file") MultipartFile[] files, HttpServletRequest req){
		Map<String, Object> result = new HashMap<>();
		List<IncubatorFile> file=new ArrayList<>();
		IncubatorFile in=new IncubatorFile();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			String fid=req.getParameter("fid");
			Integer fids=null;
			if(!fid.equals("")){
				fids=Integer.parseInt(fid);
			}
			Integer nid=Integer.parseInt(req.getParameter("nid"));
			String type=req.getParameter("type");
			result=FileLoadUtils.fileload(files, PATH);
			list = (List<Map<String, Object>>) result.get("0");
			in.setFileName(list.get(0).get("oldName").toString());
			in.setFilePath(list.get(0).get("URL").toString());
			in.setFileStyle(type);
			in.setId(fids);
			in.setIncubatorId(nid);
			file.add(in);
			if(fids==null){
				int row=incubatorFileService.insert(file);
				return Result(row);
			}else {
				int row=incubatorFileService.updateByPrimaryKey(file);
				return Result(row);
			}


		} catch (IOException e) {
			e.printStackTrace();
			return "page/industry/inform/addFaildind";
		}

	}

	private String Result(int row) {
		if(row!=0){
			return "page/industry/inform/addSuccesdind";
		}else {
			return "page/industry/inform/addFaildind";
		}
	}


	private void IncubatorInfo(HttpServletRequest req, Incubator incubator) throws ParseException {
		incubator.setCompanyName(req.getParameter("companyName"));
		incubator.setCreditCode(req.getParameter("creditCode"));
		String establishTime = req.getParameter("establishTime");
		incubator.setEstablishTime(CountDatetoNowDays.StrconversionData(establishTime));
		incubator.setCompanyType(req.getParameter("companyType"));
		incubator.setCompanyLocation(req.getParameter("companyLocation"));
		incubator.setLegalRepresentative(req.getParameter("legalRepresentative"));
		incubator.setRegisteredCapital(req.getParameter("registeredCapital"));
		incubator.setBusinessScope(req.getParameter("businessScope"));
		incubator.setIncubatorName(req.getParameter("incubatorName"));
		incubator.setHatchingTime(CountDatetoNowDays.StrconversionData(req.getParameter("hatchingTime")));
		incubator.setLimitedPeriod(req.getParameter("limitedPeriod"));
	}

	//导入孵化企业信息
	@RequestMapping(value="insertIncubatorOfExcel.do",method=RequestMethod.POST)
	@ResponseBody
	Layui insertIncubatorOfExcel(@RequestParam("file")MultipartFile file,Incubator incubator) throws IOException, CustomException {
		List<String> list =new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String filename=file.getOriginalFilename();
		Workbook wookbook;
		//判断是不是excel文件
		if(!(filename.endsWith(".xls")||filename.endsWith(".xlsx")))
			return  new Layui();
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
					setExcelCellsvalue(incubator, list);
					incubator.setId(null);
					incubatorService.insert(incubator);
				}
			}
		}catch(Exception e) {
			wookbook.close();
			e.printStackTrace();
			throw new CustomException("数据库异常!请检查文件格式!");
		}
		wookbook.close();
		return Layui.data(1, null);
	}

	private void setExcelCellsvalue(Incubator incubator, List<String> list) throws ParseException {
		incubator.setCompanyName(list.get(0));
		incubator.setCreditCode(list.get(1));
		incubator.setEstablishTime(CountDatetoNowDays.StringConvertToDate(list.get(2)));
		incubator.setCompanyType(list.get(3));
		incubator.setCompanyLocation(list.get(4));
		incubator.setLegalRepresentative(list.get(5));
		incubator.setRegisteredCapital(list.get(6));
		incubator.setBusinessScope(list.get(7));
		incubator.setIncubatorName(list.get(8));
		incubator.setHatchingTime(CountDatetoNowDays.StringConvertToDate(list.get(9)));
		incubator.setLimitedPeriod(list.get(10));
		incubator.setIsThousandSailEnterprise("是".equals(list.get(11))?new Byte("1"):new Byte("0"));
		incubator.setIsHighTechnologyEnterprise("是".equals(list.get(11))?new Byte("1"):new Byte("0"));
		incubator.setIsBillionEnterprise("是".equals(list.get(11))?new Byte("1"):new Byte("0"));
		incubator.setRemark(list.get(14));
	}

	@RequestMapping("deleteIncubatorStockEquity.do")
	@ResponseBody
	JsonResult deleteIncubatorStockEquity(@RequestParam("id")Integer id){
		int result = stockEquityService.deleteByPrimaryKey(id);
		if (result != 0){
			return new JsonResult(result);
		}else {
			return new JsonResult();
		}
	}
}

