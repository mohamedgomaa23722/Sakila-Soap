package com.iti.sakila.api.soap.webservice;

import com.iti.sakila.api.soap.dtos.countrydtos.InsertCountryRequest;
import com.iti.sakila.api.soap.dtos.countrydtos.UpdateCountryRequest;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.addressdtos.CityDto;
import com.iti.sakila.bussiness.dtos.countrydtos.CountryDto;
import com.iti.sakila.bussiness.mapper.CityMapper;
import com.iti.sakila.bussiness.mapper.CountryMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.bussiness.service.BaseTransactionService;
import com.iti.sakila.persistance.entity.City;
import com.iti.sakila.persistance.entity.Country;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class CountryWebService {

    private final BaseService<Country, CountryDto> baseService = new BaseTransactionService<>(Country.class, CountryMapper.INSTANCE);

    @WebMethod
    public List<CountryDto> getCountries(@WebParam(name = "page") int page) {
        return baseService.getAll(page);
    }

    @WebMethod
    public CountryDto getCountry(@WebParam(name = "id") int id) {
        return baseService.findById(id);
    }

    @WebMethod
    public Message insertCountry(@WebParam(name = "country") InsertCountryRequest insertCountryRequest) {
        CountryDto country = CountryMapper.INSTANCE.fromInsertCountryRequest(insertCountryRequest);
        return baseService.insert(country);
    }

    @WebMethod
    public Message updateCountry(@WebParam(name = "country") UpdateCountryRequest updateCountryRequest) {
        CountryDto country = CountryMapper.INSTANCE.fromUpdateCountryRequest(updateCountryRequest);
        return baseService.update(country, country.getCountryId());
    }

    @WebMethod
    public Message deleteCountry(@WebParam(name = "id") int id) {
        return baseService.delete(id);
    }

    @WebMethod
    public List<CountryDto> findCountriesByName(@WebParam(name = "name") String name, int page) {
        return baseService.findByName(name, "country", page);
    }
}