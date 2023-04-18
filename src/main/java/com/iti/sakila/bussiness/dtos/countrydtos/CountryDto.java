package com.iti.sakila.bussiness.dtos.countrydtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.sakila.persistance.entity.Country} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto implements Serializable {
    private  Short countryId;
    private  String country;
    private  Set<CountryCityDto> cities;
}