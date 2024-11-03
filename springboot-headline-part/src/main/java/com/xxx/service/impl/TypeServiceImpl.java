package com.xxx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.pojo.Type;
import com.xxx.service.TypeService;
import com.xxx.mapper.TypeMapper;
import com.xxx.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 彭生
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-11-02 14:24:32
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Result findAllTypes() {
        List<Type> types = typeMapper.selectList(null);

        return Result.ok(types);

    }

}




