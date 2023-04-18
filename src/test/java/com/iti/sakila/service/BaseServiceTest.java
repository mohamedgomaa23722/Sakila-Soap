package com.iti.sakila.service;

import com.iti.sakila.bussiness.dtos.addressdtos.AddressDto;
import com.iti.sakila.bussiness.dtos.persondtos.CustomerDto;
import com.iti.sakila.bussiness.dtos.filmdtos.FilmDto;
import com.iti.sakila.bussiness.dtos.languagedtos.LanguageDto;
import com.iti.sakila.bussiness.dtos.persondtos.StuffDto;
import com.iti.sakila.bussiness.mapper.AddressMapper;
import com.iti.sakila.bussiness.mapper.CustomerMapper;
import com.iti.sakila.bussiness.mapper.LanguageMapper;
import com.iti.sakila.bussiness.mapper.StuffMapper;
import com.iti.sakila.bussiness.mapper.filmmapper.FilmMapper;
import com.iti.sakila.bussiness.service.BaseService;
import com.iti.sakila.persistance.entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseServiceTest {

    @Test
    public void get_All_Actors_by_baseService() {
        //Arrange
        BaseService<Film, FilmDto> baseService = new BaseService<>(Film.class, FilmMapper.INSTANCE);
        //Act
        List<FilmDto> actors = baseService.getAll(1);
        System.out.println(actors);
        //Assert
        Assertions.assertTrue(actors.size() > 0);
    }

    @Test
    public void get_all_Language() {
        //Arrange
        BaseService<Language, LanguageDto> baseService = new BaseService<>(Language.class, LanguageMapper.INSTANCE);
        //Act
        List<LanguageDto> languages = baseService.getAll(1);
        System.out.println(languages);
        //Assert
        Assertions.assertTrue(languages.size() != 0);
    }
    @Test
    public void get_all_addresses() {
        //Arrange
        BaseService<Address, AddressDto> baseService = new BaseService<>(Address.class, AddressMapper.INSTANCE);
        //Act
        List<AddressDto> languages = baseService.getAll(1);
        System.out.println(languages);
        //Assert
        Assertions.assertTrue(languages.size() != 0);
    }

    @Test
    public void get_all_customers() {
        //Arrange
        BaseService<Customer, CustomerDto> baseService = new BaseService<>(Customer.class, CustomerMapper.INSTANCE);
        //Act
        List<CustomerDto> languages = baseService.getAll(1);
        System.out.println(languages);
        //Assert
        Assertions.assertTrue(languages.size() != 0);
    }

    @Test
    public void get_all_Staffs() {
        //Arrange
        BaseService<Staff, StuffDto> baseService = new BaseService<>(Staff.class, StuffMapper.INSTANCE);
        //Act
        List<StuffDto> languages = baseService.getAll(1);
        System.out.println(languages);
        //Assert
        Assertions.assertTrue(languages.size() != 0);
    }
}
