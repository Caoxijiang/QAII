package com.qaii.util;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class BeanChangeUtil <T>{
    @SuppressWarnings({"unchecked", "rawtypes"})
    public String contrastObj(Object oldBean, Object newBean) {
        StringBuilder str = new StringBuilder();
        T pojo1 = (T) oldBean;
        T pojo2 = (T) newBean;
        try {
            // 通过反射获取类的类类型及字段属性
            Class clazz = pojo1.getClass();
            Field[] fields = clazz.getDeclaredFields();
            int i = 1;
            for (Field field : fields) {
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
                    str.append(i + "、字段名称:" + field.getName() + ",旧值:" + o1 + ",新值:" + o2 + ";");
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toString();
    }

}
