package com.iti.sakila.api.soap.webservice;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.actordto.ActorDto;
import com.iti.sakila.bussiness.mapper.actormapper.ActorMapper;
import com.iti.sakila.bussiness.service.ActorService;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.persistance.entity.Actor;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.DefaultValue;

import java.util.List;

@WebService(name = "actors")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ActorWebService {
    private final BaseService<Actor,ActorDto> actorService;

    public ActorWebService() {
        actorService = new ActorService(Actor.class, ActorMapper.INSTANCE);
    }

    @WebMethod(operationName = "actorsData")
    @WebResult(name = "actors")
    public List<ActorDto> getActors(@WebParam(name = "page") int page){
        return actorService.getAll(page);
    }

    @WebMethod
    public ActorDto getActor(@DefaultValue ("1") @WebParam(name = "id") int id) {
        return actorService.findById(id);
    }

    @WebMethod(operationName = "insertActor")
    public Message insertActor(@WebParam(name = "actor") ActorDto actorDto){
        return actorService.insert(actorDto);
    }

    @WebMethod(operationName = "deleteActor")
    public Message deleteActor(@WebParam(name = "id") int id){
        return actorService.delete(id);
    }

    @WebMethod(operationName = "updateActor")
    public Message updateActor(@WebParam(name = "actorReq") ActorDto actorDto, @WebParam(name = "id") int id){
        return null;
    }
}
