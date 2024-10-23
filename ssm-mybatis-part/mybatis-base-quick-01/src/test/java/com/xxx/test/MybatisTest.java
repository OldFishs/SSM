package com.xxx.test;

import com.xxx.mapper.EmployeeMapper;
import com.xxx.pojo.Employee;
import com.xxx.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void test_01() throws IOException {
//        1 读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");

//        2 创建sqlSessionFactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(ips);

//        3 根据sqlSessionFactory创建sqlsession（每次业务创一个 用完释放
        SqlSession sqlSession = build.openSession();

//        4 获取接口代理对象 调用代理对象的方法 就会查找mapper接口方法
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println(employee);

//        5 提交事物（非DQl 和释放资源
        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void test_02() throws IOException {
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(ips);
        SqlSession sqlSession = build.openSession();
        Student student = sqlSession.selectOne("kkk", 1);
        System.out.println(student);
    }
}
