package com.qaii.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.qaii.domain.DeptInfo;
import com.qaii.domain.EmpAvatarinfo;
import com.qaii.domain.EmpInfo;
import com.qaii.domain.User;
import com.qaii.service.DeptInfoService;
import com.qaii.service.EmpAvatarService;
import com.qaii.service.EmpInfoService;
import com.qaii.util.AlertException;
import com.qaii.util.CountDatetoNowDays;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class EmpController {
	@Resource
	private EmpInfoService empInfoService;
	@Resource
	private EmpAvatarService empAvatarService;
	@Resource
	private DeptInfoService deptInfoService;

	//修改员工信息页面
	@RequestMapping(value="updateEmpInfo.do",produces="application/json;charset=UTF-8")
	public String updateEmpInfo() {
		return "page/personnel/editdetail";
	}



	@RequestMapping(value="delldellEmpInfo.do",produces="application/json;charset=UTF-8")
	public String dellEmpInfo() {
		return "page/personnel/delPersonnel";
	}


	@RequestMapping(value="seeEmpInfo.do",produces="application/json;charset=UTF-8")
	public String seeEmpInfo() {

		return "page/personnel/checkdetail";

	}


	//添加员工信息接口
	//@ResponseBody
    @RequestMapping(value="addEmpInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String addEmpInfo(HttpServletRequest req, EmpInfo empInfo) throws ParseException {
		 HttpSession session = req.getSession();
	     User user = (User)session.getAttribute("user");
	     if(user!=null) {
	    	 empInfo.setEmpReviewstatus("通过");
	     }else {
	    	 empInfo.setEmpReviewstatus("待审核");
	     }

		EmpInfo(req, empInfo);
		empInfo.setEmpStat("1");
		empInfo.setEmpDepartureTime("");
		empInfo.setEmpTryStatus("1");
		empInfo.setEmpContractStatus("1");
		CountDatetoNowDays.TranstoStamp(empInfo);

		int row = empInfoService.insert(empInfo);
		if(row>0) {
			Map<String,String> map=new HashMap<>();
			 map.put("url","intoPerSys.do");
			 map.put("data", "提交成功");

			//return new JsonResult();
			 return "page/science/add-succesd";
		}else {

			return "page/science/add-faild";
			//return new JsonResult();
		}

	}







		//员工图片上传
		@ResponseBody
	 	@RequestMapping("/EmpAupload.do")
	    public Map<String,String> upload(@RequestParam("file") MultipartFile file , EmpAvatarinfo EMpA,HttpServletRequest request) throws Exception{
	  //  System.out.println(request.getParameter("name"));
	    Map<String,String> result=new HashMap<>();
	    if(file.isEmpty()) {
	    	result.put("code", "1");
	    	result.put("msg", "文件为空");
	    }
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        //获得文件类型（可以判断如果不是图片，禁止上传）
        String contentType=EMpA.getFile().getContentType();
        //获得文件后缀名
        String suffixName=contentType.substring(contentType.indexOf("/")+1);
        //得到 文件名
        String fileName=uuid+"."+suffixName;

	  //  String fileName=file.getOriginalFilename();
	    int size=(int)file.getSize();
	  //  System.out.println(fileName+":---"+size);
	    String path="C:/File/img";
	    File dest =new File(path+"/"+fileName);
	    if(!dest.getParentFile().exists()) {
	    	dest.getParentFile().mkdirs();
	    }
	    try {
			file.transferTo(dest);//保存文件
			EMpA.setUrl("/img/"+fileName);
			InsertEmpAvator(EMpA, result, dest);
			result.put("code", "0");
			result.put("msg", "上传成功");
			result.put("url", dest.getPath());
		} catch (IllegalStateException e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}

	    return result;

	    }









	//获取员工信息接口
	@ResponseBody
	@RequestMapping(value="findAllEmpInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui findAllEmpInfo(HttpServletRequest req) {
		List<EmpInfo> empInfo=empInfoService.findAllEmpInfo();
		for(EmpInfo emp:empInfo) {
			CountDatetoNowDays.TranstoDate(emp);
		}

		int count =empInfo.size();
			if(empInfo!=null) {
				return Layui.data(count, empInfo);
			}else {
				return Layui.data(count, empInfo);
			}
	}


	@RequestMapping(value="getallinjobEmp.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getallinjobEmp(HttpServletRequest req) {
		List<EmpInfo> empInfo=empInfoService.getallinjobEmp();
		for(EmpInfo emp:empInfo) {
			CountDatetoNowDays.TranstoDate(emp);
		}
		int count =empInfo.size();
		if(empInfo!=null) {
			return Layui.data(count, empInfo);
		}else {
			return Layui.data(count, empInfo);
		}
	}


	@ResponseBody
	@RequestMapping(value="seeEmpInfos.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JsonResult seeEmpInfos(EmpInfo emp,HttpServletRequest req) {

		int userid=Integer.parseInt(req.getParameter("userId"));
		//emp.setId();
		emp = empInfoService.findEmpinfoAndAvatarByid(userid);
		if(emp!=null) {
			CountDatetoNowDays.TranstoDate(emp);
			return new JsonResult(emp);
		}else {
			return new JsonResult();
		}

	}


	//修改员工信息
//	@ResponseBody
	@RequestMapping(value="updateEmpInfos.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateEmpInfos(EmpInfo empInfo,HttpServletRequest req) throws ParseException {
		EmpInfo(req, empInfo);
		empInfo.setEmpStat(req.getParameter("empStat"));
		empInfo.setEmpDepartureTime(req.getParameter("empDepartureTime"));
		empInfo.setEmpTryStatus(req.getParameter("empTryStatus"));
		empInfo.setEmpContractStatus(req.getParameter("empContractStatus"));
		empInfo.setId(Integer.parseInt(req.getParameter("userId")));
		CountDatetoNowDays.TranstoStamp(empInfo);
		int row =empInfoService.updateByPrimaryKey(empInfo);
		if(row>=1) {
			//String data="更新成功";
			 return "page/science/add-succesd";
		}else {

			return "page/science/add-faild";
			//return new JsonResult();
		}



	}

	//删除员工信息
    @ResponseBody
    @RequestMapping(value="DellempInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult DellempInfo(@RequestParam(value = "requestDate[]") Integer[] eid ){

     	int row=empInfoService.delete(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();

    	}

    }

	//离职员工信息
    @ResponseBody
    @RequestMapping(value="dellempInfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    public JsonResult dellempInfo(@RequestParam(value = "requestDate") Integer id ){

    	long time=System.currentTimeMillis();
    	EmpInfo emp=new EmpInfo();
    	emp.setId(id);
    	emp.setEmpDepartureTime(String.valueOf(time));
     	int row=empInfoService.updataempStatus(emp);
    	if(row>=1) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();

    	}

    }


	//获取离职员工信息接口
	@ResponseBody
	@RequestMapping(value="dellEMpinfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui dellEMpinfo(HttpServletRequest req) {
		List<EmpInfo> empInfo=empInfoService.findDellInfoByStatus();
		for (EmpInfo emp:empInfo) {
			CountDatetoNowDays.TranstoDate(emp);
		}
		int count =empInfo.size();
			if(empInfo!=null) {
				return Layui.data(count, empInfo);
			}else {
				return Layui.data(count, empInfo);
			}
	}


	//根据时间段查询员工列表
	@ResponseBody
	@RequestMapping(value="findTimpEMpinfo.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui findTimpEMpinfo(HttpServletRequest req) throws ParseException {
		//EmpInfo emp=new EmpInfo();


		String startTime=req.getParameter("startTime");
		String endTime=req.getParameter("endTime");


		List<EmpInfo> empInfo=empInfoService.findTimpEMpinfo(CountDatetoNowDays.SDatetoStamp(startTime), CountDatetoNowDays.SDatetoStamp(endTime));
		for (EmpInfo emps:empInfo) {
			CountDatetoNowDays.TranstoDate(emps);
			System.out.println(emps.getEmpName());
		}
		int count =empInfo.size();
			if(empInfo!=null) {
				return Layui.data(count, empInfo);
			}else {
				return Layui.data(count, empInfo);
			}
	}







	private void InsertEmpAvator(EmpAvatarinfo EMpA, Map<String, String> result, File dest) {
		int row=empAvatarService.insert(EMpA);
		if(row > 0) {
			int eid=EMpA.getId();
			if(eid>=1) {
				result.put("code", "0");
				result.put("msg", "上传成功");
				result.put("eid",EMpA.getId().toString() );
				result.put("url", dest.getPath());

			}else {
				result.put("code", "1");
		    	result.put("msg", "上传失败");
			}
		}else {
			result.put("code", "1");
	    	result.put("msg", "上传失败");
		}
	}




	private void EmpInfo(HttpServletRequest req, EmpInfo empInfo) throws ParseException {
		//System.out.println("---------------:"+);

		empInfo.setEid(req.getParameter("imageVal"));
		empInfo.setEmpName(req.getParameter("empName"));
		empInfo.setEmpGender(req.getParameter("empGender"));
		empInfo.setEmpDept(req.getParameter("empDept"));
		empInfo.setEmpPosition(req.getParameter("empPosition"));
		empInfo.setEmpHireStarttime(req.getParameter("empHireStarttime"));
		empInfo.setEmpIdcard(req.getParameter("empIdcard"));
		empInfo.setEmpIdcardEndtime(req.getParameter("empIdcardEndtime"));
		empInfo.setEmpEthnic(req.getParameter("empEthnic"));
		empInfo.setEmpPoliticallandscape(req.getParameter("empPoliticallandscape"));
		empInfo.setEmpMaritalstatus(req.getParameter("empMaritalstatus"));
		empInfo.setEmpFirsteducation(req.getParameter("empFirsteducation"));
		empInfo.setEmpSecondeducation(req.getParameter("empSecondeducation"));
		empInfo.setEmpThirdeducation(req.getParameter("empThirdeducation"));
		empInfo.setEmpFirsteducationschool(req.getParameter("empFirsteducationschool"));
		empInfo.setEmpSecondeducationschool(req.getParameter("empSecondeducationschool"));
		empInfo.setEmpThirdeducationschool(req.getParameter("empThirdeducationschool"));
		empInfo.setEmpFirsteducationpro(req.getParameter("empFirsteducationpro"));
		empInfo.setEmpSecondeducationpro(req.getParameter("empSecondeducationpro"));
		empInfo.setEmpThirdeducationpro(req.getParameter("empThirdeducationpro"));
		empInfo.setEmpFirstgraduationtime(req.getParameter("empFirstgraduationtime"));
		empInfo.setEmpSecondgraduationtime(req.getParameter("empSecondgraduationtime"));
		empInfo.setEmpThirdgraduationtime(req.getParameter("empThirdgraduationtime"));
		empInfo.setEmpJobtitle(req.getParameter("empJobtitle"));
		empInfo.setEmpJobtitlelevel(req.getParameter("empJobtitlelevel"));
		empInfo.setEmpJobtitleobtaintime(req.getParameter("empJobtitleobtaintime"));
		empInfo.setEmpPhone(req.getParameter("empPhone"));
		empInfo.setEmpEmergencycontactandphone(req.getParameter("empEmergencycontactandphone"));
		empInfo.setEmpFileaddress(req.getParameter("empFileaddress"));
		empInfo.setEmpAccountaddress(req.getParameter("empAccountaddress"));
		empInfo.setEmpHomeaddress(req.getParameter("empHomeaddress"));
		empInfo.setEmpWorktype(req.getParameter("empWorktype"));
		empInfo.setEmpCompile(req.getParameter("empCompile"));
		empInfo.setEmpInductiontime(req.getParameter("empInductiontime"));
		empInfo.setEmpTryoutendtime(req.getParameter("empTryoutendtime"));
		empInfo.setEmpContractendtime(req.getParameter("empContractendtime"));
		empInfo.setEmpContractsignednum(Integer.parseInt(req.getParameter("empContractsignednum")));
		empInfo.setEmpReturnee(req.getParameter("empReturnee"));
		empInfo.setEmpForeign(req.getParameter("empForeign"));
		empInfo.setEmpRemarks(req.getParameter("empRemarks"));
		empInfo.setEmpTitle(req.getParameter("empTitle"));
		empInfo.setEmpOthereducation(req.getParameter("empOthereducation"));
		empInfo.setEmpOthereducationschool(req.getParameter("empOthereducationschool"));
		empInfo.setEmpOthereducationpro(req.getParameter("empOthereducationpro"));
		empInfo.setEmpOthergraduationtime(req.getParameter("empOthergraduationtime"));


		//CountDatetoNowDays.TranstoStamp(empInfo);
	}

	//取得每个月的新入职、离职、净增长、院总人数
	public Map<String, Integer> geteachMonthMsg(String date) throws ParseException{
		Map<String, Integer> result=new HashMap<>();
		Map<String, String> map=CountDatetoNowDays.SgetfistDay(date);
		//取得当月新入职的人数
		result.put("Entry", empInfoService.countEntry(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		//获取当月离职的人数
		result.put("Departure", empInfoService.countDepart(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		//取得当月净增长数据
		result.put("Growth", empInfoService.countEntry(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this")))
				-empInfoService.countDepart(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		//取得当月院总人数
		result.put("Total", empInfoService.countnumofcollege(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		return result;
	}

	//取得人才队伍柱状图参数
	public Map<String, Integer> gettalentsTeam(String date) throws ParseException{
		List<DeptInfo>list=deptInfoService.findAllRoleList();
		List<String> s=new ArrayList<>();
		for(DeptInfo s1:list) {
			s.add(s1.getDeptName());
		}
		Map<String, String> map=new HashMap<>();
		Map<String, Integer> result=new HashMap<>();
		map=CountDatetoNowDays.FirstandEndDayofYear(date);
		result.put("total", empInfoService.countnumofIncubationComp(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this"))));
		result.put("collegenum", empInfoService.countnumofcollegeComp(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this")),s));
		result.put("Incnum", empInfoService.countnumofIncubationComp(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this")))
				-empInfoService.countnumofcollegeComp(CountDatetoNowDays.SDatetoStamp(map.get("last")), CountDatetoNowDays.SDatetoStamp(map.get("this")),s));
		return result;

	}

	//取得人才队伍饼状图数据方法
	public int gettalentsdept(String dept){
		return empInfoService.countnumfoTalents(dept);
	}

	//取得高端人才数据方法
	public int gethighttalents(String title) {
		return empInfoService.countHigherTalents(title);

	}

	//取得所有合同期到期日期小于30天的人员名单
	@RequestMapping(value="getContractMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public List<EmpInfo> getContractEndtimePerson(@RequestParam("date") String date) throws ParseException {
		date=CountDatetoNowDays.DateaddDays(date,30);
		List<EmpInfo> list=empInfoService.getcontractmsg(CountDatetoNowDays.SDatetoStamp(date));
		for(EmpInfo emp:list) {
			CountDatetoNowDays.TranstoDate(emp);
		}
		return list;
	}

	//取得所有试用期到期小于30天的人员名单
	@RequestMapping(value="getTryMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public List<EmpInfo> getTryEndTimePerson(@RequestParam("date") String date) throws ParseException{
		date=CountDatetoNowDays.DateaddDays(date,30);
		List<EmpInfo> list=empInfoService.gettrymsg(CountDatetoNowDays.SDatetoStamp(date));
		for(EmpInfo emp:list) {
			CountDatetoNowDays.TranstoDate(emp);
		}
		return list;
	}

	//获取当前包括当前月的前12个月的日期
	@RequestMapping(value="get12Month.do",method=RequestMethod.POST)
	@ResponseBody
	public List<String> get12Month(@RequestParam("date")String date) throws ParseException{
		List<String> list=new ArrayList<>();
		list=CountDatetoNowDays.getpremonth(date, 12);
		return list;
	}

	//获取包括当前年的前8年的日期
	@RequestMapping(value="get8Years.do",method=RequestMethod.POST)
	@ResponseBody
	public List<String> get8Years(
			@RequestParam("date")String date) throws ParseException {
		List<String> list=new ArrayList<>();
		list=CountDatetoNowDays.getpreYears(date, 8);
		return list;
	}

	//获取人事管理主页曲线图的数据（本月人数增减情况）
	@RequestMapping(value="geteachMonthMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public List<Map> getPergraphs(@RequestParam("date[]") List<String> date) throws ParseException{
		List <Map> result=new ArrayList<>();
		for(String str:date) {
			result.add(geteachMonthMsg(str));
		}
		return result;

	}
	//获取人事管理主页柱形图的数据（人才队伍）
	@ResponseBody
	@RequestMapping(value="gettalentsTeam.do",method=RequestMethod.POST)
	public List<Map> getPercolumns(@RequestParam("date[]") List<String> date) throws ParseException{
		List <Map> result=new ArrayList<>();
		for(String str:date) {
			result.add(gettalentsTeam(str));
		}
		return result;

	}

	//获取高端人才数据
	@RequestMapping(value="getTitleMsg.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<Integer> getHighertalentsMsg(@RequestParam("data[]")String[] title){
		List<Integer> result=new ArrayList<>();
		for(int i=0;i<title.length;i++) {
			result.add(gethighttalents(title[i]));
		}
		return result;
	}

	//取得人才队伍饼状图
	@RequestMapping(value="gettalentsdept.do",method=RequestMethod.POST)
	@ResponseBody
	public List<Integer> gettalentsdeptMsg(@RequestParam("data[]")String[] title){
		List<Integer> result=new ArrayList<>();
		for(int i=0;i<title.length;i++) {
			result.add(gettalentsdept(title[i]));
		}
		return result;
	}

	//获取审核状态为待审核的员工信息
	@RequestMapping(value="getstatusbyreview.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Layui getstatusbyreview(HttpServletRequest req){
		List<EmpInfo> result=empInfoService.getstatusbyreview("待审核");
		for(EmpInfo emp:result) {
			CountDatetoNowDays.TranstoDate(emp);
		}
		int count=result.size();
		return Layui.data(count, result);

	}

	//获取身份证到期时间小于30天的员工
	@ResponseBody
	@RequestMapping(value="getiDexpire.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui getIDexpire(HttpServletRequest req) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<EmpInfo> result=empInfoService.getIDexpire(CountDatetoNowDays.SDatetoStamp(sdf.format(new Date()),-30));
		for(EmpInfo emp:result) {
			CountDatetoNowDays.TranstoDate(emp);
		}
		int count =result.size();
		return Layui.data(count, result);

	}

	//获取消息通知页面试用期到期员工接口
	@RequestMapping(value="getTryemp.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Layui getTryemp(HttpServletRequest req) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<EmpInfo> result=getTryEndTimePerson(sdf.format(new Date()));
		int count =result.size();
		return Layui.data(count, result);
	}

	//获取消息通知页面合同期到期员工接口
	@ResponseBody
	@RequestMapping(value="getConemp.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public Layui getConemp(HttpServletRequest req) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		List<EmpInfo> result=getContractEndtimePerson(sdf.format(new Date()));
		int count =result.size();
		return Layui.data(count, result);
	}

	//更新员工的审核状态为通过
	@RequestMapping(value="upReview.do",method=RequestMethod.POST)
	@ResponseBody
	public int upReview(@RequestParam("msg")String msg,@RequestParam("id")int id) {
		return empInfoService.updateReview(msg, id);
	}

	//通过excel插入数据库数据的接口
	@RequestMapping(value="getfile.do",method=RequestMethod.POST)
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
					EmpInfo emp = new EmpInfo();
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
					emp=setEmpInfovalue(emp, list);
					if(emp.getEmpTryoutendtime()!=null)
					emp.setEmpTryoutendtime(emp.getEmpTryoutendtime().replace("/", "-"));
					if(emp.getEmpIdcardEndtime()!=null)
					emp.setEmpIdcardEndtime(emp.getEmpIdcardEndtime().replace("/", "-"));
					if(emp.getEmpContractendtime()!=null)
					emp.setEmpContractendtime(emp.getEmpContractendtime().replace("/", "-"));
					if(emp.getEmpFirstgraduationtime()!=null)
					emp.setEmpFirstgraduationtime(emp.getEmpFirstgraduationtime().replace("/", "-"));
					if(emp.getEmpSecondgraduationtime()!=null)
					emp.setEmpSecondgraduationtime(emp.getEmpSecondgraduationtime().replace("/", "-"));
					if(emp.getEmpThirdgraduationtime()!=null)
					emp.setEmpThirdgraduationtime(emp.getEmpThirdgraduationtime().replace("/", "-"));
					if(emp.getEmpInductiontime()!=null)
					emp.setEmpInductiontime(emp.getEmpInductiontime().replace("/", "-"));
					if(emp.getEmpJobtitleobtaintime()!=null)
					emp.setEmpJobtitleobtaintime(emp.getEmpJobtitleobtaintime().replace("/", "-"));
					if(emp.getEmpDepartureTime()!=null)
					emp.setEmpDepartureTime(emp.getEmpDepartureTime().replace("/", "-"));
					CountDatetoNowDays.TranstoStamp(emp);
					empInfoService.insert(emp);
					result=result.data(1, null);

				}
			}
		}catch(ParseException e) {
			wookbook.close();
			e.printStackTrace();
			throw new CustomException("数据库异常!请检查文件格式!");
		}
		wookbook.close();
		return result;

	}

	public EmpInfo setEmpInfovalue(EmpInfo empInfo,List<String> value) {
		empInfo.setEmpNum(value.get(0));
		empInfo.setEmpName(value.get(1));
		empInfo.setEmpGender(value.get(2));
		empInfo.setEmpDept(value.get(3));
		empInfo.setEmpPosition(value.get(4));
		empInfo.setEmpHireStarttime(value.get(5));
		empInfo.setEmpIdcard(value.get(6));
		empInfo.setEmpIdcardEndtime(value.get(7));
		empInfo.setEmpEthnic(value.get(8));
		empInfo.setEmpPoliticallandscape(value.get(9));
		empInfo.setEmpMaritalstatus(value.get(10));
		empInfo.setEmpFirsteducation(value.get(11));
		empInfo.setEmpFirsteducationschool(value.get(12));
		empInfo.setEmpFirsteducationpro(value.get(13));
		empInfo.setEmpFirstgraduationtime(value.get(14));
		empInfo.setEmpSecondeducation(value.get(15));
		empInfo.setEmpSecondeducationschool(value.get(16));
		empInfo.setEmpSecondeducationpro(value.get(17));
		empInfo.setEmpSecondgraduationtime(value.get(18));
		empInfo.setEmpThirdeducation(value.get(19));
		empInfo.setEmpThirdeducationschool(value.get(20));
		empInfo.setEmpThirdeducationpro(value.get(21));
		empInfo.setEmpThirdgraduationtime(value.get(22));
		empInfo.setEmpOthereducation(value.get(23));
		empInfo.setEmpOthereducationschool(value.get(24));
		empInfo.setEmpOthereducationpro(value.get(25));
		empInfo.setEmpOthergraduationtime(value.get(26));

		empInfo.setEmpJobtitle(value.get(27));
		empInfo.setEmpJobtitlelevel(value.get(28));
		empInfo.setEmpJobtitleobtaintime(value.get(29));
		empInfo.setEmpPhone(value.get(30));
		empInfo.setEmpEmergencycontactandphone(value.get(31));
		empInfo.setEmpFileaddress(value.get(32));
		empInfo.setEmpAccountaddress(value.get(33));
		empInfo.setEmpHomeaddress(value.get(34));
		empInfo.setEmpWorktype(value.get(35));
		empInfo.setEmpCompile(value.get(36));
		empInfo.setEmpInductiontime(value.get(37));
		empInfo.setEmpTryoutendtime(value.get(38));
		empInfo.setEmpContractendtime(value.get(39));
		empInfo.setEmpContractsignednum(Integer.parseInt(value.get(40)));
		empInfo.setEmpReturnee(value.get(41));
		empInfo.setEmpForeign(value.get(42));
		empInfo.setEmpRemarks(value.get(43));
		empInfo.setEmpReviewstatus("通过");
		empInfo.setEmpStat("1");
		empInfo.setEid("1");
		empInfo.setEmpContractStatus("1");
//		empInfo.setEmpDepartureTime(value.get(41));
//		empInfo.setEmpTryStatus(value.get(42));
//		empInfo.setEmpContractStatus(value.get(43));
//		empInfo.setEmpTitle(value.get(44));
		return empInfo;
	}
}
