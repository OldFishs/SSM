package com.xxx.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("com.xxx")
@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {

}
