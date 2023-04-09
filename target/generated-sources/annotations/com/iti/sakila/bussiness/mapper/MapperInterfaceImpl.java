package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.soap.dtos.ActorPostRequest;
import com.iti.sakila.bussiness.dtos.ActorDto;
import com.iti.sakila.bussiness.dtos.FilmDto;
import com.iti.sakila.bussiness.dtos.LanguageDto;
import com.iti.sakila.persistance.entity.Actor;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.entity.Language;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-09T21:19:40+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class MapperInterfaceImpl implements MapperInterface {

    @Override
    public ActorDto actorToActorDto(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        ActorDto actorDto = new ActorDto();

        actorDto.setActorId( actor.getActorId() );
        actorDto.setFirstName( actor.getFirstName() );
        actorDto.setLastName( actor.getLastName() );

        return actorDto;
    }

    @Override
    public Actor actorDtoToActor(ActorDto actorDto) {
        if ( actorDto == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setActorId( actorDto.getActorId() );
        actor.setFirstName( actorDto.getFirstName() );
        actor.setLastName( actorDto.getLastName() );

        return actor;
    }

    @Override
    public ActorDto actorPostReqToActor(ActorPostRequest actorPostRequest) {
        if ( actorPostRequest == null ) {
            return null;
        }

        ActorDto actorDto = new ActorDto();

        actorDto.setFirstName( actorPostRequest.getFirstName() );
        actorDto.setLastName( actorPostRequest.getLastName() );

        return actorDto;
    }

    @Override
    public FilmDto filmToFilmDto(Film film) {
        if ( film == null ) {
            return null;
        }

        FilmDto filmDto = new FilmDto();

        filmDto.setFilmId( film.getFilmId() );
        filmDto.setLanguageByLanguageId( languageToLanguageDto( film.getLanguageByLanguageId() ) );
        filmDto.setTitle( film.getTitle() );
        filmDto.setDescription( film.getDescription() );
        filmDto.setReleaseYear( film.getReleaseYear() );
        filmDto.setRentalRate( film.getRentalRate() );
        filmDto.setLength( film.getLength() );
        filmDto.setReplacementCost( film.getReplacementCost() );
        filmDto.setRating( film.getRating() );
        filmDto.setSpecialFeatures( film.getSpecialFeatures() );

        return filmDto;
    }

    @Override
    public Film filmDtoToFilm(FilmDto filmDto) {
        if ( filmDto == null ) {
            return null;
        }

        Film film = new Film();

        film.setFilmId( filmDto.getFilmId() );
        film.setLanguageByLanguageId( languageDtoToLanguage( filmDto.getLanguageByLanguageId() ) );
        film.setTitle( filmDto.getTitle() );
        film.setDescription( filmDto.getDescription() );
        film.setReleaseYear( filmDto.getReleaseYear() );
        film.setRentalRate( filmDto.getRentalRate() );
        film.setLength( filmDto.getLength() );
        film.setReplacementCost( filmDto.getReplacementCost() );
        film.setRating( filmDto.getRating() );
        film.setSpecialFeatures( filmDto.getSpecialFeatures() );

        return film;
    }

    protected LanguageDto languageToLanguageDto(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setLanguageId( language.getLanguageId() );
        languageDto.setName( language.getName() );
        languageDto.setLastUpdate( language.getLastUpdate() );

        return languageDto;
    }

    protected Language languageDtoToLanguage(LanguageDto languageDto) {
        if ( languageDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setLanguageId( languageDto.getLanguageId() );
        language.setName( languageDto.getName() );
        language.setLastUpdate( languageDto.getLastUpdate() );

        return language;
    }
}
