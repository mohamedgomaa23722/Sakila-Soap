package com.iti.sakila.api.rest;

import com.iti.sakila.bussiness.dtos.FilmDto;
import com.iti.sakila.bussiness.dtos.ListResponse;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.ObjectResponse;
import com.iti.sakila.bussiness.service.FilmService;
import com.iti.sakila.utils.FilterRecord;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;

@Path("v1/films")
public class FilmResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificFilm(@DefaultValue("1") @QueryParam("page") int page,
                                    @DefaultValue("0") @QueryParam("categoryId") int categoryId,
                                    @DefaultValue("0") @QueryParam("cost") int cost,
                                    @DefaultValue("0") @QueryParam("rate") int rate,
                                    @DefaultValue("") @QueryParam("name") String name) {
        FilmService filmService = new FilmService();
        FilterRecord filterRecord = new FilterRecord(page,
                categoryId,
                new BigDecimal(cost),
                new BigDecimal(rate),
                name);
        ListResponse<FilmDto> films = filmService.findFilmWithMultipleFilters(filterRecord);
        return Response.ok().entity(films).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findFilmById(@PathParam("id") int id) {
        FilmService filmService = new FilmService();
        ObjectResponse<FilmDto> filmResponse = filmService.findFilmById(id);
        return Response.ok().entity(filmResponse).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertFilm(FilmDto filmDto) {
        FilmService filmService = new FilmService();
        System.out.println(filmDto);
        Message message = filmService.insertFilm(filmDto);
        return Response.ok().entity(message).build();
    }
}