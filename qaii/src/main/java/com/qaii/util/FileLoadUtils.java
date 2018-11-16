package com.qaii.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileLoadUtils {
	//文件上传
	public static Map<String,Object> fileload(MultipartFile[] files,String path) throws IOException{
		Map<String,Object> result = new HashMap<>();
		if (files != null && files.length < 0) {
			result.put("code","1");
			result.put("msg", "未找到文件");			
		}
		for (int i = 0; i < files.length; i++) {
			if(files[i].getSize()==0) {
				continue;
			}
			 List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			 Map<String,Object> result2 = new HashMap<>();
			 String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf(".")); 
			 String name=files[i].getOriginalFilename();
			 result2.put("oldName", name);
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			String filename = uuid + type;// 取当前时间戳作为文件名
			result2.put("newName", filename);
			File destFile = new File(path + "/" + filename);
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			try {
				files[i].transferTo(destFile);
				String URL=destFile.getPath();
				result2.put("URL",URL);
				list.add(result2);
				String index=""+i+"";
				result.put(index,list);
				
				
			} catch (IllegalStateException | IOException e) {
				throw new IOException("file load err"+e);
				
			}
		}
		return  result;

	}

	//上传文件并返回新的文件名
	public static List<String> moveFileAndReturnName(MultipartFile[] files, String path) throws IOException {
		List<String> list = new ArrayList<>();
		if (files != null && files.length < 0) {
			return null;
		}
		for (int i = 0; i < files.length; i++) {
			if(files[i].getSize()==0) {
				list.add("null");
				continue;
			}
			String type = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
			String uuid = UUID.randomUUID().toString().replaceAll("-","");
			String filename = uuid + type;
			list.add(filename);
			File destFile = new File(path + filename);
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			try {
				files[i].transferTo(destFile);
			} catch (IllegalStateException | IOException e) {
				throw new IOException("file load err"+e);
			}
		}
		return list;
	}
	
	//删除文件
    public static void delFile(String path,String filename){
        File file=new File(path+"/"+filename);
        if(file.exists()&&file.isFile())
            file.delete();
    }
}
