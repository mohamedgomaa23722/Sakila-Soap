package com.iti.sakila.api.soap.dtos;

import com.iti.sakila.bussiness.dtos.ActorDto;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "actors")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActorResponse {
   @XmlElement(name = "actor")
   private List<ActorDto> actorsList;

   public ActorResponse() {
   }

   public List<ActorDto> getActorsList() {
      return actorsList;
   }

   public void setActorsList(List<ActorDto> actorsList) {
      this.actorsList = actorsList;
   }
}
