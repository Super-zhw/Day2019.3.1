package com.zhw;

import com.zhw.d3.dd1.demo1.JdkProxy;
import com.zhw.d3.dd1.demo1.UserDaoImpl;
import com.zhw.d3.dd1.demo1.Userdao;
import com.zhw.d3.dd1.demo2.CglibProxy;
import com.zhw.d3.dd1.demo2.CglibProxySecondary;
import com.zhw.d3.dd1.demo2.UserDao;
import com.zhw.d3.dd3.demo2.StuDao;
import com.zhw.d3.dd3.demo2.SupervisionDao;
import com.zhw.d3.dd3.demo3.dao.StudyDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Day2019.3.1
 * com.zhw.test
 *
 * @author Zhang Huiwen
 * @date 2019-04-02 下午 4:52
 */
public class D3 {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans3.xml");

    @Test
    public void test_JDKPorxy() {
        /*
         * 测试 JDKPorxy 动态代理
         */
        JdkProxy jdkProxy = new JdkProxy();
        Userdao userDao = new UserDaoImpl();
        Userdao dao = (Userdao) jdkProxy.createProxy(userDao);
        System.out.println("\n**************----- 切面增强 ------************");
        dao.addUser();
        dao.deleteUser();
        dao.deleteUser();
        System.out.println("打印对象：" + dao.toString());
        System.out.println("是否是同一个对象：" + dao.equals(userDao));
        /*
         * -----1-----
         * 从上面的输出我们发现不是目标类接口的方法，也会调用切面方法
         * toString 、equals 都不是 接口UserDao的抽象方法
         * 也就是说被动态代理后的对象都会调用切面方法
         */
        System.out.println("\n**************----- 没有切面增强 ------************");
        userDao.addUser();
        userDao.deleteUser();
        /*
         * 使用动态代理有一定的局限性
         * 使用动态代理必须实现一个或多个接口。
         * 如果要对没有实现接口的类进行代理，那么可以使用CGLIB代理
         */
    }

    @Test
    public void test_CGLIB() {
        /*
         * 测试 CGLIB 代理
         */
        // 创建目标对象
        UserDao userDao = new UserDao();
        // 创建代理对象
        CglibProxy cglibProxy = new CglibProxy();
        // 获取增强后的对象
        UserDao dao = (UserDao) cglibProxy.createProxy(userDao);
        dao.addUser();
        dao.delUser();
        System.out.println(dao.equals(userDao));
        System.out.println(dao.toString());
        userDao.addUser();
        userDao.delUser();
        /*
         * 同上-----1-----
         */
    }

    @Test
    public void test_ProxySecondary_Proxy() {
        /*
         * 代理嵌套代理
         * 切面嵌套切面
         */
        CglibProxySecondary cglibProxySecondary = new CglibProxySecondary();
        CglibProxy cglibProxy = new CglibProxy();
        CglibProxy cp = (CglibProxy) cglibProxySecondary.createProxy(cglibProxy);
        UserDao userDao = new UserDao();
        UserDao dao = (UserDao) cp.createProxy(userDao); // 执行 createProxy 方法 所以 二级代理执行
        //  执行 addUser ==> 一级代理 intercept() ==> 二级代理 intercept()
        //  最后执行addUsere方法 <==  一级代理确认  <== 二级代理确认
        dao.addUser();
        // 执行 delUser -> 一级代理 intercept() -> 二级代理 intercept()
        // 最后执行delUsr 方法  <==   一级代理确认  <== 二级代理确认
        dao.delUser();
        /*
         * 切面扩展 ====>> 切面嵌套切面
         */
    }

    @Test
    public void test_ProxyAspect() {
        /*
         * 基于代理的AOP切面
         */
        Userdao userdao = applicationContext.getBean("proxyFactoryBean", Userdao.class);
        userdao.addUser();
        userdao.deleteUser();
    }

    @Test
    public void test_ProxyAspect_Secondary() {
        /*
         * 基于代理的 二级代理 AOP切面
         * 从第二级代理执行，到第一级代理，再到最后被执行的方法
         */
        Userdao userdao = applicationContext.getBean("proxyFactoryBean2", Userdao.class);
//        System.out.println(applicationContext.getBean("proxyFactoryBean2") instanceof Userdao);  // 用来确定类型，找错误
        userdao.addUser();
        userdao.deleteUser();
    }

    @Test
    public void test_AspectJ() {
        /*
         * 基于XML式的AspectJ
         *
         * 基本执行顺序：
         * 前置通知
         * 环绕开始
         * 目标方法
         * 最终通知
         * 环绕结束
         * 后置通知
         *
         * 异常执行顺序：
         * 前置通知
         * 环绕开始
         * 目标方法
         * 最终通知
         * 异常通知
         * 异常信息
         */
        com.zhw.d3.dd3.demo1.dao.UserDao dao = applicationContext.getBean("userDaoImple", com.zhw.d3.dd3.demo1.dao.UserDao.class);
        System.out.println("************************************************************");
        dao.addUser();
        System.out.println("************************************************************");
        dao.deleteUser();
        System.out.println("************************************************************");
//        dao.byZero(); // 异常通知
    }

    @Test
    public void test_declare_parents() {
        /*
         *  declare_parents 增强方式
         */
        StuDao stuDao = (StuDao) applicationContext.getBean("stuDao");
        stuDao.study();
        ((SupervisionDao) stuDao).supervision();
    }

    @Test
    public void test_AspectJ_Annotation() {
        /*
         * AspectJ 基于注解形式声明
         *
         * 执行顺序如下：
         * 前置环绕
         * 前置通知
         * 目标方法
         * 后置环绕
         * 最终通知
         * 后置通知
         *
         * 异常执行顺序：
         * 前置环绕
         * 前置通知
         * 目标方法
         * 最终通知
         * 异常通知
         *
         */
        StudyDao studyDao = applicationContext.getBean("studyDao", StudyDao.class);
        studyDao.study();
        System.out.println();
        studyDao.writeHomework();
        System.out.println();
//        studyDao.byZero();
    }

}
