package com.qaii.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Company: 青岛智能产业技术研究院
 * @author: wangxin
 * @Descrpiton: 通过反射实现快捷的导入方法
 * @Time 2018-11-16 16:35
 */

public class InsertOfExcel {
    public static int insertExcel(String classname, MultipartFile file) throws Exception {
        Class clazz = Class.forName("com.qaii.controller." + classname);
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

        return 0;
    }
}
