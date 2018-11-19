package com.qaii.util;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
public class BeanChangeUtil <T>{
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<Map<String, Object>> contrastObj(Object oldBean, Object newBean,String id) {
        StringBuilder str = new StringBuilder();
        List<Map<String, Object>> list=new ArrayList<>();
       // Map<String, Object> map=null;
        T pojo1 = (T) oldBean;
        T pojo2 = (T) newBean;
        try {
            // 通过反射获取类的类类型及字段属性
            Class clazz = pojo1.getClass();
            Field[] fields = clazz.getDeclaredFields();
            int i = 1;
         
            for (Field field : fields) {
            	Map<String, Object> map=new HashMap<>();
                // 排除序列化属性
                if ("serialVersionUID".equals(field.getName())) {
                    continue;
                }
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                // 获取对应属性值
                Method getMethod = pd.getReadMethod();
                Object o1 = getMethod.invoke(pojo1);
                Object o2 = getMethod.invoke(pojo2);
                if (o1 == null || o2 == null) {
                    continue;
                }
                if (!o1.toString().equals(o2.toString())) {
                    str.append(id + "、list_name:" + field.getName() + ",old:" + o1 + ",new:" + o2 + ";");
                    map.put("id", id);
                    map.put("list_name",field.getName());
                    map.put("old", o1);
                    map.put("new", o2);
                    list.add(map);
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       // return str.toString();
        return list;
    }

}
