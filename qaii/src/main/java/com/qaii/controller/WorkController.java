package com.qaii.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
import com.qaii.domain.WorkFile;
import com.qaii.domain.Work;
import com.qaii.service.WorkFileService;
import com.qaii.service.WorkService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class WorkController {
	
	@Resource
	private WorkService workService;
	@Resource
	private WorkFileService fileService;
	
	//文件路径
	public final static String FILE_PATH= "C:/File/Work/";
	//数据库中记录的路径
	public final static String DATABASE_PATH="File/Work/";
	
	public final static byte BYTE_TRUE = 1;
	
	public final static byte BYTE_FALSE = 0;
	
	
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
	
	//著作查看详情
	@RequestMapping(value="showWorkDetails.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult showworkDetails(Work work,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("id"));
		//work.setId();
		work = workService.getMessage(userid);
		return new JsonResult(work);
	}
	
	//修改著作信息功能
	@RequestMapping(value="updateWork.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	String updateworks(Work record, HttpServletRequest req, 
			@RequestParam("file") MultipartFile[] files){	
		loadData(req, record);
		record.setId(Integer.parseInt(req.getParameter("id")));
		int row =workService.updateMsg(record);
		updateFile(record, files);
		if(row>=1) {
			return  "page/science/inform/edit-succesdsci";
    	}else {
    		return "page/science/inform/edit-faildsci";
		}
	}
	
	int updateFile(Work record, MultipartFile[] files) {
		// TODO Auto-generated method stub
		if (files.equals(null) && files.length < 0) {
			return 0;
		}
		if(files[0].getSize()==0)
			return 0;
		WorkFile file=new WorkFile();
		for (int i = 0; i < files.length; i++) {
			
			//文件类型
			String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
			//文件名
			String name=files[i].getOriginalFilename();
			//新的文件名前缀（取时间戳）
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			//新的文件名
			String filename = uuid + type;
			
			String path = (FILE_PATH + record.getWorkTopic() + "/other/");
			String dbpath=(DATABASE_PATH + record.getWorkTopic() + "/other/");
			File demoFile = new File(path + filename);
			file.setWid(record.getId().longValue());
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
	
	//绑定请求数据到bean中
	void loadData(HttpServletRequest req,Work work){
		work.setWorkType(req.getParameter("workType"));
		work.setWorkTopic(req.getParameter("workTopic"));
		work.setWorkAuthor(req.getParameter("workAuthor"));
		work.setWorkPublishhouse(req.getParameter("workPublishhouse"));
		work.setWorkPublishtime(req.getParameter("workPublishtime"));
		work.setWorkDept(req.getParameter("workDept"));
		work.setWorkIsbn(req.getParameter("workIsbn"));
	}
	//添加著作信息功能
	@RequestMapping("addWork.do")
	String Addwork(HttpServletRequest req, 
			Work record, 
			@RequestParam("file") MultipartFile[] files) {
		loadData(req, record);		
		record.setIsPass(BYTE_FALSE);
		int row = workService.insertMessage(record);
		insertFile(record,files);
		if(row>0) {
			return  "page/science/inform/add-succesdOut";
    	}else {
    		return "page/science/inform/add-faildOut";
		}
		
	}
	
	int insertFile(Work record, MultipartFile[] files) {
		// TODO Auto-generated method stub
		if (files.equals(null) && files.length < 0) {
			return 1;
		}
		if(files[0].getSize()==0)
			return 0;
		WorkFile file = new WorkFile();
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
			if(i<=2) {
				String path = null,dbpath = null,style = null;
				if(i==0) {
					path = (FILE_PATH + record.getWorkTopic() + "/title/");
					dbpath=(DATABASE_PATH + record.getWorkTopic() + "/title/");
					style=("title");
				}
				if(i==1) {
					path = (FILE_PATH + record.getWorkTopic() + "/directory/");
					dbpath=(DATABASE_PATH + record.getWorkTopic() + "/directory/");
					style=("directory");
				}
				if(i==2) {
					path = (FILE_PATH + record.getWorkTopic() + "/firstpage/");
					dbpath=(DATABASE_PATH + record.getWorkTopic() + "/firstpage/");
					style=("firstpage");
				}
				long t=record.getId();
				file.setWid(record.getId().longValue());
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
			
			String path = (FILE_PATH + record.getWorkTopic() + "/other/");
			String dbpath=(DATABASE_PATH + record.getWorkTopic() + "/other/");
			File demoFile = new File(path + filename);
			file.setWid(record.getId().longValue());
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
	@RequestMapping(value="fileReupWork.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult fileReup(HttpServletRequest req,
			WorkFile record,
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
	@RequestMapping(value="deleteFileWork.do",method=RequestMethod.POST)
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
		work.setWorkIsbn(value.get(5));
		work.setWorkDept(value.get(6));
		work.setIsPass(BYTE_TRUE);
		return work;
	}

	//未审核的记录列表
	@RequestMapping(value="listNotPassWork.do",method=RequestMethod.POST)
	@ResponseBody
	Layui listNotPass() {
		List<Work> result=workService.listNotPass();
		return Layui.data(1, result);
	}
	
	//通过申请
	@RequestMapping(value="setPassWork.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult setPass(HttpServletRequest req,Work work) {
		work.setId(Integer.parseInt(req.getParameter("id")));
		work.setIsPass(BYTE_TRUE);
		int result=workService.updateMsg(work);
		return new JsonResult(result);
		
	}
}
