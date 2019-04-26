package com.zhw.d2.dd1;

import lombok.extern.java.Log;

/**
 * Day2019.3.1
 * com.zhw.d2.dd1
 *
 * @author Zhang Huiwen
 * @date 2019-03-01 下午 3:21
 */
@Log
public class Bean2 {
    private Bean1 bean1;

    //    依赖注入   构造器方式
    public Bean2(Bean1 bean1) {
        log.info("Bean2 构造器");
        this.bean1 = bean1;
    }

    public void say() {
        this.bean1.say();
        System.out.println("this is bean2");
    }
}
