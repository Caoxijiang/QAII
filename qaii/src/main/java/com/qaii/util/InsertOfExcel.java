package com.qaii.util;

import com.qaii.domain.Ministry;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Company: 青岛智能产业技术研究院
 * @author: wangxin
 * @Descrpiton: 通过反射实现快捷的导入方法
 * @Time 2018-11-16 16:35
 */

public class InsertOfExcel {

    /**
     * @param: className:完整的控制器名称 , recordName:完整的类名称
     *
     * @Time 2018/11/20
     */

    public static int insertExcel(String className, String recordName, MultipartFile file) throws Exception {
        Class clazz = Class.forName(ConstantUtil.CONTROLLER_PREFIX + className);
        Class recordClazz = Class.forName(ConstantUtil.DOMAIN_PREFIX + recordName);
        Object obj=clazz.newInstance();
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
                    Method method = clazz.getDeclaredMethod("insertExcelData", recordClazz, List.class);
                    method.setAccessible(true);
                    method.invoke(obj, new Object[]{recordClazz.getConstructor().newInstance(), list});
                }
            }
        }catch(Exception e) {
            wookbook.close();
            e.printStackTrace();
            return ConstantUtil.BYTE_FALSE;
        }
        wookbook.close();
        return ConstantUtil.BYTE_TRUE;
    }


}
