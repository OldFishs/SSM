package com.xxx.config;


//持久层配置类：连接池，sqlSessionFactory,Mapper代理对象
//mybatis属性都在代码中配置

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@ComponentScan
public class MapperJavaConfig {

    public SqlSessionFactoryBean SqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);
//        指定mybatis配置文件的功能
        Configuration configuration = new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(Slf4jImpl.class);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
//        储存setting的配置文件
        sqlSessionFactoryBean.setConfiguration(configuration);
//        别名设置
        sqlSessionFactoryBean.setTypeAliasesPackage("com.xxx.pojo");

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.addPlugins();

        return sqlSessionFactoryBean;
    }

//    mapper代理对象加入到ioc
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("com.xxx.mapper");
        return mapperScannerConfigurer;
    }

}
