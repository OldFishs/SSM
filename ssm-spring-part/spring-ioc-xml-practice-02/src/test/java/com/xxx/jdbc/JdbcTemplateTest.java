package com.xxx.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {

    public void testForJava(){

//        JdbcTemplate 简化数据库的crud   不提供连接池
//        DruidDataSource 负责链接的创建和数据库驱动的注册

//        0 创建一个连接池对象
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql:///studb");//url地址
        ds.setDriverClassName("com.mysql.jdbc.Driver");//jdbc驱动
        ds.setUsername("root");//账号
        ds.setPassword("123456");//密码
//        1 实例化对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(ds);
//        2 调用方法
//        jdbcTemplate.update()  DDL DML DCL ,,,非查询语句
//        jdbcTemplate.queryForList("select * from user");  DQL 查询单个对象
//        jdbcTemplate.query();  DQL  查询集合
    }

    public 
}
