package com.xxx.service;

import com.xxx.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.utils.Result;

/**
* @author 彭生
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-11-02 14:24:32
*/
public interface UserService extends IService<User> {

    Result login(User user);

    Result getUserInfo(String token);

    Result checkUserName(User user);

    Result regist(User user);
}
