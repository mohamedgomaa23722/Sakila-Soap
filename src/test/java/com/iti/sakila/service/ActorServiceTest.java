package com.iti.sakila.service;

import com.iti.sakila.bussiness.dtos.actordto.ActorDto;
import com.iti.sakila.bussiness.mapper.actormapper.ActorMapper;
import com.iti.sakila.bussiness.service.ActorService;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.persistance.entity.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ActorServiceTest {

    private static BaseService<Actor,ActorDto> actorService;

    @BeforeAll
    public static void init() {
        actorService = new ActorService(Actor.class, ActorMapper.INSTANCE);
    }

    @Test
    public void getAllActors() {
        //Arrange
        int page = 1;
        //Act
        List<ActorDto> response = actorService.getAll(page);
        System.out.println(response);
        //Assert
        Assertions.assertEquals(response.size(), 10);
    }
}
