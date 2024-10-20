package com.xxx.config;


//java配置类 代替xml配置文件
//  1 包扫描注解配置
//  2 引用外部pei。。。。
//  3

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@ComponentScan({"com.xxx.ioc_01"})
@PropertySource("classpath:jdbc.properties")
@Configuration
public class JavaConfiguration {

    @Value("${xxx.url}")
    private String url;
    @Value("${xxx.username}")
    private String username;
    @Value("${xxx.password}")
    private String password;
    @Value("${xxx.driver}")
    private String driverClassName;


    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "wofule")
    public DruidDataSource DataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

//      不推荐
//    @Bean
//    public JdbcTemplate JdbcTemplate() {
//        JdbcTemplate jt = new JdbcTemplate();
//        jt.setDataSource(DataSource());
//        return jt;
//    }

    @Bean
    public JdbcTemplate JdbcTemplate(DataSource dataSource) {
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);
        return jt;
    }
}
