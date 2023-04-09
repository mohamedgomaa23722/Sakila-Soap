package com.iti.sakila.api.rest;

import com.iti.sakila.api.dtos.ActorPostRequest;
import com.iti.sakila.bussiness.dtos.ActorDto;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.service.ActorService;
import com.iti.sakila.persistance.entity.Actor;
import com.iti.sakila.persistance.repository.ActorRepository;
import com.iti.sakila.persistance.repository.BaseRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Getter;

import javax.print.attribute.standard.Media;

@Path("v1/actors")
public class ActorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActors(@DefaultValue("1") @QueryParam("page") int page) {
        ActorService actorService = new ActorService();
        return Response.ok().entity(actorService.getActors(page)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertActor(ActorDto actor) {
        ActorService actorService = new ActorService();
        Message meessage = actorService.insertActor(actor);
        return Response.ok().entity(meessage).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActor(@PathParam("id") int id) {
        ActorService actorService = new ActorService();
        return Response.ok().entity(actorService.findActorById(id)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response DeleteActor(@PathParam("id") int id) {
        ActorService actorService = new ActorService();
        return Response.ok().entity(actorService.deleteActor(id)).build();
    }
}
