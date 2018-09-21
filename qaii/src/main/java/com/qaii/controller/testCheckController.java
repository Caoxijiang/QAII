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
import java.util.UUID;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.qaii.domain.DeptInfo;
import com.qaii.domain.EmpAvatarinfo;
import com.qaii.domain.EmpInfo;
import com.qaii.domain.Govfund;
import com.qaii.domain.Govplatform;
import com.qaii.domain.Govreward;
import com.qaii.domain.Govsubject;
import com.qaii.domain.PatProcess;
import com.qaii.domain.Softwarecopyright;
import com.qaii.domain.Thesis;
import com.qaii.domain.Trademark;
import com.qaii.domain.Work;
import com.qaii.service.DeptInfoService;
import com.qaii.service.EmpInfoService;
import com.qaii.service.GovFundService;
import com.qaii.service.GovPlatformService;
import com.qaii.service.GovRewardService;
import com.qaii.service.GovSubjectService;
import com.qaii.service.PatentService;
import com.qaii.service.SoftwarecopyrightService;
import com.qaii.service.ThesisService;
import com.qaii.service.TradeMarkService;
import com.qaii.service.WorkService;
import com.qaii.service.impl.EmpInfoServiceImpl;
import com.qaii.util.CountDatetoNowDays;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

import net.sf.json.JSONObject;

@Controller
public class testCheckController {

	@Resource
	private EmpInfoService empinfo;
	@Resource
	private DeptInfoService deptinfo;
	
	@Resource
	private PatentService patents;
	@Resource
	private SoftwarecopyrightService software;
	@Resource
	private TradeMarkService trademark;
	@Resource
	private ThesisService thesis;
	@Resource
	private WorkService work;
	@Resource
	private GovFundService govfund;
	@Resource
	private GovPlatformService govplatform;
	@Resource
	private GovSubjectService govsubject;
	@Resource
	private GovRewardService govreward;
	
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
	
	@RequestMapping("tsterr.do")
	public void errorpage() throws CustomException {
		throw new CustomException("测试异常成功！");
	}
	
	//测试接口
	@RequestMapping("testinterface.do")
	public void testinterface() {
//		System.out.println("result is"+govfund.getAllFundMsg());
//		System.out.println("result is"+govplatform.getAllPlatformMsg());
//		System.out.println("result is"+govsubject.getAllSubjectMsg());
//		System.out.println("result is"+govreward.getAllRewardMsg());
	} 
	
	//科技成果预览信息
	public Map ScienceAchivementPreview() {
		Map<String, Integer> result=new HashMap<>();
		result.put("Patent", patents.getPatentCount());
		result.put("Software", software.getCountNum());
		result.put("trademark", trademark.getCountNum());
		result.put("thesis", thesis.getCountNum());
		result.put("work", work.getCountNum());
		System.out.println(result);
		return result;
	} 
	
	
	
	
	//员工图片上传
			@ResponseBody
		 	@RequestMapping("/testupload.do")  
		    public Map<String,String> upload(@RequestParam("file") MultipartFile[] files , PatProcess process,HttpServletRequest request) throws Exception{  
		  //  System.out.println(request.getParameter("name"));  
				System.out.println(files);
		    Map<String,String> result=new HashMap<>();
		    if(files!=null&&files.length<0) {
		    	result.put("code", "1");
		    	result.put("msg", "文件为空");
		    }
		    
		for (int i = 0; i < files.length; i++) {
			String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));// 取文件格式后缀名
			String filename = System.currentTimeMillis() + type;// 取当前时间戳作为文件名
			
			System.out.println("文件名："+filename);
			//String path = request.getSession().getServletContext().getRealPath("/upload/" + filename);// 存放位置
			 String path="C:/File/img";
			System.out.println("++++++"+path);
			File destFile = new File(path+"/"+filename);
			try {
				//FileUtils.copyInputStreamToFile(files[i].getInputStream(), destFile);// 复制临时文件到指定目录下
				files[i].transferTo(destFile);
				result.put("code", "0");
				result.put("msg", "上传成功");
				result.put("url", destFile.getPath());
				
			} catch (IOException e) {
				e.printStackTrace();
				result.put("code", "1");
				result.put("msg", "上传失败");
			}
		}

		return result;
		    
//	        String uuid = UUID.randomUUID().toString().replaceAll("-","");    
//	        
//	        //获取文件的原始名称
//	        String name=file.getOriginalFilename();
//	        
//	        //获得文件类型（可以判断如果不是图片，禁止上传）    
//	        String contentType=EMpA.getFile().getContentType();    
//	        //获得文件后缀名   
//	        String suffixName=contentType.substring(contentType.indexOf("/")+1);  
//	        System.out.println("原始："+name);
//	        System.out.println("类型"+contentType);
//	       System.out.println("后缀名"+suffixName);
//	        //得到 文件名  
//	        String fileName=uuid+"."+suffixName; 
//		    
//		  //  String fileName=file.getOriginalFilename();
//		    int size=(int)file.getSize();
//		  //  System.out.println(fileName+":---"+size);
//		    String path="C:/File/img";
//		    File dest =new File(path+"/"+fileName);
//		    if(!dest.getParentFile().exists()) {
//		    	dest.getParentFile().mkdirs();
//		    }
//		    try {
//				file.transferTo(dest);//保存文件
//				EMpA.setUrl("/img/"+fileName);
//				//InsertEmpAvator(EMpA, result, dest);
//				result.put("code", "0");
//				result.put("msg", "上传成功");
//				result.put("url", dest.getPath());
//			} catch (IllegalStateException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				result.put("code", "1");
//		    	result.put("msg", "上传失败");
//			}catch (IOException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				result.put("code", "1");
//		    	result.put("msg", "上传失败");
//			}
//		    
//		    return result;  
	    
		    }

	
	
	
	
	
	
	
	
}
