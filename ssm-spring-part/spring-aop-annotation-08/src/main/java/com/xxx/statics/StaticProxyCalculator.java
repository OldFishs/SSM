package com.xxx.statics;

import com.xxx.Calculator;

//代理类
public class StaticProxyCalculator implements Calculator {

    private Calculator calculator;

    public StaticProxyCalculator(Calculator target) {
        this.calculator = target;
    }
    @Override
    public int add(int i, int j) {

//        非核心业务
        System.out.println("i = " + i + ", j = " + j);

        int add = calculator.add(i, j);

        System.out.println("add = " + add);

        return add;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
