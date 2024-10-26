package com.xxx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

// 控制层配置类
//1 controller  2 全局异常处理器   3 handlerMapping handlerAdapter
//4 静态资源处理    5 jsp视图解析器前后缀    6 json转化器

@EnableWebMvc
@Configuration
@ComponentScan("com.xxx")
public class JavaMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", "jsp");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new xx()).addPathPatterns().excludePathPatterns()
    }
}
