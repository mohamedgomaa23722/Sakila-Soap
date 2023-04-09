package com.iti.sakila.service;

import com.iti.sakila.bussiness.dtos.FilmDto;
import com.iti.sakila.bussiness.dtos.ListResponse;
import com.iti.sakila.bussiness.dtos.ObjectResponse;
import com.iti.sakila.bussiness.service.FilmService;
import com.iti.sakila.persistance.entity.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FilmServiceTest {
    private static FilmService filmService;
    @BeforeAll
    public static void init() {
        filmService = new FilmService();
    }

    @Test
    public void get_non_Exist_Film_Id() {
        //Arrange
        int id = 5000;
        //Act
        ObjectResponse<FilmDto> filmObjectResponse = filmService.findFilmById(id);
        System.out.println(filmObjectResponse);
        //Assert
        Assertions.assertEquals(filmObjectResponse.getMessage().getCode(), 404);
    }

    @Test
    public void get_Films_From_Empty_Page() {
        //Arrange
        int page = 1;
        //Act
        ListResponse<FilmDto> filmListResponse = filmService.getFilms(page);
        System.out.println(filmListResponse);
        //Assert
//        Assertions.assertEquals(filmListResponse.getMessage().getMessage(), "There is no items on this page");
    }
}
