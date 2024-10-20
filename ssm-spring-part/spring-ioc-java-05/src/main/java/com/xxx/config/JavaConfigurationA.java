package com.xxx.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JavaConfigurationB.class})
public class JavaConfigurationA {
}
