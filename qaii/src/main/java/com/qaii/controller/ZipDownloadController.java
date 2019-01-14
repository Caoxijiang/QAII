package com.qaii.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by kunpeng on 2018/12/29 9:49
 */
@Controller
public class ZipDownloadController {
    @RequestMapping( value = "FileupLoadAlls.do", method = RequestMethod.GET )
    public void downLoadImage(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String referer=request.getHeader("referer");
       String Filepath=request.getParameter("code");
        //String Filepath=new String(request.getParameter("code").getBytes("iso-8859-1"), "utf-8");
       // String Filepath=new String(request.getParameter("code").getBytes("iso-8859-1"), "utf-8");
        String encode = URLEncoder.encode(Filepath, "utf-8");
        encode = encode.replace("%3D",  "=");
        encode = encode.replace("%2F", "/");
        encode = encode.replace("+", "%20");
        encode = encode.replace("%26", "&");
        encode = encode.replace("%3A", ":");
        encode = encode.replace("%2C", ",");
        /* result += encode;*/
       // System.out.println("转码后的url:"+encode);
        List<String> urls = new ArrayList();
        String[] sourceStrArray = encode.split(",");//分割出来的字符数组
        for (int i = 0; i < sourceStrArray.length; i++) {

            urls.add(sourceStrArray[i]);
            System.out.println(sourceStrArray[i]);
        }

      /*  urls.add("http://localhost:8080/img//138/18/e817e8c6aefd412aa3762cf02091d6a1.jpg");
        urls.add("http://localhost:8080/img//138/18/2ddd40f0ff4c4bd38ecb9c6942a5d008.png");*/
        Map<String, InputStream> isMap = new HashMap();
        for (String str:urls) {
            String[] fileNameParts = str.split("/");
            String fileName = fileNameParts[fileNameParts.length - 1];
            try {
                URL url = new URL(str);
                URLConnection con = url.openConnection();
                // 设置超时间为3秒
                con.setConnectTimeout(3 * 1000);
                // 防止屏蔽程序抓取而返回403错误
                con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                con.setRequestProperty("referer",referer);
                InputStream is = con.getInputStream();
                isMap.put(fileName, is);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        response.setContentType("application/octet-stream");
        String filename = URLEncoder.encode("打包文件", "UTF8");
        //作为附件下载
        response.setHeader("Content-Disposition", "attachment; filename=" + filename + ".zip");
        ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());
      for (String key:isMap.keySet()){
          addToZip( isMap.get(key), zipOut, key);
      }
     /*   isMap.forEach((fileName, is) -> {
            try {
                addToZip(is, zipOut, fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });*/
        zipOut.flush();
        zipOut.close();
    }
    //将文件输出到压缩文件当中
    private void addToZip(InputStream is, ZipOutputStream zipOut, String fileName) throws IOException {
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //将文件转化成ZIP压缩包
        //压缩流的使用
        ZipEntry entry = new ZipEntry(fileName);
        zipOut.putNextEntry(entry);
        int len;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) > 0) {
            zipOut.write(buffer, 0, len);
        }
        zipOut.closeEntry();
        is.close();
    }

}
