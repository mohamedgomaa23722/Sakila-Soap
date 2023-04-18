package com.iti.sakila.api.soap.webservice;

import com.iti.sakila.api.soap.dtos.citydtos.InsertCityRequest;
import com.iti.sakila.api.soap.dtos.citydtos.UpdateCityRequest;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.addressdtos.CityDto;
import com.iti.sakila.bussiness.mapper.CityMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.bussiness.service.BaseTransactionService;
import com.iti.sakila.persistance.entity.City;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class CityWebService {

    private final BaseService<City, CityDto> baseService = new BaseTransactionService<>(City.class, CityMapper.INSTANCE);

    @WebMethod
    public List<CityDto> getCities(@WebParam(name = "page") int page) {
        return baseService.getAll(page);
    }

    @WebMethod
    public CityDto getCity(@WebParam(name = "id") int id) {
        return baseService.findById(id);
    }

    @WebMethod
    public Message insertCity(@WebParam(name = "city") InsertCityRequest insertCityRequest) {
        CityDto city = CityMapper.INSTANCE.fromInsertCityRequest(insertCityRequest);
        return baseService.insert(city);
    }

    @WebMethod
    public Message updateCity(@WebParam(name = "city") UpdateCityRequest updateCityRequest) {
        CityDto city = CityMapper.INSTANCE.fromUpdateCityRequest(updateCityRequest);
        return baseService.update(city, city.getCityId());
    }

    @WebMethod
    public Message deleteCity(@WebParam(name = "id") int id) {
        return baseService.delete(id);
    }

    @WebMethod
    public List<CityDto> findCitiesByName(@WebParam(name = "name") String name, int page) {
        List<CityDto> city = baseService.findByName(name, "city", page);
        System.out.println(name + page);
        System.out.println(city);
        return city;
    }

}
