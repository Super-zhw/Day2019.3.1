package com.zhw.d3.dd1.demo2;

import com.zhw.d3.dd1.demo1.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Day2019.3.1
 * com.zhw.d3.dd1.demo2
 * CGLIB 代理
 *
 * @author Zhang Huiwen
 * @date 2019-04-02 下午 6:10
 */
public class CglibProxy implements MethodInterceptor {
    // 代理方法
    public Object createProxy(Object target) {
        // Enhancer 增强器
        // 创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        // 确定需要增强的类，设置其父类
        enhancer.setSuperclass(target.getClass());
        // 添加回调函数
        enhancer.setCallback(this);
        // 返回创建的代理类
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 切面方法
        MyAspect myAspect = new MyAspect();
        myAspect.check_permissions();
        // 目标方法执行
        Object invoke = methodProxy.invokeSuper(proxy, objects);
        myAspect.log();
        return invoke;
    }

}
