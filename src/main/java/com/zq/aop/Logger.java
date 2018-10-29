package com.zq.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author zq
 * @create 2018-10-25 21:05
 */
public class Logger {
    public void doAround(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println(111);
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
