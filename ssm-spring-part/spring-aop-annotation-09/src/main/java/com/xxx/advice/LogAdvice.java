package com.xxx.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;






@Component
@Aspect
public class LogAdvice {




    @Before("com.xxx.PointCut.MyPointCut.pc()")
    public void start(){
        System.out.println("方法开始了");
    }

    @After("com.xxx.PointCut.MyPointCut.pc()")
    public void end(){
        System.out.println("方法结束了");
    }

    @AfterThrowing("com.xxx.PointCut.MyPointCut.pc()")
    public void exception(){
        System.out.println("方法报错了");
    }



}
