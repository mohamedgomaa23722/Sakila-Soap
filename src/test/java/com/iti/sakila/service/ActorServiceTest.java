package com.iti.sakila.service;

import com.iti.sakila.bussiness.dtos.ActorDto;
import com.iti.sakila.bussiness.dtos.ListResponse;
import com.iti.sakila.bussiness.service.ActorService;
import com.sun.xml.wss.saml.assertion.saml11.jaxb20.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ActorServiceTest {

    public static ActorService actorService;

    @BeforeAll
    public static void init() {
        actorService = new ActorService();
    }

    @Test
    public void getAllActors() {
        //Arrange
        int page = 1;
        //Act
        ListResponse<ActorDto> response = actorService.getActors(page);
        System.out.println(response.getItems());
        //Assert
        Assertions.assertEquals(response.getMessage().getCode(), 200);
    }
}
