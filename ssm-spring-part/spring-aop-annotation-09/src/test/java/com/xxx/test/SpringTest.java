package com.xxx.test;

import com.xxx.config.JavaConfig;
import com.xxx.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig (value = JavaConfig.class)
public class SpringTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void test(){
        int add1 = calculator.add(1, 1);
        System.out.println(add1);
    }
}
