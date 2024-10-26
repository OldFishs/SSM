package com.xxx.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


//业务层配置类
//1 service    2 开启aop注解的支持 aspect：@Before @After @afterReturning @Around @Aspect @Order
//3 tx声明式事物管理：1开启对应事物管理器 2开启事物注解支持


@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ServiceJavaConfig {

    @Bean
    public TransactionManager transactional(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
