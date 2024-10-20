package com.xxx;

import com.xxx.controller.StudentController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {

    @Test
    public void test(){
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");

        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.findAll();
    }
}
