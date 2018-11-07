package com.qaii.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.qaii.service.CopyrightImgService;
import com.qaii.domain.Copyright;
import com.qaii.domain.Copyrightimg;
import com.qaii.service.CopyrightService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

/**
  * <p>Title: CopyrightController.java</p>  
  * <p>Description: </p>   
  * <p>Company: http://www.qaii.cn/</p>  
  * @author wangxin  
  * @date 2018年10月22日  
  * @version 1.0  
 */

@Controller
public class CopyrightController {
	
	@Resource
	private CopyrightService Service;
	@Resource
	private CopyrightImgService imgService;
	//文件路径
	public final static String FILE_PATH= "C:/File/img/Copyright/Symbol/";
	//数据库中记录的路径
	public final static String DATABASE_PATH="/img/Copyright/Symbol/";
	
	
	//所有版权的信息
	@RequestMapping(value="getAllCopyright.do",method=RequestMethod.POST)
	@ResponseBody
	Layui getAllCopyright(){		
		List<Copyright> result=Service.listCopyright();
		int count = result.size();
		return Layui.data(count, result);
	}
	//版权信息添加
	@RequestMapping(value="insertCopyright.do",method=RequestMethod.POST)
	String insertCopyright(HttpServletRequest request, Copyright copyright) {
		loadData(request, copyright);
		int result=Service.insert(copyright);
		if(result >= 1) {
			return  "page/science/inform/add-succesdsci";
    	}else {
    		return "page/science/inform/add-faildsci";
		}
	}
	
	void loadData(HttpServletRequest request, Copyright copyright){
		if(!(request.getParameter("imageVal")==""))
			copyright.setEid(Integer.parseInt(request.getParameter("imageVal")));
		copyright.setCopyPicture(request.getParameter("copyPicture"));
		copyright.setCopyName(request.getParameter("copyName"));
		copyright.setCopyCode(request.getParameter("copyCode"));
		copyright.setCopyAuthor(request.getParameter("copyAuthor"));
		copyright.setCopyCopyrightperson(request.getParameter("copyCopyrightperson"));
		copyright.setCopyAgency(request.getParameter("copyAgency"));
		copyright.setCopyEndtime(request.getParameter("copyEndtime"));
		copyright.setCopyPublishtime(request.getParameter("copyPublishtime"));
		copyright.setCopyRegisttime(request.getParameter("copyRegisttime"));
		copyright.setCopyCost(request.getParameter("copyCost"));
		copyright.setCopyInvoiceper(request.getParameter("copyInvoiceper"));
		copyright.setCopyStatus(request.getParameter("copyStatus"));
		
	}
	
	//版权查看详情
	@RequestMapping(value="copyrightDetail.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult copyrightDetail(HttpServletRequest request, Copyright copyright) {
		copyright=Service.selectByPrimaryKey(Integer.parseInt(request.getParameter("id")));
		if(copyright.equals(null)) {
			return new JsonResult();
		}else {
			return new JsonResult(copyright);
		}
	}
	
	//版权信息修改
	@RequestMapping(value="copyrightChanged.do",method=RequestMethod.POST)
	String copyrightChanged(HttpServletRequest request, Copyright copyright) {
		copyright.setId(Integer.parseInt(request.getParameter("id")));
		loadData(request, copyright);
		int result=Service.update(copyright);
		if(result >= 1) {
			return  "page/science/inform/edit-succesdsci";
    	}else {
    		return "page/science/inform/edit-faildsci";
		}
	}
	
	//版权信息删除
	@RequestMapping(value="copyrightDeleted.do",method=RequestMethod.POST)
	@ResponseBody
	JsonResult copyrightDeleted(@RequestParam("requestDate[]") Integer[] eid) {
		int result=Service.delete(eid);
		if(result >= 1) {
			return new JsonResult(result);
		}else {
			return new JsonResult();
		}
	}
	
	//版权图标上传
	@RequestMapping(value="uploadCopyrightimg.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> uploadCopyrightimg(@RequestParam("file") MultipartFile file, HttpServletRequest request, Copyrightimg copyrightimg) {
		Map<String,String> result=new HashMap<>();
		if(file.isEmpty() || file.getSize()==0) {
			result.put("code", "1");
	    	result.put("msg", "文件为空");
	    }
		String uuid = UUID.randomUUID().toString().replaceAll("-","");    
	    //获得文件类型（可以判断如果不是图片，禁止上传）    
	    String contentType=file.getContentType();    
	    //获得文件后缀名   
	    String suffixName=contentType.substring(contentType.indexOf("/")+1);  
	    //得到 文件名  
	    String fileName=uuid+"."+suffixName; 
	    int size=(int)file.getSize();
	    //  System.out.println(fileName+":---"+size);
	    File dest =new File(FILE_PATH+fileName);
	    if(!dest.getParentFile().exists()) {
	      	dest.getParentFile().mkdirs();
	    }
	    try {
	  	file.transferTo(dest);//保存文件
	  	copyrightimg.setPath(DATABASE_PATH+fileName);
	  	InsertcopyrightimgImg(copyrightimg, result, dest);
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
	
	void InsertcopyrightimgImg(Copyrightimg copyrightimg, Map<String, String> result, File dest) {
		// TODO Auto-generated method stub
		int row=imgService.insert(copyrightimg);
		if(row > 0) {
			int eid=copyrightimg.getId();
			if(eid>=1) {
				result.put("code", "0");
				result.put("msg", "上传成功");
				result.put("eid",copyrightimg.getId().toString() );
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
	
	//版权信息导入
	@RequestMapping(value="insertCopyrightOfExcel.do",method=RequestMethod.POST)
	@ResponseBody
	Layui insertCopyrightOfExcel(@RequestParam("file")MultipartFile file,Copyright copyright) throws AlertException, IOException, CustomException {
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
					setExcelCellsvalue(copyright, list);
					if(copyright.getCopyEndtime()!=null)
						copyright.setCopyEndtime(copyright.getCopyEndtime().replace("/", "-"));
					if(copyright.getCopyPublishtime()!=null)
						copyright.setCopyPublishtime(copyright.getCopyPublishtime().replace("/", "-"));
					if(copyright.getCopyRegisttime()!=null)
						copyright.setCopyRegisttime(copyright.getCopyRegisttime().replace("/", "-"));
					Service.insert(copyright);
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
	
	void setExcelCellsvalue(Copyright copyright, List<String> list) {
		copyright.setCopyPicture(list.get(0));
		copyright.setCopyName(list.get(1));
		copyright.setCopyCode(list.get(2));
		copyright.setCopyAuthor(list.get(3));
		copyright.setCopyCopyrightperson(list.get(4));
		copyright.setCopyAgency(list.get(5));
		copyright.setCopyEndtime(list.get(6));
		copyright.setCopyPublishtime(list.get(7));
		copyright.setCopyRegisttime(list.get(8));
		copyright.setCopyCost(list.get(9));
		copyright.setCopyInvoiceper(list.get(10));
		copyright.setCopyStatus(list.get(11));
	}
}
