package com.zhw.d7.demo1.mapper;

import com.zhw.d7.demo1.domain.Film;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Day2019.3.1
 * com.zhw.d7.demo1.mapper
 *
 * @author Zhang Huiwen
 * @time 2019-04-18 上午 8:59
 */

@Repository("filmMapper")
public interface FilmMapper {

    List<Film> findAll();

    List<Film> findByfilmId(Integer filmId);

    List<Film> findBytitle(String title);

    List<Film> findBydescription(String description);

    List<Film> findByreleaseYear(String releaseYear);

    List<Film> findBylanguageId(Integer languageId);

    List<Film> findByoriginalLanguageId(Integer originalLanguageId);

    List<Film> findByrentalDuration(Integer rentalDuration);

    List<Film> findByrentalRate(Double rentalRate);

    List<Film> findBylength(Integer length);

    List<Film> findByreplacementCost(Double replacementCost);

    List<Film> findByrating(String rating);

    List<Film> findByspecialFeatures(String specialFeatures);

    Integer insertFilm1(Film film); // mysql

    Integer insertFilm2(Film film); // oracle

}
