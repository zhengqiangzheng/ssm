package com.zq.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * @author zq
 @create 2018-10-25 19:49
 */
//@Component
//@Aspect
public class UserAspect {
    @Pointcut(value ="execution(* com.zq.service.*.*(..))" )
    public void pointCut() { }

    @Before(value = "pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();//拦截的方法名
        Object[] args = joinPoint.getArgs();
        String string = Arrays.toString(args);
        System.out.println(name + "," + string);


    }

    @After(value = "pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();//拦截的方法名
        Object[] args = joinPoint.getArgs();
        String string = Arrays.toString(args);
        System.out.println(name + "," + string);
    }

//    /**
//     * 环绕通知
//     * @param proceedingJoinPoint
//     */
//    @Around(value = "pointCut()")
//    public void doaround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        proceedingJoinPoint.proceed();//必须放行不然方法就卡死在这里了,
//                // 因为他全程监控方法的执行,所以处理完逻辑后一定要记得放行
//
//
//
//    }

            }
