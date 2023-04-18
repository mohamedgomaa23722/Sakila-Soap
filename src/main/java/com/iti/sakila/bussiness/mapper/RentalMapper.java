package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.soap.dtos.customerdtos.CustomerRentalResponse;
import com.iti.sakila.api.soap.dtos.rentdtos.UpdateRentRequest;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.persistance.entity.Rental;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "default")
public interface RentalMapper extends BaseMapper<Rental, RentDto> {
    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);

    @Mapping(source = "customer.customerId", target = "customerId")
    @Mapping(source = "customer.firstName", target = "customerName")
    @Mapping(source = "inventory.film.title", target = "filmName")
    @Override
    RentDto toDto(Rental entity);

    @Mapping(source = "customer.customerId", target = "customerId")
    @Mapping(source = "customer.firstName", target = "customerName")
    CustomerRentalResponse toRentalResponse(Rental rental);

    @Mapping(target = "customerId", source = "customerId")
    RentDto fromRentalRequest(UpdateRentRequest rentalRequest);

    List<CustomerRentalResponse> toRentalResponseList(List<Rental> rentals);
}