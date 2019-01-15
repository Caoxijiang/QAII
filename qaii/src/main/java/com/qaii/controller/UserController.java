package com.qaii.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qaii.util.MemoryData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.sf.json.JSONObject;
import com.qaii.domain.User;
import com.qaii.domain.UserRole;
import com.qaii.service.UserRoleService;
import com.qaii.service.UserService;

import com.qaii.util.JsonResult;

@Controller
@SessionAttributes( "user" )
public class UserController {
    @Resource
    private UserService userServivce;
    @Resource
    private UserRoleService userRoleService;

    //正常访问login页面
    @RequestMapping( "login.do" )
    public String login() {
        return "page/login";
    }

    //表单提交过来的路径
    @ResponseBody
    @RequestMapping( value = "checkLogin.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8" )
    public JsonResult login(User user, HttpSession session, String requestDate,HttpServletRequest request) {
        Map map = new HashMap();
        JSONObject requestJson = JSONObject.fromObject(requestDate);
        map.put("name", requestJson.getString("name"));
        map.put("password", requestJson.getString("password"));
        user.setAdminAccount(requestJson.getString("name"));
        user.setAdminPwd(requestJson.getString("password"));
        User user2 = userServivce.checkLogin(user);
        //新增接口

//新增接口
        if(user2!=null){
                //int userid=user2.getUserId();
                UserRole role=new UserRole();
                role.setUid(user2.getUserId());
                //新增接口以下
                //新增接口以上
                UserRole role2=userRoleService.findUSerRoleByUserId(role.getUid());
                //UserRole role2=userRoleService.findUSerRoleByUserId(userid);
                //登录成功，将user对象设置到HttpSession作用范围
                session.setAttribute("user",user);
                String sessionID = request.getRequestedSessionId();
                String user1 = user2.getAdminAccount();
                if (!MemoryData.getSessionIDMap().containsKey(user1)) { //不存在，首次登陆，放入Map
                   MemoryData.getSessionIDMap().put(user1, sessionID);
                  }else if(!StringUtils.equals(sessionID, MemoryData.getSessionIDMap().get(user1))&&MemoryData.getSessionIDMap().containsKey(user1)){
//                    System.out.println(111);
                  MemoryData.getSessionIDMap().remove(user1);
                  MemoryData.getSessionIDMap().put(user1, sessionID);
                }
                //账号页面跳转
                Map map2=new HashMap();
                map2.put("LOGINSTATUS","OK");
                switch(role2.getRid()){
                case 1:
                map2.put("USERROLEURL","Role.do");
                return new JsonResult(map2);
                case 2:
                map2.put("USERROLEURL","personal.do");
                return new JsonResult(map2);
                case 3:
                map2.put("USERROLEURL","indexScience.do");
                return new JsonResult(map2);
                case 4:
                map2.put("USERROLEURL","indexIndustry.do");
                case 5:
                map2.put("USERROLEURL","dataindexNav.do");
                return new JsonResult(map2);
                default:
                map2.put("USERROLEURL","indexUI.do");
                return new JsonResult(map2);

        }

        }else{
        System.out.println("ERR");
        session.setAttribute("tip","登录失败！");
        //登录失败，设置失败信息，并调转到登录页面
        return new JsonResult();
        }

        }


//注销方法
@RequestMapping( "outLogin.do" )
public String outLogin(HttpServletRequest req,HttpServletResponse res,HttpSession session)throws IOException{
        //通过session.invalidata()方法来注销当前的session

        //session=req.getSession();
        session.invalidate();
        //System.out.println(session.getAttribute("user"));
        //session.removeAttribute("user");

        // System.out.println(session.getAttribute("user"));
        //  res.sendRedirect("login.do");
        return"page/login";
        }


@ResponseBody
@RequestMapping( value = "DellUserAccount.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8" )
public JsonResult DellUserAccount(@RequestParam( value = "requestDate[]" ) Integer[]userId){

        int row=userServivce.delete(userId);
        if(row!=0){
        return new JsonResult(row);
        }else{
        return new JsonResult();

        }

        }


        }

