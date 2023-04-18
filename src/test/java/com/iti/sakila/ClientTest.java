package com.iti.sakila;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.persistance.entity.Actor;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



public class ClientTest {

    private static  Client client;

    @BeforeAll
    public static void init() {
        client = ClientBuilder.newClient();
    }

    @Test
    public void getActors() {
        //Arrange
        //Act
        Response response = client
                .target("http://localhost:8080/sakila/api/v1/actors/")
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(Response.class);
        System.out.println(response);
        //Assert
        Assertions.assertEquals(200, response.getStatus());
    }

    @Test
    public void get_Actor() {
        //Arrange
        int id = 2;
        //Act
        Actor response = client
                .target("http://localhost:8080/sakila/api/v1/actors/")
                .path("{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(Actor.class);

        System.out.println(response);
        //Assert
        Assertions.assertTrue(response.getFirstName() != null);
    }


//    @Test
//    public void Insert_New_Actor() {
//        //Arrange
//        ActorDto actorDto = new ActorDto();
//        actorDto.setLastName("gomaa");
//        actorDto.setFirstName("Mohamed");
//        //Act
//        Message response = client
//                .target("http://localhost:8080/sakila/api/v1/actors/")
//                .request()
//                .post(Entity.entity( actorDto, MediaType.APPLICATION_JSON ), Response.class)
//                .readEntity(Message.class);
//        System.out.println(response);
//        //Assert
//        Assertions.assertEquals(response.getCode(), 200);
//    }


    @Test
    public void Delete_Actor() {
        //Arrange
        int id = 210;
        //Act
        Message response = client
                .target("http://localhost:8080/sakila/api/v1/actors/")
                .path("{id}")
                .resolveTemplate("id", id)
                .request()
                .delete()
                .readEntity(Message.class);
        System.out.println(response);
        //Assert
        Assertions.assertEquals(response.getCode(), 200);
    }
}
