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

import com.qaii.domain.MeetingThesis;
import com.qaii.domain.MeetingThesisFile;
import com.qaii.service.MeetingThesisFileService;
import com.qaii.service.MeetingThesisService;
import com.qaii.util.AlertException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class MeetingThesisController {

	@Resource
	private MeetingThesisService Service;
	@Resource
	private MeetingThesisFileService fileService;
	
	//文件路径
	public final static String FILE_PATH= "C:/File/MeetingThesis/";
	//数据库中记录的路径
	public final static String DATABASE_PATH="File/MeetingThesis/";
	
	public final static byte BYTE_TRUE = 1;
	
	public final static byte BYTE_FALSE = 0;
		
	//查看所有信息
	@RequestMapping(value="listMeeting.do",method=RequestMethod.POST)
	@ResponseBody
	Layui listMeetingThesis(){
		List<MeetingThesis> result = Service.listAllMessage();
		int count=result.size();
		if(count > 0) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, null);
		}
	}
	
	//删除信息
	@RequestMapping(value="deleteMeeting.do",method=RequestMethod.POST)
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
	@RequestMapping(value="getMeeting.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult getMessage(HttpServletRequest req) {
		MeetingThesis result = Service.getMessage(Long.parseLong(req.getParameter("id")));
		if(!result.equals(null)) {
			return new JsonResult(result);
		}else {
			return new JsonResult();
		}
	}
	
	//修改信息
	@RequestMapping(value="updateMeeting.do",method=RequestMethod.POST)
	@ResponseBody
	String updateMessage(HttpServletRequest req, 
		MeetingThesis record,
		@RequestParam("file") MultipartFile[] files) throws AlertException {
		loadData(req,record);
		record.setGmtModified(new Date());
		record.setId(Long.parseLong(req.getParameter("id")));
		int recordResult = Service.updateMessage(record);
		updateFile(record, files);
		if(recordResult > 0) {
			return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
		}	
	}
	
	int updateFile(MeetingThesis record, MultipartFile[] files) {
		// TODO Auto-generated method stub
		if (files.equals(null) && files.length < 0) {
			return 0;
		}
		if(files[0].getSize()==0)
			return 0;
		MeetingThesisFile file=new MeetingThesisFile();
		for (int i = 0; i < files.length; i++) {
			
			//文件类型
			String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
			//文件名
			String name=files[i].getOriginalFilename();
			//新的文件名前缀（取时间戳）
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			//新的文件名
			String filename = uuid + type;
			
			String path = (FILE_PATH + record.getMeetingName() + "/other/");
			String dbpath=(DATABASE_PATH + record.getMeetingName() + "/other/");
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

	void loadData(HttpServletRequest req, MeetingThesis record){
		record.setTopic(req.getParameter("topic"));
		record.setAuthor(req.getParameter("author"));
		record.setAuthorUnit(req.getParameter("authorUnit"));
		record.setPublishtime(req.getParameter("publishtime"));
		record.setMeetingName(req.getParameter("meetingName"));
		record.setMeetingLocation(req.getParameter("meetingLocation"));
		record.setKeyword(req.getParameter("keyword"));
		record.setCommunicateAuthor(req.getParameter("communicateAuthor"));
		record.setEnglishSummary(req.getParameter("englishSummary"));
		record.setMeetingRecord(req.getParameter("meetingRecord"));
		record.setContentType(req.getParameter("contentType"));
		record.setUnit(req.getParameter("unit"));
		record.setGmtModified(new Date());
	}
	
	//添加记录
	@RequestMapping(value="insertMeeting.do",method=RequestMethod.POST)
	@ResponseBody
	String insertMessage(HttpServletRequest req, 
			MeetingThesis record,
			@RequestParam("file") MultipartFile[] files) {
		record.setGmtCreate(new Date());
		record.setIsPass(BYTE_FALSE);
		loadData(req,record);
		int insertResult=Service.insertMessage(record);
		insertFile(record,files);
		if(insertResult > 0) {
			return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
		}
	}

	int insertFile(MeetingThesis record, MultipartFile[] files) {
		// TODO Auto-generated method stub
		if (files.equals(null) && files.length < 0) {
			return 1;
		}
		if(files[0].getSize()==0)
			return 0;
		MeetingThesisFile file=new MeetingThesisFile();
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
				String path = (i==0?FILE_PATH + record.getMeetingName() + "/electronic/":FILE_PATH + record.getMeetingName() + "/certified/");
				String dbpath=(i==0?DATABASE_PATH + record.getMeetingName() + "/electronic/":DATABASE_PATH + record.getMeetingName() + "/certified/");
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
			
			String path = (FILE_PATH + record.getMeetingName() + "/other/");
			String dbpath=(DATABASE_PATH + record.getMeetingName() + "/other/");
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
	
	//文件重新上传
	@RequestMapping(value="fileReupMeeting.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult fileReup(HttpServletRequest req,
			MeetingThesisFile record,
			@RequestParam("file") MultipartFile files
			) {
		String topic=req.getParameter("topic");
		String style=req.getParameter("style");
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
			String filepath=FILE_PATH + topic + style + filename;
			//文件存放于数据库中的相对路径
			String dbpath=DATABASE_PATH + topic + style + filename;
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
	@RequestMapping(value="deleteFileMeeting.do",method=RequestMethod.POST)
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
	
	//未审核的记录列表
	@RequestMapping(value="listNotPassMeeting.do",method=RequestMethod.POST)
	@ResponseBody
	Layui listNotPass() {
		List<MeetingThesis> result=Service.listNotPass();
		return Layui.data(1, result);
	}
	
	//通过申请
	@RequestMapping(value="setPassMeeting.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult setPass(HttpServletRequest req, MeetingThesis record) {
		record.setId(Long.valueOf(req.getParameter("id")));
		record.setIsPass(BYTE_TRUE);
		int result=Service.updateMessage(record);
		return new JsonResult(result);
	}
}
