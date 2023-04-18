package com.iti.sakila.service;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmDto;
import com.iti.sakila.bussiness.exceptions.InputDataException;
import com.iti.sakila.bussiness.mapper.filmmapper.FilmMapper;
import com.iti.sakila.bussiness.service.FilmService;
import com.iti.sakila.persistance.entity.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class FilmServiceTest {
    private static FilmService filmService;
    @BeforeAll
    public static void init() {
        filmService = new FilmService(Film.class, FilmMapper.INSTANCE);
    }

    @Test
    public void get_non_Exist_Film_Id() {
        //Arrange
        int id = 5000;
        //Act
        FilmDto filmObjectResponse = filmService.findById(id);
        System.out.println(filmObjectResponse);
        //Assert
        //Assertions.assertEquals(filmObjectResponse.getMessage().getCode(), 404);
    }

    @Test
    public void get_Films_From_Empty_Page() {
        //Arrange
        int page = 1;
        //Act
        List<FilmDto> filmListResponse = filmService.getAll(page);
        System.out.println(filmListResponse);
        //Assert
//        Assertions.assertEquals(filmListResponse.getMessage().getMessage(), "There is no items on this page");
    }

    @Test
    public void insertFilm() throws InputDataException {
        //Arrange
        FilmDto filmDto = new FilmDto();
        filmDto.setTitle("ssss");
        filmDto.setDescription("aaaaaa");
        filmDto.setReleaseYear(2010);
        filmDto.setRentalRate(new BigDecimal("4.0"));
        filmDto.setReplacementCost(new BigDecimal("55.0"));
        filmDto.setLength((short) 55);
        filmDto.setRentalDuration((byte) 6);
        filmDto.setSpecialFeatures("Trailers,Deleted Scenes");
        filmDto.setLanguageName("English");

        //Act
        Message message = filmService.insertFilm(filmDto);
        System.out.println(message);
        //Assert
        Assertions.assertEquals(message.getCode(), 200);
    }

}

