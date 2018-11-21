package com.qaii.util;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @Company: 青岛智能产业技术研究院
 * @author: wangxin
 * @Descrpiton: 文件表的实体类工厂
 * @Time 2018-11-19 10:15
 */

public class fileDomainFactory {
    public static Object getNullClass(String className) throws Exception{
        Class clazz = Class.forName(ConstantUtil.DOMAIN_PREFIX + className);
        Object obj = clazz.getConstructor().newInstance();
        Field field = clazz.getDeclaredField("fileName");
        field.setAccessible(true);
        field.set(obj, "null");
        field = clazz.getDeclaredField("fileStyle");
        field.setAccessible(true);
        field.set(obj, "null");
        field = clazz.getDeclaredField("filePath");
        field.setAccessible(true);
        field.set(obj, "null");
        field = clazz.getDeclaredField("fileDescription");
        field.setAccessible(true);
        field.set(obj, "null");
        field = clazz.getDeclaredField("gmtCreate");
        field.setAccessible(true);
        field.set(obj, new Date());
        field = clazz.getDeclaredField("gmtModified");
        field.setAccessible(true);
        field.set(obj, new Date());
        return obj;
    }
}
