package com.iti.sakila.api.soap.webservice;

import com.iti.sakila.api.soap.dtos.customerdtos.CustomerResponse;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.persondtos.CustomerDto;
import com.iti.sakila.bussiness.mapper.CustomerMapper;
import com.iti.sakila.bussiness.service.CustomerService;
import com.iti.sakila.persistance.entity.Customer;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;


import java.util.List;
@WebService
public class CustomerWebService{
    private final CustomerService customerService;

    public CustomerWebService() {
        customerService = new CustomerService(Customer.class, CustomerMapper.INSTANCE);
    }

    @WebMethod
    @WebResult(name = "customers")
    public List<CustomerResponse> getCustomers(@WebParam(name = "page") int page) {
        List<CustomerDto> customers = customerService.getAll(page);
        return CustomerMapper.INSTANCE.toResponseList(customers);
    }

    @WebMethod
    public Message insertCustomer(@WebParam(name = "customer") CustomerDto customerDto) {
        return customerService.insert(customerDto);
    }

    @WebMethod
    public Message deleteCustomer(@WebParam(name = "id") int id) {
        return customerService.delete(id);
    }

    @WebMethod
    public List<CustomerDto> findCustomerByName(@WebParam(name = "name") String name, @WebParam(name = "page") int page) {
        return customerService.findByName(name,"firstName", page);
    }

    @WebMethod
    public CustomerResponse findCustomerById(@WebParam(name = "id") int id) {
        CustomerDto customerDto = customerService.findById(id);
        return CustomerMapper.INSTANCE.toResponse(customerDto);
    }

}
