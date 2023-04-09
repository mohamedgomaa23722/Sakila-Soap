package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.dtos.FilmDto;
import com.iti.sakila.bussiness.dtos.ListResponse;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.ObjectResponse;
import com.iti.sakila.bussiness.mapper.MapperInterface;
import com.iti.sakila.utils.ResponseGenerator;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.repository.FilmRepository;
import com.iti.sakila.utils.FilterRecord;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmService {
    FilmRepository filmRepository;
    public FilmService() {
        this.filmRepository = new FilmRepository();
    }

    public ListResponse<FilmDto> getFilms(int page) {
        List<FilmDto> films = new ArrayList<>();
        filmRepository.getAll(page).forEach(film -> films.add(MapperInterface.INSTANCE.filmToFilmDto(film)));
        return ResponseGenerator.ListMapper(films, page);
    }

    public ObjectResponse<FilmDto> findFilmById(int film_id) {
        FilmDto film =  MapperInterface.INSTANCE.filmToFilmDto(filmRepository.findById(film_id));
        return ResponseGenerator.ObjectMapper(film);
    }

    public Message insertFilm(FilmDto filmDto) {
        Film film = MapperInterface.INSTANCE.filmDtoToFilm(filmDto);
        film.setLastUpdate(new Timestamp(new Date().getTime()));
        Film insertedFilm = filmRepository.insert(film);
        System.out.println("service : " + film);
        Message message = null;
        if (insertedFilm != null)
            message = new Message(200, "successfully inserted", "");
        else
            message = new Message(500, "error happened into process", "May be you Enter wrong data");
        return message;
    }

    public ListResponse<FilmDto> findFilmWithMultipleFilters(FilterRecord filterRecord) {
        List<FilmDto> films = new ArrayList<>();
        Database.doInTransaction(em -> filmRepository.findFilmWithMultipleFilters(filterRecord, em))
                .forEach(film -> films.add(MapperInterface.INSTANCE.filmToFilmDto(film)));
        return ResponseGenerator.ListMapper(films, filterRecord.page());
    }
}