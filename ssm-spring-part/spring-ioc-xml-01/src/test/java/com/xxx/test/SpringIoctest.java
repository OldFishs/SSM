package com.xxx.test;

import com.xxx.ioc_03.HappyComponent;
import com.xxx.ioc_04.javaBean2;
import com.xxx.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoctest {

//    创建ioc容器并读取配置文件
    public void createIoc(){
/*        创建容器
            接口
                BeanFactory

                ApplicationContext
            实现类
                可以通过构造函数实例化
                ClassPathXmlApplicationContext      读取类路径下的xml配置文件
                FileSystemXmlApplicationContext     读取指定文件位置的xml配置
                AnnotationConfigApplicationContext  读取配置类方式的ioc容器
                WebApplicationContext               web项目的专属ioc容器
* */
//      方式一 直接创建容器并指定配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");

//      方式二 先创建ioc容器对象，再指定配置文件，再刷新
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext();
        context1.setConfigLocation("spring-03.xml");
        context1.refresh();
    }

//    在ioc容器中获取bean（组件
    public void GetBeanFromIoc(){
//        1 创建ioc容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-03.xml");
        context.refresh();
//        2 读取ioc容器的组件
//          1 直接通过beanid获取    需要强转
        HappyComponent happyComponent = (HappyComponent) context.getBean("happyComponent");

//          2 根据beanid，同时指定bean的类型 Class
        HappyComponent happyComponent1 = context.getBean("happyComponent", HappyComponent.class);

//          3 直接根据类型获取
//              根据bean的类型获取，同一个类型，在ioc容器中只能有一个bean
        HappyComponent happyComponent2 = context.getBean(HappyComponent.class);
        happyComponent2.doWork();
        System.out.println(happyComponent1==happyComponent2);
        System.out.println(happyComponent1==happyComponent);

    }

//测试ioc配置和销毁方法的触发
    @Test
    public void test_04(){
//            1 创建ioc容器 组件对象实例化  init
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("spring-04.xml");
        javaBean2 bean = context.getBean(javaBean2.class);
        javaBean2 bean1 = context.getBean(javaBean2.class);
        System.out.println(bean == bean1);

        context.close();

//        2 正常结束ioc容器
        context.close();
    }

//    读取使用factorybean工厂配置组件对象
    @Test
    public void test_05(){
//            1 创建ioc容器 组件对象实例化  init
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("spring-05.xml");

//        2 读取组件
        JavaBean javaBean = context.getBean("javaBean", JavaBean.class);
        System.out.println(javaBean);

        Object bean = context.getBean("&javaBean");
        System.out.println("bean" + bean);
//        3 正常结束ioc容器
        context.close();
    }
}
