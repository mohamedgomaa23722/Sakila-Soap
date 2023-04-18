package com.iti.sakila.api.soap.webservice;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmDto;
import com.iti.sakila.bussiness.exceptions.InputDataException;
import com.iti.sakila.bussiness.mapper.filmmapper.FilmMapper;
import com.iti.sakila.bussiness.service.FilmService;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.utils.FilterRecord;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService(name = "films")
public class FilmWebService {
    private final FilmService filmService;

    public FilmWebService() {
        filmService = new FilmService(Film.class, FilmMapper.INSTANCE);
    }

    @WebMethod
    public List<FilmDto> getFilms(@WebParam(name = "page") int page) {
        return filmService.getAll(page);
    }

    @WebMethod
    public FilmDto findFilmById(@WebParam(name = "id") int id) {
        return filmService.findById(id);
    }

    @WebMethod
    public Message insertFilm(@WebParam(name = "film") FilmDto filmDto) {
        return filmService.insertFilm(filmDto);
    }

    @WebMethod
    public Message updateFilm(@WebParam(name = "film") FilmDto filmDto){
        return filmService.update(filmDto, filmDto.getFilmId());
    }

    @WebMethod
    public Message deleteFilm(@WebParam(name = "id") int id){
        return filmService.delete(id);
    }

    @WebMethod
    public List<FilmDto> filterFilms(@WebParam(name = "filterRecord") FilterRecord filterRecord){
        System.out.println("******filter film ******");
        return filmService.findFilmWithMultipleFilters(filterRecord);
    }
}
