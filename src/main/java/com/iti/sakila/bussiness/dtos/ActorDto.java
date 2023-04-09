package com.iti.sakila.bussiness.dtos;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@NoArgsConstructor
public class ActorDto {
    private Short actorId;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "ActorDto{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}'+"\n";
    }
}
