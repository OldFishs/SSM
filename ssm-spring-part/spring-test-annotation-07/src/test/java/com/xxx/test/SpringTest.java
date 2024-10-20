package com.xxx.test;

import com.xxx.components.A;
import com.xxx.config.JavaConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;


@SpringJUnitWebConfig(value = JavaConfig.class)
public class SpringTest {

    @Autowired
    private A a;
    @Test
    public void test(){
        a.AA();
    }
}
