package com.xxx.service;

import com.xxx.dao.StudentDao;
import com.xxx.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    //StudentService实际上是接口
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.findAll();
        return studentList;
    }
}
