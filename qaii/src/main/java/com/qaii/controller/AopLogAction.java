package com.qaii.controller;

import com.qaii.domain.CommitLog;
import com.qaii.service.CommitLogService;
import com.qaii.util.SystemLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
//c://用户操作日志.log
@Aspect
@Component
public class AopLogAction {

    @Resource
    private CommitLogService service;

    @Pointcut("execution(* com.qaii.controller.*.*(..))")
    private void controlAspect(){}

    @Around("controlAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        CommitLog log = new CommitLog();
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String name = (String)request.getSession().getAttribute("name");
        log.setUserId(name);
        String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
        log.setData(time);
        log.setIdAddress(request.getRemoteAddr());
        long start = System.currentTimeMillis();
        Object target = pjp.getTarget();
        //当前正在执行的方法
        String methodName = pjp.getSignature().getName();
        //参数
        Object[] args = pjp.getArgs();
        //参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig =null;
        if(!(sig instanceof MethodSignature)){
            throw  new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] paramterTypes = msig.getMethod().getParameterTypes();
        Object object = null;
        Method method =null;
        try{
            method = target.getClass().getMethod(methodName, paramterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if(method != null){
            if(method.isAnnotationPresent(RequestMapping.class)){
//                SystemLog systemLog = method.getAnnotation(SystemLog.class);
//                log.setModule(systemLog.module());
//                log.setMethod(systemLog.method());
                RequestMapping mapping = method.getAnnotation(RequestMapping.class);
                log.setMethod(mapping.value()[0]);
                try {
                    object = pjp.proceed();
                    log.setResponseData("" + (System.currentTimeMillis() - start));
                    log.setResult("执行成功");
                    service.insertRecord(log);
                } catch (Throwable throwable) {
                    log.setResponseData("" + (System.currentTimeMillis() - start));
                    log.setResult("执行失败");
                    service.insertRecord(log);
                    throwable.printStackTrace();
                }
            }else {
                object = pjp.proceed();
            }
        }else {
            object = pjp.proceed();
        }
        return object;
    }
}
