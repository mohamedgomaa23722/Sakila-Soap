package com.iti.sakila.service;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.persondtos.CustomerDto;
import com.iti.sakila.bussiness.mapper.CustomerMapper;
import com.iti.sakila.bussiness.service.CustomerService;
import com.iti.sakila.persistance.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerServiceTest {

    @Test
    public void insert_customer(){
        //arrange
        CustomerService customerService = new CustomerService(Customer.class, CustomerMapper.INSTANCE);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName("mohamed");
        customerDto.setLastName("gomaa");
        customerDto.setEmail("email");
        customerDto.setAddress("address");
        customerDto.setDistrict("district");
        customerDto.setPostalCode("postalCode");
        customerDto.setPhone("phone");
        customerDto.setCity("cairo");
        customerDto.setCountry("Egypt");
        //Act
        Message message =  customerService.insert(customerDto);
        //Asserts
        Assertions.assertEquals(message.getCode(), 200);
    }
}
