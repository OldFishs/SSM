package com.xxx.test;

import com.xxx.mapper.UserMapper;
import com.xxx.pojo.User;
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

    @AfterEach
    public void clean(){
        session.commit();
        session.close();
    }

    @Test
    public void testInsert() throws IOException {
        User user = new User();
        user.setUsername("1");
        user.setPassword("1");
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.insert(user);
        System.out.println(user);

    }

    @Test
    public void testDelete() throws IOException {
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.delete(1);
        User user = mapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testSelect() throws IOException {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdate() throws IOException {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        user.setId(1);
        user.setUsername("1");
        user.setPassword("1");
        int update = mapper.update(user);
        System.out.println(update);
    }

    @Test
    public void testSelectAll() throws IOException {
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
    }
}
