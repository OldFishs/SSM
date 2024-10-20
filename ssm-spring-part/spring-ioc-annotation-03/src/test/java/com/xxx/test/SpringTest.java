package com.xxx.test;

import com.xxx.ico_01.XxxDao;
import com.xxx.ioc_02.JavaBean;
import com.xxx.ioc_03.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {

    @Test
    public void testIoc_01(){
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");
        XxxDao bean = applicationContext.getBean(XxxDao.class);
        System.out.println(bean);

//        添加ioc注解，默认组件名为类的首字母小写
        Object bean1 = applicationContext.getBean("xxxService");
        System.out.println(bean1);
    }

    @Test
    public void testIoc_02(){
        ClassPathXmlApplicationContext applicationContext
                =  new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean = applicationContext.getBean(JavaBean.class);
        JavaBean bean1 = applicationContext.getBean(JavaBean.class);
        System.out.println(bean == bean1);
    }

    @Test
    public void testIoc_03(){
        ClassPathXmlApplicationContext applicationContext
                =  new ClassPathXmlApplicationContext("spring-03.xml");
        UserController bean = applicationContext.getBean(UserController.class);

        bean.show();
    }

    @Test
    public void testIoc_04(){
        ClassPathXmlApplicationContext applicationContext
                =  new ClassPathXmlApplicationContext("spring-04.xml");

        com.xxx.ioc_04.JavaBean bean = applicationContext.getBean(com.xxx.ioc_04.JavaBean.class);
        System.out.println(bean);
    }
}
