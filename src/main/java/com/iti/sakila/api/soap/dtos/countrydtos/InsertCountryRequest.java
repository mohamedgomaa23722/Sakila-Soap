package com.iti.sakila.api.soap.dtos.countrydtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InsertCountryRequest {
    @NotNull(message = "Please enter country name")
    @Size(min = 4, max = 25, message = "country name must contain 4 to 25 letters")
    private  String country;
}
