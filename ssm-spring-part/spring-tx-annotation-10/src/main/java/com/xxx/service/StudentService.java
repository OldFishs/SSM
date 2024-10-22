package com.xxx.service;

import com.xxx.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;

    @Transactional(readOnly = false,timeout = 3)
    public void changeInfo(){
        studentDao.updateAgeById(100,1);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }
}