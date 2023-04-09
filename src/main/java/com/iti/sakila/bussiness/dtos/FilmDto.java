package com.iti.sakila.bussiness.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class FilmDto {
    private Short filmId;
    private LanguageDto languageByLanguageId;
    private String title;
    private String description;
    private Date releaseYear;
    private BigDecimal rentalRate;
    private Short length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;

    @Override
    public String toString() {
        return "FilmDto{" +
                "filmId=" + filmId +
                ", languageByLanguageId=" + languageByLanguageId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating='" + rating + '\'' +
                ", specialFeatures='" + specialFeatures + '\'' +
                '}' + "\n";
    }
}