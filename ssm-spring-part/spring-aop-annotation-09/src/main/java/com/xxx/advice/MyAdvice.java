package com.xxx.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Before("com.xxx.PointCut.MyPointCut.mypc()")
    public void start(JoinPoint joinPoint){
//        获取方法所属类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
//        获取方法名称
        String name = joinPoint.getSignature().getName();
//        获取参数列表
        Object[] args = joinPoint.getArgs();
    }

    @AfterReturning(value = "com.xxx.PointCut.MyPointCut.mypc()",returning = "result")
    public void afterreturning(JoinPoint joinPoint,Object result){

    }

    @After("com.xxx.PointCut.MyPointCut.mypc()")
    public void after(JoinPoint joinPoint){

    }

    @AfterThrowing(value = "com.xxx.PointCut.MyPointCut.mypc()",throwing = " ")
    public void afterthrowing(JoinPoint joinPoint,Throwable throwable){

    }


}
