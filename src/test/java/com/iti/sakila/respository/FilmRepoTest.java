package com.iti.sakila.respository;

import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.repository.FilmRepository;
import com.iti.sakila.utils.FilterRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class FilmRepoTest {

    private static FilmRepository filmRepository;

    @BeforeAll
    public static void init() {
        filmRepository = new FilmRepository();
    }

    @Test
    public void get_all_films_for_specific_category() {
        //Arrange
        int category_id = 1;
        int expected = 10;
        //Act
        int result = filmRepository.findByCategoryId(category_id,1).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void get_all_films_by_rating() {
        //Arrange
        BigDecimal rate = new BigDecimal(4);
        int expected = 10;
        //Act
        int result = filmRepository.findByRate(rate,1).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void get_all_films_by_cost() {
        //Arrange
        BigDecimal price = new BigDecimal(29);
        int expected = 10;
        //Act
        int result = filmRepository.findByCost(price,1).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }


    @Test
    public void filter_with_all_in_one(){
        //Arrange
        FilterRecord filterRecord = new FilterRecord(1,1,new BigDecimal("20"), new BigDecimal("3"),"AIRPLANE");
        //Act
        List<Film> films = Database.doInTransaction(em -> filmRepository.findFilmWithMultipleFilters(filterRecord, em));
        System.out.println(films);
        //Assert
        Assertions.assertTrue(films.get(0).getReplacementCost().intValue() >= filterRecord.price().intValue());
    }

}
