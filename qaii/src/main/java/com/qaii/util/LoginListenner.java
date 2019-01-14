/*
package com.qaii.util;

import com.qaii.domain.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * Created by kunpeng on 2019/1/8 16:50
 *//*

public class LoginListenner implements HttpSessionAttributeListener {
    */
/**
     * 用于存放账号和session对应关系的map
     *//*

    private Map<String, HttpSession> map =new HashMap<String, HttpSession>();

    */
/**
     * 当向session中放入数据触发
     *//*

    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();

        if (name.equals("user")) {
            User user = (User) event.getValue();
            if (map.get(user.getAdminAccount()) != null) {
                HttpSession session = map.get(user.getAdminAccount());
                session.removeAttribute(user.getAdminAccount());
                session.invalidate();
            }
            map.put(user.getAdminAccount(), event.getSession());
        }

    }

    */
/**
     * 当向session中移除数据触发
     *//*

    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();

        if (name.equals("user")) {
            User user = (User) event.getValue();
            map.remove(user.getAdminAccount());

        }
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {

    }

    public Map<String, HttpSession>

    getMap() {
        return map;
    }

    public void setMap(Map<String, HttpSession>map) {
        this.map = map;
    }
}*/
