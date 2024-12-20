package com.xxx.ioc_02;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class JavaBean {

    @PostConstruct
    public void init(){
        System.out.println("JavaBean init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JavaBean destroy");
    }
}
