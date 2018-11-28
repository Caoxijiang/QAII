package com.qaii.controller;
import com.qaii.service.WorkService;
import com.qaii.util.DeleteFileUtil;
import com.qaii.util.FileLogUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by kunpeng on 2018/11/21 16:00
 */
 @Component
 public class TaskDemo {
    @Resource
    private WorkService workService;
    //数据库文件路径
    List<String> listpath = new ArrayList<>();
    //磁盘文件路径用来存储文件名来和UUID的数据库文件比较
    List<String> listlocalPath = new ArrayList<>();
    //存储文件完整路径
    List<String> listlocalPaths = new ArrayList<>();
    @Scheduled(cron = "0 0 1 * * ?")
    void doSomethingWith() throws IOException {
        //获取数据库中所有的与路径有关的Table名称
        //获取file_path列名的数据库的名字；
        List<String> listfilepathtable= workService.selectTable();
        //获取列名为path的数据库中Table名称
        List<String> lidtTableNamepath=workService.selectTablenamePath();
        //这里根据不同字段的表查出里面的路径，然后放在一起；
      for (int i = 0; i < listfilepathtable.size(); i++) {
            //逐个遍历表名，从各表中取出所有的路径；
            //把数据库中所有的路径放在listpath中；
            List<String> FilePath = workService.selectPathBytableName(listfilepathtable.get(i));
            for (String str1:FilePath){
               String str2=str1.replaceAll("\\\\","/");
                if (str2.contains("/")){
                    int j = str2.lastIndexOf("/");
                    listpath.add(str1.substring(j+1));
                }
            }
            }
      for (int i =0;i<lidtTableNamepath.size();i++ ){
            List<String> Path=workService.selectPathBytableNamePath(lidtTableNamepath.get(i));
            for (String str:Path){
               String str3=str.replaceAll("\\\\","/");
                if (str3.contains("/")){
                    int j=str3.lastIndexOf("/");
                    listpath.add(str.substring(j+1));
                }
            }
        }
        //单独获取表中字段为url的数据库的路径值
        List<String> url=workService.selectqueUrl();
        for (String urlpath:url){
            String strurl=urlpath.replaceAll("\\\\","/");
            if (strurl.contains("/")){
                int j=strurl.lastIndexOf("/");
                listpath.add(strurl.substring(j+1));
            }
        }
        //遍历所有的磁盘总盘即C、D、E、F等盘；
      /* File [] roots = File.listRoots();
        for(File f:roots){
            showDirectory(f);
        }*/
        //对两个数组中的路径进行比较
        File file = new File("C:\\File");
        //遍历磁盘路径
        showDirectory(file);
        //将数据库中的文件路径和磁盘中的路径进行比较
        Compare();
        //清空缓存
        listlocalPaths.clear();
        listlocalPath.clear();
        listpath.clear();
        //删除空文件夹
        DelNullDir nullDir=new DelNullDir();
        nullDir.ShowDir(file);
    }
    //遍历磁盘中所有的文件
    public  void showDirectory(File file) {
        /**
         * 用File[]数组得到E:\qwerty目录下的--所有子文件夹-路径
         * 用List<File>列表得到E:\qwerty目录下的--所有文件-路径
         */
        // 创建一个空的ArrayList对象fileList
        List<File> fileList = new ArrayList<File>();
        // file.listFiles()返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件和目录。
        // 返回值是一个 File[]数组
        File[] files = file.listFiles();

        // 如果目录为空，直接退出
        if (files == null) {
            return;
        }
        // foreach遍历files数组
        for (File a : files) {
            if (a.isFile()) {
                // boolean isFile()判断是否为文件，是文件返回true，否则返回false
                fileList.add(a);// 是文件，则添加到List<File>中
            } else if (a.isDirectory()) {
                // boolean isDirectory()判断是否为目录，是目录返回true，否则返回false
                // String getAbsolutePath()获得文件与子文件夹的绝对路径
                // 递归调用showDirectory(File file)方法
                showDirectory(a);
            }
        }
        // foreach遍历fileList列表
        for (File f2 : fileList) {
            //文件完整路径
            listlocalPaths.add(f2.getAbsolutePath());
            //文件名
            listlocalPath.add(f2.getName());
        }
    }

  public void Compare() throws IOException {
       for (String str:listlocalPath) {
           //如果磁盘里面的文件名在数据库中存在，则保留；不存在则进行删除
           if (listpath.contains(str)) {
           //如果数据库里面的文件路径在磁盘里面不存在，那么将他们从磁盘中删除。
           } else {
               for (String filepath : listlocalPaths) {
                   //判断完整文件名包含不在数据库中的文件名的情况；
                   if (filepath.contains(str)) {
                      System.out.println("Come on beach");
                      System.out.println("现在就只剩那些在数据库中不存在的路径了");
                      DeleteFileUtil.delete(filepath);
                      FileLogUtil.showlog(filepath);
                      System.out.println("删除文件的日志功能");
                   }
               }
           }
       }
    }
    //妈的递归算法真的好使
    //这里用来删除空文件夹
  public class DelNullDir {
        public void ShowDir(File f){
            for (File f1:f.listFiles()){
                if(f1.isDirectory()){
                    ShowDir(f1);
                    //一直递归到最后的目录
                    if(f1.listFiles().length==0){
                        //如果是文件夹里面没有文件证明是空文件，进行删除
                        f1.delete();
                    }
                }
            }
        }
    }

}