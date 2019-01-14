package com.qaii.util;

import java.util.HashMap;
import java.util.Map;

/* * Created by kunpeng on 2019/1/8 10:44*/



public class MemoryData {
    private static Map<String, String> sessionIDMap = new HashMap<String, String>();

    public static Map<String, String> getSessionIDMap() {
        return sessionIDMap;
    }

    public static void setSessionIDMap(Map<String, String> sessionIDMap) {
        MemoryData.sessionIDMap = sessionIDMap;
    }

}
