package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.dtos.*;
import com.iti.sakila.bussiness.mapper.MapperInterface;
import com.iti.sakila.utils.ResponseGenerator;
import com.iti.sakila.persistance.entity.Actor;
import com.iti.sakila.persistance.repository.ActorRepository;
import com.iti.sakila.persistance.repository.BaseRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActorService {

    BaseRepository<Actor> actorBaseRepository;

    public ActorService() {
        actorBaseRepository = new ActorRepository();
    }

    public ListResponse<ActorDto> getActors(int page) {
        List<ActorDto> actorDtos = new ArrayList<>();
        actorBaseRepository.getAll(page).forEach(actor -> actorDtos.add(MapperInterface.INSTANCE.actorToActorDto(actor)));
        return ResponseGenerator.ListMapper(actorDtos, page);
    }

    public ObjectResponse<ActorDto> findActorById(int id) {
        ActorDto actorDto = MapperInterface.INSTANCE.actorToActorDto(actorBaseRepository.findById(id));
        return ResponseGenerator.ObjectMapper(actorDto);
    }

    public ListResponse<Actor> findActorByName(String actorName, int page) {
        return ResponseGenerator.ListMapper(actorBaseRepository.findByName(actorName, page), page);
    }

    public Message insertActor(ActorDto actorDto) {
        Actor actor = MapperInterface.INSTANCE.actorDtoToActor(actorDto);
        actor.setLastUpdate(new Timestamp(new Date().getTime()));
        Actor insertedActor = actorBaseRepository.insert(actor);
        Message message = null;
        if (insertedActor != null)
            message = new Message(200, "successfully inserted with id : " + insertedActor.getActorId(), "");
        else
            message = new Message(500, "error happened into process", "May be you Enter wrong data");
        return message;
    }

    public Message deleteActor(int id) {
        boolean isDeleted = actorBaseRepository.delete(id);
        Message message = null;
        if (isDeleted)
            message = new Message(200, "successfully deleted", "");
        else
            message = new Message(500, "error happened while deleting", "May be you Enter wrong data");
        return message;
    }
}
