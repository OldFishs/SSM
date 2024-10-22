package com.xxx.statics;

import com.xxx.Calculator;
import com.xxx.CalculatorPureImpl;

public class UserAop {
    public static void main(String[] args) {

//        目标
        Calculator calculator = new CalculatorPureImpl();

        //代理
        Calculator proxy = new StaticProxyCalculator(calculator);

        int add = proxy.add(1, 1);
        System.out.println(add);

    }
}
