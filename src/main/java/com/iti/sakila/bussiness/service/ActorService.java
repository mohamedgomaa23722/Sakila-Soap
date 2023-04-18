package com.iti.sakila.bussiness.service;

import com.iti.sakila.bussiness.dtos.*;
import com.iti.sakila.bussiness.dtos.actordto.ActorDto;
import com.iti.sakila.bussiness.mapper.BaseMapper;
import com.iti.sakila.bussiness.mapper.actormapper.ActorMapper;
import com.iti.sakila.persistance.entity.Actor;
import com.iti.sakila.persistance.repository.ActorRepository;
import com.iti.sakila.persistance.repository.BaseRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ActorService extends BaseService<Actor, ActorDto>{


    public ActorService(Class<Actor> src, BaseMapper<Actor, ActorDto> baseMapper) {
        super(src, baseMapper);
    }

//    public Message insertActor(ActorDto actorDto) {
//        Actor actor =ActorMapper.INSTANCE.toEntity(actorDto);
//        actor.setLastUpdate(new Timestamp(new Date().getTime()));
//        Actor insertedActor = super.insert(actor);
//        Message message = null;
//        if (insertedActor != null)
//            message = new Message(200, "successfully inserted with id : " + insertedActor.getActorId(), "");
//        else
//            message = new Message(500, "error happened into process", "May be you Enter wrong data");
//        return message;
//    }

}
