package com.zq.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zq
 * @create 2018-10-25 22:36
 */
@Aspect
@Component
public class Uaspect {
    @Pointcut(value = "execution(* com.zq.service.*.*(..))")
    public void pointCut() {

    }
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("nihao");

    }

}
