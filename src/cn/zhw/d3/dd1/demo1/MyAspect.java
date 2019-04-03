package cn.zhw.d3.dd1.demo1;

import lombok.Data;
import lombok.extern.java.Log;

/**
 * Day2019.3.1
 * cn.zhw.d3.dd1.demo1
 * 切面类：可以存在多个通知Advice（即增强方法）
 *
 * @author Zhang Huiwen
 * @date 2019-04-02 下午 4:17
 */
@Data
@Log
public class MyAspect {
    // aspect 切面

    public void check_permissions() {
        log.info("****权限检查****");
    }

    public void check_permissions2() {
        log.info("****  2级代理  权限检查   ****");
    }

    public void log() {
        log.info("****日志****");
    }

    public void log2() {
        log.info("****  2级代理  日志   ****");
    }

}
