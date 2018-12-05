package com.qaii.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImgLoadResult {
    private static String PATH="C:/File/img/industry/";
    public boolean myResult;
    private MultipartFile[] files;
    private List<Map<String, Object>> list2;
    private Map<String, Object> result;

    public ImgLoadResult(MultipartFile... files) {
        this.files = files;
    }

    public boolean is() {
        return myResult;
    }

    public List<Map<String, Object>> getList2() {
        return list2;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public ImgLoadResult invoke() {
        List<Map<String, Object>> list;
        result = new HashMap<>();
        try {
            // 文件上传结果
            result = FileLoadUtils.fileload(files, PATH);
            list = (List<Map<String, Object>>) result.get("0");
            list2 = (List<Map<String, Object>>) result.get("1");
        } catch (IOException e1) {
            myResult = true;
            return this;
        }
        myResult = false;
        return this;
    }
}
