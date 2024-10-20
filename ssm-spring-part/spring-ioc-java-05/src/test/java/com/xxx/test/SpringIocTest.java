package com.xxx.test;

import com.xxx.config.JavaConfiguration;
import com.xxx.config.JavaConfigurationA;
import com.xxx.ioc_01.StudentController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {

    @Test
    public void test(){
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        StudentController bean = applicationContext.getBean(StudentController.class);
        System.out.println(bean);
    }


    @Test
    public void test2(){
        ApplicationContext applicationContext
                =  new AnnotationConfigApplicationContext(JavaConfigurationA.class);


    }
}
