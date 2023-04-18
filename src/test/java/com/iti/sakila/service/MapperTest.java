package com.iti.sakila.service;

import com.iti.sakila.bussiness.dtos.filmdtos.FilmDto;
import com.iti.sakila.bussiness.mapper.filmmapper.FilmMapper;
import com.iti.sakila.bussiness.service.FilmService;
import com.iti.sakila.persistance.entity.Film;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MapperTest {

    @Test
    public void t() {
        FilmService filmService  = new FilmService(Film.class, FilmMapper.INSTANCE);
        List<FilmDto> films = filmService.getAll(1);
        System.out.println(films);
    }


}
