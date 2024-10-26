package com.xxx.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringIocInit extends AbstractAnnotationConfigDispatcherServletInitializer {

//    rootioc容器的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }


//   webioc容器的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

//    dispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
