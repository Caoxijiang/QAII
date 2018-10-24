package com.qaii.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qaii.domain.PeriodicalThesis;
import com.qaii.domain.PeriodicalThesisFile;
import com.qaii.service.PeriodicalThesisFileService;
import com.qaii.service.PeriodicalThesisService;
import com.qaii.util.AlertException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

/**
 * Title:PeriodicalThesisController.java
 * Company:青岛智能产业技术研究院
 * @author wangxin
 * @Time 2018年10月24日
 */
@Controller
public class PeriodicalThesisController {

	@Resource
	private PeriodicalThesisService Service;
	@Resource
	private PeriodicalThesisFileService fileService;
	
	//文件路径
	public final static String FILE_PATH= "C:/File/PeriodicalThesis/";
	//数据库中记录的路径
	public final static String DATABASE_PATH="File/PeriodicalThesis/";
	
	//查看所有信息
	@RequestMapping(value="listPeriodical.do",method=RequestMethod.POST)
	@ResponseBody
	Layui listPeriodicalThesis(){
		List<PeriodicalThesis> result = Service.listAllMessage();
		int count=result.size();
		if(count > 0) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, null);
		}
	}
	
	//删除信息
	@RequestMapping(value="deletePeriodical.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult deleteMessages(@RequestParam("requestDate[]") Integer[] id) {
		int result = Service.deleteMessages(id);
		if (result > 0) {
			return new JsonResult(result);
		}else {
			return new JsonResult();
		}
	}
	
	//查看详情
	@RequestMapping(value="getPeriodical.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult getMessage(HttpServletRequest req) {
		PeriodicalThesis result = Service.getMessage(Long.parseLong(req.getParameter("id")));
		if(!result.equals(null)) {
			return new JsonResult(result);
		}else {
			return new JsonResult();
		}
	}
	
	//修改信息
	@RequestMapping(value="updatePeriodical.do",method=RequestMethod.POST)
	@ResponseBody
	String updateMessage(HttpServletRequest req, 
			PeriodicalThesis record, 
			@RequestParam("file") MultipartFile[] files) throws AlertException {
		loadData(req,record);
		record.setId(Long.parseLong(req.getParameter("id")));
		int recordResult = Service.updateMessage(record);
		int fileResult = updateFile(record, files);
		if(recordResult > 0 && fileResult > 0) {
			return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
		}
		
	}

	int updateFile(PeriodicalThesis record, MultipartFile[] files) throws AlertException {
		// TODO Auto-generated method stub
		if (files.equals(null) && files.length < 0) {
			throw new AlertException("请至少插入一个文件!");
		}
		if(files[0].getSize()==0)
			return 0;
		PeriodicalThesisFile file=null;
		for (int i = 0; i < files.length; i++) {
			
			//文件类型
			String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
			//文件名
			String name=files[i].getOriginalFilename();
			//新的文件名前缀（取时间戳）
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			//新的文件名
			String filename = uuid + type;
			
			String path = (FILE_PATH + record.getPeriodicalName() + "/other/");
			String dbpath=(DATABASE_PATH + record.getPeriodicalName() + "/other/");
			File demoFile = new File(path + filename);
			file.setTid(record.getId());
			file.setStyle("other");
			file.setName(name);
			file.setPath(dbpath + filename);
			if (!demoFile.getParentFile().exists()) {
				demoFile.getParentFile().mkdirs();
			}
			try {
				//保存文件
				files[i].transferTo(demoFile);
				//在数据库中插入文件信息
				fileService.insertMessage(file);
			} catch (Exception e) {
				return 0;
			}
			
		}
		return 1;
	}

	void loadData(HttpServletRequest req, PeriodicalThesis record) {
		// TODO Auto-generated method stub
		record.setTopic(req.getParameter("topic"));
		record.setAuthor(req.getParameter("author"));
		record.setAuthorUnit(req.getParameter("authorUnit"));
		record.setPublishtime(req.getParameter("publishtime"));
		record.setPeriodicalName(req.getParameter("periodicalName"));
		record.setPageNumber(req.getParameter("pageNumber"));
		record.setKeyword(req.getParameter("keyword"));
		record.setEnglishSummary(req.getParameter("englishSummary"));
		record.setContentType(req.getParameter("contentType"));
		record.setRecordType(req.getParameter("recordType"));
		record.setLevel(req.getParameter("level"));
		record.setUnit(req.getParameter("unit"));
		record.setGmtModified(new Date());
	}
	
	//添加记录
	@RequestMapping(value="insertPeriodical.do",method=RequestMethod.POST)
	@ResponseBody
	String insertMessage(HttpServletRequest req, 
			PeriodicalThesis record, 
			@RequestParam("file") MultipartFile[] files) {
		record.setGmtCreate(new Date());
		loadData(req,record);
		int insertResult=Service.insertMessage(record);
		int fileResult = insertFile(record,files);
		if(insertResult > 0 && fileResult > 0) {
			return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
		}
	}

	int insertFile(PeriodicalThesis record, MultipartFile[] files) {
		// TODO Auto-generated method stub
		if (files.equals(null) && files.length < 0) {
			return 1;
		}
		if(files[0].getSize()==0)
			return 0;
		PeriodicalThesisFile file = new PeriodicalThesisFile();
		for (int i = 0; i < files.length; i++) {
			
			//文件类型
			String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
			//文件名
			String name=files[i].getOriginalFilename();
			//新的文件名前缀（取时间戳）
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			//新的文件名
			String filename = uuid + type;
			
			//在正常情况下，文件队列的第一个应该是电子文件，第二个是证明文件，剩余为其他文件
			if(i<=1) {
				String path = (i==0?FILE_PATH + record.getPeriodicalName() + "/electronic/":FILE_PATH + record.getPeriodicalName() + "/certified/");
				String dbpath=(i==0?DATABASE_PATH + record.getPeriodicalName() + "/electronic/":DATABASE_PATH + record.getPeriodicalName() + "/certified/");
				String style=(i==0?"electronic":"certified");
				long t=record.getId();
				file.setTid(record.getId());
				file.setStyle(style);
				file.setName(name);
				file.setPath(dbpath + filename);
				File demoFile = new File(path + filename);
				if (!demoFile.getParentFile().exists()) {
					demoFile.getParentFile().mkdirs();
				}
				try {
					//保存文件
					files[i].transferTo(demoFile);
					//在数据库中插入文件信息
					fileService.insertMessage(file);
				} catch (Exception e) {
					return 0;
				}
				continue;
			}
			
			String path = (FILE_PATH + record.getPeriodicalName() + "/other/");
			String dbpath=(DATABASE_PATH + record.getPeriodicalName() + "/other/");
			File demoFile = new File(path + filename);
			file.setTid(record.getId());
			file.setStyle("other");
			file.setName(name);
			file.setPath(dbpath + filename);
			if (!demoFile.getParentFile().exists()) {
				demoFile.getParentFile().mkdirs();
			}
			try {
				//保存文件
				files[i].transferTo(demoFile);
				//在数据库中插入文件信息
				fileService.insertMessage(file);
			} catch (Exception e) {
				return 0;
			}
			
		}
		return 1;
	}
	
	//其他文件重新上传
	@RequestMapping(value="otherFileReupPeriodical.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult otherFileReup(HttpServletRequest req,
			PeriodicalThesisFile record,
			@RequestParam("file") MultipartFile files
			) {
		String softName=req.getParameter("softName");
		record.setId(Long.parseLong(req.getParameter("id")));
		record.setName(files.getOriginalFilename());
		try {
			File file = new File(FILE_PATH+req.getParameter("address"));
			if (file.exists()) {
				file.delete();
			}
			//文件后缀
			String type = files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf("."));
			//新的文件名
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			String filename = uuid + type;
			//文件的本地绝对路径
			String filepath=FILE_PATH + softName + "/other/" + filename;
			//文件存放于数据库中的相对路径
			String dbpath=DATABASE_PATH + softName + "/other/" + filename;
			record.setPath(dbpath);
			file=new File(filepath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			files.transferTo(file);
			fileService.updateMessage(record);
			return new JsonResult("success!");
		}catch(Exception e){
			return new JsonResult();
		}	
	}
	
	//电子文件重新上传
	@RequestMapping(value="electronicFileReloadPeriodical.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult electronicFileReload(
			HttpServletRequest req,
			PeriodicalThesisFile record,
			@RequestParam("file") MultipartFile files) {
		String softName=req.getParameter("softName");
		record.setId(Long.parseLong(req.getParameter("id")));
		record.setName(files.getOriginalFilename());
		try {
			File file = new File(FILE_PATH+req.getParameter("address"));
			if (file.exists()) {
				file.delete();
			}
			//文件后缀
			String type = files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf("."));
			//新的文件名
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			String filename = uuid + type;
			//文件的本地绝对路径
			String filepath=FILE_PATH + softName + "/electronic/" + filename;
			//文件存放于数据库中的相对路径
			String dbpath=DATABASE_PATH + softName + "/electronic/" + filename;
			record.setPath(dbpath);
			file=new File(filepath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			files.transferTo(file);
			fileService.updateMessage(record);
			return new JsonResult("success!");
		}catch(Exception e){
			return new JsonResult();
		}	
	}
	
	//证明文件重新上传
	@RequestMapping(value="certifiedFileReloadPeriodical.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult certifiedFileReload(
			HttpServletRequest req,
			PeriodicalThesisFile record,
			@RequestParam("file") MultipartFile files) {
		String softName=req.getParameter("softName");
		record.setId(Long.parseLong(req.getParameter("id")));
		record.setName(files.getOriginalFilename());
		try {
			File file = new File(FILE_PATH+req.getParameter("address"));
			if (file.exists()) {
				file.delete();
			}
			//文件后缀
			String type = files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf("."));
			//新的文件名
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			String filename = uuid + type;
			//文件的本地绝对路径
			String filepath=FILE_PATH + softName + "/certified/" + filename;
			//文件存放于数据库中的相对路径
			String dbpath=DATABASE_PATH + softName + "/certified/" + filename;
			record.setPath(dbpath);
			file=new File(filepath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			files.transferTo(file);
			fileService.updateMessage(record);
			return new JsonResult("success!");
		}catch(Exception e){
			return new JsonResult();
		}	
	}
	
	//删除文件接口
	@RequestMapping(value="deleteFilePeriodical.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult deleteFile(HttpServletRequest req,@RequestParam("id") long id,@RequestParam("address") String address) {
		try {
			File file = new File(FILE_PATH+address);
			if (file.exists()) {
				file.delete();
			}
			Object obj= fileService.deleteMessage(id);
			return new JsonResult(obj);
			
		}catch(Exception e){
			return new JsonResult();
		}
	}
	
	//导入功能
}
