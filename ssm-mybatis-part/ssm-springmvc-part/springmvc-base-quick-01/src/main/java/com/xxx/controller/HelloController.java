package com.xxx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HelloController {

    @RequestMapping("springmvc/hello")//对外访问的地址，到handlerMappering注册的注解
    @ResponseBody//直接返回字符串给前端
    public String hello() {
        System.out.println("hello");
        return "hello mvc";
    }
}
