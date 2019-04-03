package cn.zhw.d3.dd2;

import lombok.extern.java.Log;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Day2019.3.1
 * cn.zhw.d3.dd2
 * 切面类
 * @author Zhang Huiwen
 * @date 2019-04-02 下午 8:25
 */
@Log
public class MyApect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        chech_Permissions();
        // 执行目标方法
        Object proceed = methodInvocation.proceed();
        log();
        return proceed;
    }

    private void chech_Permissions() {
        log.info("-------------权限检查------------");
    }

    private void log() {
        log.info("------------日志检查-------------");
    }

}
