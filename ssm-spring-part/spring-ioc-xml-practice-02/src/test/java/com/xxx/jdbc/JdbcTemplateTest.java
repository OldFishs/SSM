package com.xxx.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.xxx.controller.StudentController;
import com.xxx.pojo.Student;
import org.junit.Test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.beans.BeanProperty;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest {

    public void testForJava(){

//        JdbcTemplate 简化数据库的crud   不提供连接池
//        DruidDataSource 负责链接的创建和数据库驱动的注册

//        0 创建一个连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql:///studb");//url地址
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");//jdbc驱动
        dataSource.setUsername("root");//账号
        dataSource.setPassword("123456");//密码
//        1 实例化对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);
//        2 调用方法
//        jdbcTemplate.update()  DDL DML DCL ,,,非查询语句
//        jdbcTemplate.queryForList("select * from user");  DQL 查询单个对象
//        jdbcTemplate.query();  DQL  查询集合
    }

    @Test
    public void testForIoc(){

//        1 创建ioc容器
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");
//        2 获取jdbctemplate组件
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
//
////        3 数据库的crud动作
//
//        String sql = "insert into students (id,name,gender,age,class) value (?,?,?,?,?)";
//
////        以下函数参数：
////        参数1：sql可以？?只能替代值不能代替关键字与容器名
////        参数2：Object。。。param 传入占位符的值
////        返回值：int影响行数
//
//        int update = jdbcTemplate.update(sql, 10,"rick", "male", 18, "32");
//        System.out.println(update);

//        查询单条语句
//        String sql1 = "select * from students where id = ?";
//
////        参数1：sql语句 可以？
////        参数2：RowMapper 列名和属性名的映射器接口
////        参数3:Object...param
////        返回值 rowmapper指定的对象
//        Student student1 = jdbcTemplate.queryForObject(sql1,(rs,rowNum)->{
////                rs结果集
////                rowNum 行数
////                rs结果集中获取列的值 赋值给实体类对象即可
//                Student student = new Student();
//                student.setId(rs.getInt("id"));
//                student.setName(rs.getString("name"));
//                student.setAge(rs.getInt("age"));
//                student.setGender(rs.getString("gender"));
//                student.setClasses(rs.getString("class"));
//                return student;
//        },10);
//
//        System.out.println(student1);


        String sql = "select id,name,gender,age,class,age from students";

        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println(studentList);

    }


    @Test
    public void testQueryAll(){
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-02.xml");
        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.findAll();
        applicationContext.close();

    }
}
