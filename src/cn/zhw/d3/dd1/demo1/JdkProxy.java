package cn.zhw.d3.dd1.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Day2019.3.1
 * cn.zhw.d3.dd1.demo1
 * JDK代理
 * @author Zhang Huiwen
 * @date 2019-04-02 下午 4:43
 */
public class JdkProxy implements InvocationHandler {
    // invocation 调用
    // handler 处理程序
    // Invocation Handler 调用处理程序
    // 目标类接口
    private Userdao userdao;

    // 代理方法
    public Object createProxy(Userdao userdao) {
        this.userdao = userdao;
        // 类加载器
        ClassLoader loader = JdkProxy.class.getClassLoader();
        // 被代理对象实现的所有接口
        Class[] classes = this.userdao.getClass().getInterfaces();
        // 使用代理类，进行增强，返回的是代理后的对象
        return Proxy.newProxyInstance(loader, classes, this);
    }

    /**
     * 所有动态代理类的方法调用，都会交由invoke()方法去处理
     * @param o
     * @param method 将要被执行的方法信息（反射）
     * @param objects 执行方法时需要的参数
     * @return 返回被代理后的对象
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        // 切面
        MyAspect myAspect = new MyAspect();
        // 前增强
        myAspect.check_permissions();
        // 在目标类上调用方法，并传入参数
        Object invoke = method.invoke(this.userdao, objects);
        // 后增强
        myAspect.log();
        return invoke;
    }
}
