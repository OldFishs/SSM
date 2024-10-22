package com.xxx.PointCut;


import org.aspectj.lang.annotation.Pointcut;

//存储切点的类
public class MyPointCut {
    @Pointcut("execution(* com.xxx.service.impl.*.*(..))")
    public void pc(){
    }

    @Pointcut("execution(* com..impl.*.*(..))")
    public void mypc(){
    }
}
