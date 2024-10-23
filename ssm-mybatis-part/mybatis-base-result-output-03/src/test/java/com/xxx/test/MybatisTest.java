package com.xxx.test;

import com.xxx.mapper.EmployeeMapper;
import com.xxx.mapper.TeacherMapper;
import com.xxx.pojo.Employee;
import com.xxx.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class MybatisTest {

    @Test
    public void test_01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = build.openSession();

        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();

        employee.setEmpSalary(888.0);
        employee.setEmpName("ergouzi");
        int row = mapper.insertEmp(employee);
        System.out.println(row);

        session.commit();
        session.close();

    }

    @Test
    public void test_02() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = build.openSession(true);

        TeacherMapper mapper = session.getMapper(TeacherMapper.class);

        Teacher teacher = new Teacher();
        teacher.settName("dfasdfa");

        String id = UUID.randomUUID().toString().replaceAll("-", "");
        teacher.settId(id);

        int row = mapper.insertTeacher(teacher);
        System.out.println(row);

        session.commit();
        session.close();

    }
}
