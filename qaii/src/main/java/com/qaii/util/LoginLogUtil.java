package com.qaii.util;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kunpeng on 2019/1/16 15:43
 */
//登陆日志功能OK已经可以使用了
public class LoginLogUtil {
    public static void showlog(String IP,String userName,int rolestatus) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss a E");
        String f="C:\\用户登陆记录日志.log";
        //写入流
        BufferedWriter bw= new BufferedWriter(new FileWriter(f,true));
        String System=null;
        switch (rolestatus){
            case 1:
                System="hkp处";
                break;
            case 2:
                System="人事处";
                break;
            case 3:
                System="科技处管理";
                break;
            case 4:
                System="产业化处";
                break;
        }

        bw.write(sdf.format(new Date())+": "+"用户: "+userName+"在主机"+IP+"登陆了"+System+"系统");
        //换一行
        bw.newLine();
        //刷新清空缓存
        bw.flush();
        //关闭流
        bw.close();
    }
}
