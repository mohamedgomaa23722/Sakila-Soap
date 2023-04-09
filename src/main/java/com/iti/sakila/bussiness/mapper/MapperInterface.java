package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.soap.dtos.ActorPostRequest;
import com.iti.sakila.bussiness.dtos.ActorDto;
import com.iti.sakila.bussiness.dtos.FilmDto;
import com.iti.sakila.persistance.entity.Actor;
import com.iti.sakila.persistance.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperInterface {
    MapperInterface INSTANCE = Mappers.getMapper( MapperInterface.class );
    ActorDto actorToActorDto(Actor actor);
    Actor actorDtoToActor(ActorDto actorDto);
    ActorDto actorPostReqToActor(ActorPostRequest actorPostRequest);
    FilmDto filmToFilmDto(Film film);
    Film filmDtoToFilm(FilmDto filmDto);
}
