package com.xxx.mapper;

import com.xxx.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    Employee queryById(Integer id);

    int deleteById(Integer id);

    List<Employee> queryBySalary(Double salary);
    List<Employee> queryBySalary2(Double salary,String name);

}
