package com.iti.sakila.service;

import com.iti.sakila.bussiness.dtos.FilmDto;
import com.iti.sakila.bussiness.mapper.MapperInterface;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.entity.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapperTest {

    @Test
    public void map_fom_Film_To_FilmDto() {
        //Arrange
        Film film = Database.doInTransaction(em -> em.find(Film.class, 3));
        //Act
        FilmDto filmDto = MapperInterface.INSTANCE.filmToFilmDto(film);
        System.out.println(filmDto);
        //Assert
        Assertions.assertNotNull(filmDto.getDescription());
    }

    @Test
    public void map_fom_FilmDto_To_Film() {
        //Arrange
        Film film = Database.doInTransaction(em -> em.find(Film.class, 3));
        FilmDto filmDto = MapperInterface.INSTANCE.filmToFilmDto(film);
        //Act
        Film mappedFilm = MapperInterface.INSTANCE.filmDtoToFilm(filmDto);
        System.out.println(mappedFilm);
        //Assert
        Assertions.assertNotNull(filmDto.getDescription());
    }
}
