package com.caoxijiang.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class helloworld {
    @RequestMapping(path = "/")
   // @ResponseBody
    String home() {
        System.out.println("lslslls");
        return "index";
    }
}
