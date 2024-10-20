package com.xxx.service.impl;

import com.xxx.dao.StudentDao;
import com.xxx.pojo.Student;
import com.xxx.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findall() {
        List<Student> studentList = studentDao.querydAll();
        System.out.println(studentList);
        return studentList;
    }
}
