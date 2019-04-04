package cn.zhw.d3.dd3.demo1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Day2019.3.1
 * cn.zhw.d3.dd3.demo1.aspect
 * 切面类
 * 在此类中编写通知
 *
 * @author Zhang Huiwen
 * @date 2019-04-04 下午 1:18
 */
public class MyAspect {

    // 前置通知
    public void myBefore(JoinPoint joinPoint) {
        System.out.print("前置通知：模拟权限检查");
        System.out.print("，目标类是：" + joinPoint.getTarget());
        System.out.println("，被植入增强处理的目标为：" + joinPoint.getSignature().getName());
    }

    /*
     * 环绕通知
     * @param proceedingJoinPoint 是 JoinPoint的一个子接口，表示可以执行目标方法
     * @return 返回值必须是object类型
     * 必须接受一个参数并且是ProceedingJoinPoint类型
     * @throws Throwable必须
     */
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始：执行目标方法之前，模拟开启事务");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务");
        return proceed;
    }

    // 最终通知
    public void myAfter() {
        System.out.println("最终通知：模拟方法结束后的释放资源");
    }

    // 异常通知
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("异常通知：出错了" + e.getMessage());
    }

    // 后置通知
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.print("后置通知：模拟记录日志");
        System.out.println("，被植入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

}
