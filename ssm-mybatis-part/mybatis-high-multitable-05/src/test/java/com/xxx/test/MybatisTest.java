package com.xxx.test;

import com.xxx.mapper.CustomerMapper;
import com.xxx.mapper.OrderMapper;
import com.xxx.pojo.Customer;
import com.xxx.pojo.Order;
import lombok.ToString;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

public class MybatisTest {

    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @Test
    public void testTo1(){
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order order = mapper.queryOrderById(1);
        System.out.println(order.getCustomer());

    }

    @Test
    public void testTo2(){
        CustomerMapper mapper = session.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.queryList();
        for (Customer customer : customers) {
            List<Order> orderlist = customer.getOrderList();
            System.out.println(orderlist);
        }


    }

    @AfterEach
    public void clean() throws IOException {
        session.close();

    }
}
