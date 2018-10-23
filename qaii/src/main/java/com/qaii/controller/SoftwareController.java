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

import com.qaii.domain.Softcopyrightfile;
import com.qaii.domain.Softwarecopyright;
import com.qaii.service.SoftcopyrightfileService;
import com.qaii.service.SoftwarecopyrightService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class SoftwareController {
	
	@Resource
	private SoftwarecopyrightService softwareService;
	@Resource
	private SoftcopyrightfileService softcopyrightfileService;
	//文件路径
	public final static String FILE_PATH= "C:/File/Software/";
	//数据库中记录的路径
	public final static String DATABASE_PATH="File/Software/";

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
	
	//软著查看详情
	@RequestMapping(value="showSoftDetails.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult showSoftDetails(Softwarecopyright soft,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("id"));
		//soft.setId();
		soft = softwareService.selectFileMsg(userid);
		return new JsonResult(soft);
	}
	
//	//软著查看文件
//	@RequestMapping(value="showSoftfileDetails.do",method=RequestMethod.POST)
//	@ResponseBody
//	public JsonResult showSoftfileDetails(List<Softcopyrightfile> soft,HttpServletRequest req) {	
//		
//		int userid=Integer.parseInt(req.getParameter("id"));
//		//soft.setId();
//		soft = softcopyrightfileService.listBysid(userid);
//		soft.remove(0);
//		return new JsonResult(soft);
//	} 
	
	//修改软著信息功能
	@RequestMapping(value="updatesofts.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updatesofts(Softwarecopyright soft,
			HttpServletRequest req,
			@RequestParam("file") MultipartFile[] files) throws CustomException{	
		loadData(req, soft);
		soft.setId(Integer.parseInt(req.getParameter("id")));
		int row =softwareService.updateSoft(soft);
		int stat=updatewithSoftwarefile(files,soft);
		if(row>=1) {
			//String data="更新成功";
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
	}
	

	//更新软著操作时的插入软著文件信息
	int updatewithSoftwarefile(MultipartFile[] files,Softwarecopyright soft) throws CustomException {
		if (files.equals(null) && files.length < 0) {
			throw new CustomException("请至少插入一个文件!");
		}
		if(files[0].getSize()==0)
			return 0;
		Softcopyrightfile softfile=new Softcopyrightfile();
		for (int i = 0; i < files.length; i++) {
			 String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
			 
			 String name=files[i].getOriginalFilename();
			// 取文件格式后缀名
			//String type = files[i].getOriginalFilename();
			 
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			 
			String filename = uuid + type;// 取当前时间戳作为文件名

			// String path = request.getSession().getServletContext().getRealPath("/upload/"
			// + filename);// 存放位置
			String path = (FILE_PATH + soft.getSoftName() + "/other/");
			String dbpath=(DATABASE_PATH + soft.getSoftName() + "/other/");
			File destFile = new File(path + filename);
			softfile.setSid(soft.getId());
			softfile.setStyle("other");
			softfile.setFilename(name);
			softfile.setPath(dbpath + filename);
			
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			try {
				files[i].transferTo(destFile);
				softcopyrightfileService.insert(softfile);
			} catch (Exception e) {
				throw new CustomException("插入失败!");
			}
			
		}
		return 1;
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
	public String AddSoft(HttpServletRequest req,
			Softwarecopyright soft,
			@RequestParam("file") MultipartFile[] files) throws CustomException {
		loadData(req, soft);		
		//插入软著信息
		int row = softwareService.insertSoft(soft);
		updateSoftwarefile(files,soft);
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
	
	//插入软著文件信息
	void updateSoftwarefile(MultipartFile[] files,Softwarecopyright soft) throws CustomException {
		if (files.equals(null) && files.length < 0) {
			throw new CustomException("请至少插入一个文件!");
		}
		Softcopyrightfile softfile=new Softcopyrightfile();
		for (int i = 0; i < files.length; i++) {
			 String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
			 
			 String name=files[i].getOriginalFilename();
			// 取文件格式后缀名
			//String type = files[i].getOriginalFilename();
			 
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			 
			String filename = uuid + type;// 取当前时间戳作为文件名

			// String path = request.getSession().getServletContext().getRealPath("/upload/"
			// + filename);// 存放位置
			String path = (i>0?(FILE_PATH + soft.getSoftName() + "/other/"):(FILE_PATH + soft.getSoftName() + "/master/"));
			String dbpath=(i>0?(DATABASE_PATH + soft.getSoftName() + "/other/"):(DATABASE_PATH + soft.getSoftName() + "/master/"));
			File destFile = new File(path + filename);
			softfile.setSid(soft.getId());
			softfile.setStyle(i>0?"other":"master");
			softfile.setFilename(name);
			softfile.setPath(dbpath + filename);
			
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			try {
				// FileUtils.copyInputStreamToFile(files[i].getInputStream(), destFile);//
				// 复制临时文件到指定目录下
				files[i].transferTo(destFile);
				softcopyrightfileService.insert(softfile);

			} catch (Exception e) {
				throw new CustomException("插入失败!");
			}
		}
	}
	
	//其他文件重新上传文件信息
	@RequestMapping(value="reUpOthersoftfile.do")
	@ResponseBody
	void reUpOthersoftfile(HttpServletRequest req,
			Softcopyrightfile softfile,
			@RequestParam("file") MultipartFile files) throws CustomException {
		String softName=req.getParameter("softName");
		softfile.setId(Integer.parseInt(req.getParameter("id")));
		softfile.setFilename(files.getOriginalFilename());
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
			softfile.setPath(dbpath);
			file=new File(filepath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			files.transferTo(file);
			softcopyrightfileService.updateOtherfileById(softfile);
			
		}catch(Exception e){
			throw new CustomException("重新上传失败!");
		}	
	}
	
	//证明文件重新上传
	@RequestMapping(value="reUpMastersoftfile.do")
	@ResponseBody
	void reUpMastersoftfile(HttpServletRequest req,
			Softcopyrightfile softfile,
			@RequestParam("file") MultipartFile files) throws CustomException {
		String softName=req.getParameter("softName");
		softfile.setId(Integer.parseInt(req.getParameter("id")));
		softfile.setFilename(files.getOriginalFilename());
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
			String filepath=FILE_PATH + softName + "/master/" + filename;
			//文件存放于数据库中的相对路径
			String dbpath=DATABASE_PATH + softName + "/master/" + filename;
			softfile.setPath(dbpath);
			file=new File(filepath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			files.transferTo(file);
			softcopyrightfileService.updateOtherfileById(softfile);
			
		}catch(Exception e){
			throw new CustomException("重新上传失败!");
		}	
	}
	
	//删除其他文件接口
	@RequestMapping(value="removeOthersoftfile.do")
	@ResponseBody
	JsonResult removeOthersoftfile(HttpServletRequest req,@RequestParam("id") int id,@RequestParam("address") String address) throws CustomException {
		try {
			File file = new File(FILE_PATH+address);
			if (file.exists()) {
				file.delete();
			}
			Object obj= softcopyrightfileService.deleteByPrimaryKey(id);
			return new JsonResult(obj);
			
		}catch(Exception e){
			throw new CustomException("重新上传失败!");
		}
			
	}
	
}
