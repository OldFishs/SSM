package com.xxx.test;

import com.xxx.config.JavaConfig;
import com.xxx.controller.StudentController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {

    @Test
    public void test(){
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(JavaConfig.class);

        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.findAll();
    }
}
