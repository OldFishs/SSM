package com.xxx.test;


import com.xxx.config.JavaConfig;
import com.xxx.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;



@SpringJUnitConfig(JavaConfig.class)
public class SpringTxTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void test(){
        studentService.changeInfo();
    }
}
