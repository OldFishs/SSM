package com.xxx.test;

import com.xxx.pojo.Employee;
import com.xxx.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private SqlSession session;

    @BeforeEach
    public void before() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        session = build.openSession(true);
    }

    @Test
    public void test_01() throws IOException {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> query = mapper.query(null, 101.0);
        System.out.println(query);
    }
    @AfterEach
    public void clean() {
        session.close();
    }


}