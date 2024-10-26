package com.xxx.param;


import com.xxx.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("param")
public class ParamController {

//    直接接收
    @RequestMapping("data")
    @ResponseBody
    public String data(String name,int age){
        System.out.println("name = " + name + ", age = " + age);
        return "name = " + name + ", age = " + age  ;
    }
//    注解指定

    public String data1(@RequestParam(value = "account") String username, @RequestParam(required = false,defaultValue = "1") int page){
        return "name = " + username + ", age = " + page;
    }
//    特殊值

    @GetMapping("data2")
    @ResponseBody
    public String data2(@RequestParam List<String> hbs){
        System.out.println("hbs = " + hbs);
        return "ok";
    }


//    使用实体类对象接值
    @GetMapping("data3")
    @ResponseBody
    public String data3(User user){
        System.out.println("user = " + user);
        return user.toString();
    }



}
