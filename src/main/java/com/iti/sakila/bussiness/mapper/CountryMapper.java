package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.soap.dtos.categorydtos.InsertCategoryRequest;
import com.iti.sakila.api.soap.dtos.categorydtos.UpdateCategoryRequest;
import com.iti.sakila.api.soap.dtos.countrydtos.InsertCountryRequest;
import com.iti.sakila.api.soap.dtos.countrydtos.UpdateCountryRequest;
import com.iti.sakila.bussiness.dtos.CategoryDto;
import com.iti.sakila.bussiness.dtos.countrydtos.CountryDto;
import com.iti.sakila.persistance.entity.Country;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
public interface CountryMapper extends BaseMapper<Country,CountryDto> {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDto fromInsertCountryRequest(InsertCountryRequest insertCountryRequest);

    CountryDto fromUpdateCountryRequest(UpdateCountryRequest updateCountryRequest);

    @AfterMapping
    default void linkCities(@MappingTarget Country country) {
        country.getCities().forEach(city -> city.setCountry(country));
    }
}