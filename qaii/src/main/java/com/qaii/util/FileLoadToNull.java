package com.qaii.util;

import java.lang.reflect.Field;
import java.util.Date;

public class FileLoadToNull {
    public static Object getNullClass(String className) throws Exception{
        Class clazz = Class.forName(ConstantUtil.DOMAIN_PREFIX + className);
        Object obj = clazz.getConstructor().newInstance();
        Field field = clazz.getDeclaredField("fileName");
        field.setAccessible(true);
        field.set(obj, "null");
        field = clazz.getDeclaredField("filePath");
        field.setAccessible(true);
        field.set(obj, "null");
        field = clazz.getDeclaredField("fileDescribtion");
        field.setAccessible(true);
        field.set(obj, "null");
        field = clazz.getDeclaredField("fileCreatetime");
        field.setAccessible(true);
        field.set(obj, new Date());
        field = clazz.getDeclaredField("fileModifytime");
        field.setAccessible(true);
        field.set(obj, new Date());
        return obj;
    }
}
