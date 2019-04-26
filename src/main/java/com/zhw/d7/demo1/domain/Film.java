package com.zhw.d7.demo1.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("film")
public class Film {

    private Integer filmId;
    private String title;
    private String description;
    private String releaseYear;
    private Integer languageId;
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private String rating;
    private String specialFeatures;

    public Film() {
    }

    public Film(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Film(Integer filmId, String title, String description) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
    }

    public Film(Integer filmId, String title, String description, String releaseYear, Integer languageId, Integer originalLanguageId, Integer rentalDuration, Double rentalRate, Integer length, Double replacementCost, String rating, String specialFeatures) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.originalLanguageId = originalLanguageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
    }
}