package com.xxx.ioc_03;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


//    自动装配注解(di)
    @Autowired
    private UserService userService;

//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @Resource(name = "userServiceImpl")
    public UserService userService1;
    public void show(){
        String show = userService.show();
        System.out.println(show);
    }
}
