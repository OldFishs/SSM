package com.xxx.dao;

import com.xxx.pojo.Student;

import java.util.List;
//数据层接口
public interface StudentDao {

//    数据库查询全部学生数据
    List<Student> querydAll();

}
