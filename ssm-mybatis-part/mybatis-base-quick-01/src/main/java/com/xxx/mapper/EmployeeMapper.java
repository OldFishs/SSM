package com.xxx.mapper;


import com.xxx.pojo.Employee;

//规定数据库方法
public interface EmployeeMapper {

    Employee queryById(Integer id);

    int deleteById(Integer id);
}
