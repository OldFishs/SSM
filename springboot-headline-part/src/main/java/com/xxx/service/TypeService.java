package com.xxx.service;

import com.xxx.pojo.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.utils.Result;

/**
* @author 彭生
* @description 针对表【news_type】的数据库操作Service
* @createDate 2024-11-02 14:24:32
*/
public interface TypeService extends IService<Type> {

    Result findAllTypes();


}
