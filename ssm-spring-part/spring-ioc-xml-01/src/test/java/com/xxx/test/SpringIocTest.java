package com.xxx.test;

import com.google.common.reflect.ClassPath;
import com.xxx.ioc_03.HappyComponent;
import com.xxx.ioc_04.JavaBean2;
import com.xxx.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {

//    创建ioc组件
    public void createIoc(){
//      直接创建容器并指定文件、
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();


//        1 直接创建容器并且指定配置文件.(可以多个元素
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-03.xml");

//        2 先创建ioc容器再配置文件,再刷新
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocation("spring-03.xml");//外部文件配置
        applicationContext1.refresh();//调用ioc和di的流程
    }

//    在ioc容器中获取组件
    @Test
    public void getBeanFromIoc(){
//        1 创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("spring-03.xml");
        applicationContext.refresh();

//        2 读取ioc容器的组件
//        1 直接根据beanid获取 返回值object
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");

//        2 beanid同时指定bean类型Class
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);

//        3 直接根据类型获取
//        同一个类型在ioc容器中只能有一个bean
        HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);
        happyComponent2.dowork();
        System.out.println(happyComponent==happyComponent1);
        System.out.println(happyComponent==happyComponent2);
    }


//    ioc配置和销毁方法的触发
        @Test
        public void test_04(){
    //        1 创ioc 就会实例化   init
            ClassPathXmlApplicationContext applicationContext
                    = new ClassPathXmlApplicationContext("spring-04.xml");

            JavaBean2 bean = applicationContext.getBean(JavaBean2.class);
            JavaBean2 bean1 = applicationContext.getBean(JavaBean2.class);
            System.out.println(bean == bean1);
    //        2 结束ioc容器
            applicationContext.close();
        }


//        读取使用factoryBean工厂配置的组件对象
    @Test
    public void test_05(){
//        1 创ioc 就会实例化   init
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-05.xml");

//        2 读取组件
        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
        System.out.println(javaBean);

//        fb工厂也会加入ioc容器 名字&id
        Object bean = applicationContext.getBean("&javaBean");
        System.out.println(bean);
//        3 结束ioc容器
        applicationContext.close();
    }
}
