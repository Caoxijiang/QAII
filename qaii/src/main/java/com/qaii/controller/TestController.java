/*


package com.qaii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


*/
/**
 * Created by kunpeng on 2018/12/27 14:14
 *//*


//批量下载
@Controller
public class TestController {
    @RequestMapping(value="FileupLoadAlls.do",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        BufferedOutputStream output = null;
        BufferedInputStream input = null;
        InputStream inputStream=null;
        URL url=null;
        List<String> filepath=new ArrayList<>();
        String Filepath=request.getParameter("code");
        System.out.println("----------------------------------------------");
        String[] sourceStrArray = Filepath.split(",");//分割出来的字符数组
        for (int i = 0; i < sourceStrArray.length; i++) {

            filepath.add(sourceStrArray[i]);
            System.out.println(sourceStrArray[i]);
        }
        //解决form表单提交乱码问题
        */
/*String decode=URLDecoder.decode(fileUrl,"UTF-8");*//*

        try {
            for (String str : filepath) {
                int i = str.lastIndexOf("/");
                String fileName = str.substring(i + 1);
                System.out.println(str);
            */
/* String wjurl="http://localhost:8080/img//138/18/e817e8c6aefd412aa3762cf02091d6a1.jpg";*//*

            url = new URL(str);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            String referer = request.getHeader("referer");
            conn.setRequestProperty("referer", referer);
            //得到输入流
            inputStream = conn.getInputStream();
            //获取自己数组
            byte[] bs = readInputStream(inputStream);
            System.out.println(bs);
            response.setContentType("application/octet-stream;charset=ISO8859-1");

            try {
                output = new BufferedOutputStream(response.getOutputStream());
                // 中文文件名必须转码为 ISO8859-1,否则为乱码
                String fileNameDown = new String(fileName.getBytes(), "ISO8859-1");
                // 作为附件下载
                response.setHeader("Content-Disposition", "attachment;filename=" + fileNameDown);
                System.out.println("---------------------------+"+bs);
                output.write(bs);
                output.flush();
            } catch (Exception e) {
                System.out.println("kankan");
            } // 用户可能取消了下载
            finally {
                if (input != null) try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (output != null) try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


*/
/**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     *//*



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

*/
