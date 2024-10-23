package com.xxx;

import com.xxx.mapper.EmployeeMapper;
import com.xxx.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class testMyBatisTest    {

    @Test
    public void tset_01() throws IOException {
//        1 读取外部配置资源
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

//        2 创建sqlSessionFactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

//        3 获取SqlSession对象
        SqlSession sqlSession = build.openSession();

//        4 获取代理mapper对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = mapper.queryById(1);

        System.out.println(employee);
//        5 管理资源或者提交事物
        sqlSession.close();
    }
}
