package cn.zhw.d3.dd3.demo3.dao.impl;

import cn.zhw.d3.dd3.demo2.StuDao;
import cn.zhw.d3.dd3.demo3.dao.StudyDao;
import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * Day2019.3.1
 * cn.zhw.d3.dd3.demo3.dao.impl
 *
 * @author Zhang Huiwen
 * @date 2019-04-05 下午 9:18
 */
@Repository("studyDao")
@Data
public class StudyImpl implements StudyDao {
    @Override
    public void study() {
        System.out.println("**************学习**************");
    }

    @Override
    public void writeHomework() {
        System.out.println("**************写作**************");
    }

    @Override
    public void byZero() {
        System.out.println(1/0);
    }
}
