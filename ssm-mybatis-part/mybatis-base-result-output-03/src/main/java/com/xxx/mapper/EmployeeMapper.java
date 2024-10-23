package com.xxx.mapper;

import com.xxx.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
//    插入修改删除
    int deleteById(Integer id);

//    查询
    String querynameById(Integer id);

    Double querySalaryById(Integer id);

    Map<String, Object> queryEmployeeById();

    List<String> queryEmployeeName(Double salary);

    List<Employee> queryEmployee();

//    员工插入
    int insertEmp(Employee employee);
}
