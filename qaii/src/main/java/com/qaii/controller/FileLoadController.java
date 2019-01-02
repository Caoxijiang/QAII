package com.qaii.controller;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

/**
 * Created by kunpeng on 2018/12/27 9:39
 */
@Controller
public class FileLoadController {
    private String fileLocal = "C:\\";

    /**
     * TODO 下载文件到本地
     */
    //单个文件下载
    @RequestMapping( value = "Fileupload.do", method = RequestMethod.POST )
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //String decode=new String(request.getParameter("strZipPath").getBytes("iso-8859-1"), "utf-8");
        String decode=request.getParameter("strZipPath");
        //String dec="http://localhost:8080//img/TradeMark/File/%E6%99%BA%E8%83%BD%E4%BA%A7%E4%B8%9A%E5%AD%B5%E5%8C%96%E4%B8%AD%E5%BF%83/10/6/a471d5c0dc1a4c7ea58d250cf23d72f7.jpg";
        //根据路径取出文件名
        int i = decode.lastIndexOf("/");
        String fileName = decode.substring(i + 1);
        System.out.println(decode);
     /*   String result = "";
        int index = decode.indexOf("智");
        result = decode.substring(0,index);
        String temp = decode.substring(index,index+8);*/
        String encode = URLEncoder.encode(decode, "utf-8");
        encode = encode.replace("%3D",  "=");
        encode = encode.replace("%2F", "/");
        encode = encode.replace("+", "%20");
        encode = encode.replace("%26", "&");
        encode = encode.replace("%3A", ":");
        encode = encode.replace("%2C", ",");
       /* result += encode;*/
        System.out.println("转码后的url:"+encode);
        //获取请求reffer
        String referer = request.getHeader("referer");

        StringBuffer unicode = new StringBuffer();
        URL url = new URL(encode);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        //BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream(),"utf-8"));
        urlCon.setConnectTimeout(6000);
        urlCon.setReadTimeout(6000);
        /*urlCon.setRequestProperty("Content-Type", "application/json");*/
        //这里就是给请求url添加header
        urlCon.setRequestProperty("referer", referer);
        urlCon.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        urlCon.connect();
        //读文件流
        InputStream inputStream = urlCon.getInputStream();
        byte[] bs = readInputStream(inputStream);
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        BufferedOutputStream output = null;
        BufferedInputStream input = null;
        try {
            output = new BufferedOutputStream(response.getOutputStream());
            // 中文文件名必须转码为 ISO8859-1,否则为乱码
            String fileNameDown = new String(fileName.getBytes(), "ISO8859-1");
            // 作为附件下载
            response.setHeader("Content-Disposition", "attachment;filename=" + fileNameDown);

            output.write(bs);
            response.flushBuffer();
            System.out.println("jkkkjkkkjkjkrolin");
        } catch (Exception e) {
            System.out.println("kankan");
        } // 用户可能取消了下载
        finally {
            if (input != null)
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (output != null)
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();

                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
