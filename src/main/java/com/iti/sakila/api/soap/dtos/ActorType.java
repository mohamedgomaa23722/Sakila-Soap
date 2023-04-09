package com.iti.sakila.api.soap.dtos;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "actor")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActorType {
    @XmlElement(name = "id")
    private Short actorId;
    private String firstName;
    private String lastName;

    public ActorType() {
    }

    public Short getActorId() {
        return actorId;
    }

    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
