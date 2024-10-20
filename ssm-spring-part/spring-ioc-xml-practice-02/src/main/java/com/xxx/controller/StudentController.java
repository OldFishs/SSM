package com.xxx.controller;

import com.xxx.dao.StudentDao;
import com.xxx.pojo.Student;
import com.xxx.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findAll(){
        List<Student> findall = studentService.findall();
        System.out.println("学员数据为" + findall );
    }
}
