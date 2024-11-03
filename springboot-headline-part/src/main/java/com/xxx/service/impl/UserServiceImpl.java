package com.xxx.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.pojo.User;
import com.xxx.service.UserService;
import com.xxx.mapper.UserMapper;
import com.xxx.utils.JwtHelper;
import com.xxx.utils.MD5Util;
import com.xxx.utils.Result;
import com.xxx.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author 彭生
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-11-02 14:24:32
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result login(User user) {

        //查询用户名相同数据
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        User loginUser = userMapper.selectOne(lambdaQueryWrapper);

        //对比账号
        if(loginUser==null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        //对比密码
        if(!StringUtils.isEmpty(user.getUserPwd())   && MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())){
            //success
            //根据id生成token，封装，返回
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));

            Map<Object, Object> data = new HashMap<>();
            data.put("token",token);

            return Result.ok(data);
        }
            //failure
        return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {

        //是否过期  true过期
        boolean expiration = jwtHelper.isExpiration(token);
        if(expiration){
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }

        int userId = jwtHelper.getUserId(token).intValue();

        User user = userMapper.selectById(userId);
        user.setUserPwd("");

        Map<Object, Object> data = new HashMap<>();
        data.put("loginUser", user);

        return Result.ok(data);

    }

    // 检查用户名是否可用
    @Override
    public Result checkUserName(User user) {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        queryWrapper.eq(User::getUsername,user);
        Long count = userMapper.selectCount(queryWrapper);

        if(count == 0){
            return Result.ok(null);
        }
        return Result.build(null,ResultCodeEnum.USERNAME_USED);
    }

    // 注册
    @Override
    public Result regist(User user) {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        Long count = userMapper.selectCount(queryWrapper);

        if(count > 0){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }

        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        userMapper.insert(user);

        return Result.ok(null);
    }
}




