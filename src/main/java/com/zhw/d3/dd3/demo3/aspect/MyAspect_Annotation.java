package com.zhw.d3.dd3.demo3.aspect;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Day2019.3.1
 * com.zhw.d3.dd3.demo3
 * 切面类，在此类中编写通知
 *
 * @author Zhang Huiwen
 * @date 2019-04-05 下午 9:16
 */
@Aspect
@Component
public class MyAspect_Annotation {
    // 定义切入表达式
    @Pointcut("execution( * com.zhw.d3.dd3.demo3.dao.*.*(..))")
    // 使用一个返回值为void、方法体为空的方法来命名切入点
    private void myPointCut() {
    }

    // 前置通知
    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置通知：模拟权限检查");
        System.out.println("被织入的目标类是" + joinPoint.getTarget() + "，被织入的目标方法是" + joinPoint.getSignature().getName());
    }

    // 后置通知
    @AfterReturning("myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.println("后置通知：模拟日志记录");
        System.out.println("被织入的目标方法为" + joinPoint.getSignature().getName());
    }

    // 环绕通知
    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("-----------前置环绕-----------");
        Object proceed = proceedingJoinPoint.proceed(); // 异常、最终通知会在此处插入
        System.out.println("---------后置环绕---------"); // 后置通知接此处
        return proceed;
    }

    // 异常通知
    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("出错了" + joinPoint.getSignature().getName() + "," + e.getMessage());
    }

    // 最终通知
    @After("myPointCut()")
    public void myAfter() {
        System.out.println(">>>>>>>>>>>>>>最终通知<<<<<<<<<<<<<");
    }

}
