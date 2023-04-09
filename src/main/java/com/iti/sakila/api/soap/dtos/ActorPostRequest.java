package com.iti.sakila.api.soap.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ActorPostRequest {
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "ActorPostRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
