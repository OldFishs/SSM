package com.xxx.advice;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAdvice {

    @Before("com.xxx.PointCut.MyPointCut.pc()")
    public void begin(){
        System.out.println("begin");
    }

    @AfterReturning("com.xxx.PointCut.MyPointCut.pc()")
    public void commit(){
        System.out.println("commit");
    }

    @AfterThrowing("com.xxx.PointCut.MyPointCut.pc()")
    public void rollback(){
        System.out.println("rollback");
    }
}
