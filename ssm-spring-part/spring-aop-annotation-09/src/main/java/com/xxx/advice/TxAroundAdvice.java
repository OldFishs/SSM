package com.xxx.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAroundAdvice {

    @Around("com.xxx.PointCut.MyPointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Object proceed = null;
        try {
            System.out.println("start");
            proceed = joinPoint.proceed(args);
            System.out.println("end");
        } catch (Throwable e) {
            System.out.println("exception");
            throw new RuntimeException(e);
        }
        return proceed;
    }
}
