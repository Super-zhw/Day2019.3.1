package com.zhw.d4.dd1.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Day2019.3.1
 * com.zhw.d4.dd1
 *
 * @author Zhang Huiwen
 * @date 2019-04-07 下午 8:58
 */
@Data
@Scope("prototype")
@Component("account")
public class Account {
    private Integer id;
    private String username;
    private Double blance;
}
