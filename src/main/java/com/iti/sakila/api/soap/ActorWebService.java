package com.iti.sakila.api.soap;
import com.iti.sakila.api.soap.dtos.ActorPostRequest;
import com.iti.sakila.api.soap.dtos.ActorResponse;
import com.iti.sakila.bussiness.dtos.ActorDto;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.ObjectResponse;
import com.iti.sakila.bussiness.mapper.MapperInterface;
import com.iti.sakila.bussiness.service.ActorService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@WebService(name = "actors")
@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ActorWebService {
    private final  ActorService actorService;

    public ActorWebService() {
        actorService = new ActorService();
    }

    @WebMethod(operationName = "actorsData")
    public ActorResponse getActors(@WebParam(name = "page") int page){
        ActorResponse actorResponse = new ActorResponse();
        actorResponse.setActorsList(actorService.getActors(page).getItems());
        System.out.println("enter inside service");
        return actorResponse;
    }

    @WebMethod
    public ObjectResponse<ActorDto> getActor(@WebParam(name = "id") int id) {
        return actorService.findActorById(id);
    }

    @WebMethod
    public Message insertActor(ActorPostRequest actorPostRequest){
        System.out.println("insert actor");
        System.out.println(actorPostRequest);
        return actorService.insertActor(MapperInterface.INSTANCE.actorPostReqToActor(actorPostRequest));
    }
}
