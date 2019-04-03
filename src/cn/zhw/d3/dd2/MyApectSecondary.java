package cn.zhw.d3.dd2;

import lombok.extern.java.Log;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Day2019.3.1
 * cn.zhw.d3.dd2
 *
 * @author Zhang Huiwen
 * @date 2019-04-02 下午 9:19
 */
@Log
public class MyApectSecondary implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        check();
        Object proceed = methodInvocation.proceed();
        log();
        return proceed;
    }

    private void check(){
        log.info("*********二级 切面 检查权限  ***********");
    }

    private void log(){
        log.info("*********二级 切面 打印日志  ***********");
    }
}
