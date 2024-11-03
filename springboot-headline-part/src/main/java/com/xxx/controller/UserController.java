package com.xxx.controller;


import com.xxx.pojo.User;
import com.xxx.service.UserService;
import com.xxx.utils.JwtHelper;
import com.xxx.utils.Result;
import com.xxx.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtHelper jwtHelper;


    @PostMapping("login")
    public Result login(@RequestBody User user) {

        Result result = userService.login(user);
        return result;

    }

    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token) {

        Result result = userService.getUserInfo(token);
        return result;

    }

    @PostMapping("checkUserName")
    public Result checkUserName(User user) {

        Result result = userService.checkUserName(user);
        return result;
    }

    @PostMapping("regist")
    public Result regist(@RequestBody User user) {

        Result result = userService.regist(user);
        return result;
    }

    @GetMapping("check")
    public Result checkLogin(@RequestHeader String token) {

        boolean expiration = jwtHelper.isExpiration(token);

        if (expiration) {

            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        } else {

            return Result.ok(null);
        }
    }
}
