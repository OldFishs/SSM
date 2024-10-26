package com.xxx.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("user")

public class UserController {

    @RequestMapping( )
    public String index(){
        return null;
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(){
        return null;
    }

    @RequestMapping(value = "register",method = {RequestMethod.GET, RequestMethod.POST})
    public String register(){
        return null;
    }

}
