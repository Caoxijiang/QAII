package com.qaii.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kunpeng on 2018/11/27 16:20
 */
public class FileLogUtil {
    public static void showlog(String str) throws IOException {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yy-MM-dd hh:mm:ss a E");
        String f="C:\\删除的路径日志.log";
        //写入流
        BufferedWriter bw= new BufferedWriter(new FileWriter(f,true));
        bw.write(sdf2.format(new Date())+": "+"删除了路径: "+str);
        //换一行
        bw.newLine();
        //刷新清空缓存
        bw.flush();
        //关闭流
        bw.close();
    }

}
