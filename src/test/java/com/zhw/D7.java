package com.zhw;

import com.zhw.d7.demo1.domain.Film;
import com.zhw.d7.demo1.mapper.FilmMapper;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Day2019.3.1
 * PACKAGE_NAME
 *
 * @author Zhang Huiwen
 * @time 2019-04-18 上午 9:29
 */
public class D7 {

    private static ApplicationContext ac = new ClassPathXmlApplicationContext("Beans7.xml");
    private static SqlSessionTemplate sst = (SqlSessionTemplate) ac.getBean("sessionTemplate");


    @Test
    public void test_getSessionTemplate() {
        System.out.println(sst);
    }

    @Test
    public void test_getCnn() {
        System.out.println(sst.getConnection());
    }

    @Test
    public void test_insertFilm1() {
        // mysql
        Film film = new Film("速度与激情7", "好看！！！");
        FilmMapper mapper = sst.getMapper(FilmMapper.class);
        Integer row = mapper.insertFilm1(film);
        if (row >= 1) {
            System.out.println(film.getFilmId());
        } else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void test_insertFilm2() {
        // oracle
        Film film = new Film("速度与激情8", "更好看！！！");
        FilmMapper mapper = sst.getMapper(FilmMapper.class);
        Integer row = mapper.insertFilm2(film);
        if (row >= 1) {
            System.out.println(film.getFilmId());
        } else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void test_findAll() {
        List<Film> list = sst.selectList("com.zhw.d7.demo1.mapper.FilmMapper.findAll");
        for (Film film : list) {
            System.out.println(film);
        }
    }

    //findByfilmId(Integer filmId)
    @Test
    public void test_findByfilmId() {
        List<Film> list = sst.selectList("com.zhw.d7.demo1.mapper.FilmMapper.findByfilmId", 1);
        for (Film film : list) {
            System.out.println(film);
        }
    }

    //findBytitle(String title)
    @Test
    public void test_findByTitle() {
        List<Film> list = sst.selectList("com.zhw.d7.demo1.mapper.FilmMapper.findBytitle", "ACADEMY DINOSAUR");
        for (Film film : list) {
            System.out.println(film);
        }

    }

    //findBydescription(String description)
    @Test
    public void test_findByDescription() {
        List<Film> list = sst.selectList("com.zhw.d7.demo1.mapper.FilmMapper.findBydescription", "ACADEMY DINOSAUR");
        for (Film film : list) {
            System.out.println(film);
        }
    }

    //findByreleaseYear(String releaseYear)
    @Test
    public void test_findByReleaseYear() {
        List<Film> list = sst.selectList("com.zhw.d7.demo1.mapper.FilmMapper.findByreleaseYear", "2006");
        for (Film film : list) {
            System.out.println(film);
        }
    }

    //findBylanguageId(Integer languageId)
    @Test
    public void test_findByLanguageId() {

    }

    //findByoriginalLanguageId(Integer originalLanguageId)
    @Test
    public void test_findByOriginalLanguageId() {

    }

    //findByrentalDuration(Integer rentalDuration)
    @Test
    public void test_findByRentalDuration() {

    }

    //findByrentalRate(Double rentalRate)
    @Test
    public void test_findByRentalRate() {

    }

    //findBylength(Integer length)
    @Test
    public void test_findByLength() {

    }

    //findByreplacementCost(Double replacementCost)
    @Test
    public void test_findByReplacementCost() {

    }

    //findByrating(String rating)
    @Test
    public void test_findByRating() {

    }

    //findByspecialFeatures(String specialFeatures)
    @Test
    public void test_findBySpecialFeatures() {

    }


    @Test
    public void test_isOk() {
        System.out.println("ok");
    }
}
