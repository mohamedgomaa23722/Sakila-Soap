package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.bussiness.dtos.persondtos.CustomerDto;
import com.iti.sakila.bussiness.dtos.persondtos.StuffDto;
import com.iti.sakila.persistance.entity.Customer;
import com.iti.sakila.persistance.entity.Staff;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "default", uses = {AddressMapper.class, RentalMapper.class})
public interface StuffMapper extends BaseMapper<Staff, StuffDto> {
    StuffMapper INSTANCE = Mappers.getMapper(StuffMapper.class);
    @Mapping(source = "storeId", target = "store.storeId")
    @Mapping(source = "city", target = "address.city.city")
    @Mapping(source = "country", target = "address.city.country.country")
    @Mapping(source = "address", target = "address.address")
    @Mapping(source = "district", target = "address.district")
    @Mapping(source = "postalCode", target = "address.postalCode")
    @Mapping(source = "phone", target = "address.phone")
    Staff toEntity(StuffDto stuffDto);

    @Mapping(source = "store.storeId", target = "storeId")
    @Mapping(target = "city", source = "address.city.city")
    @Mapping(target = "country", source = "address.city.country.country")
    @Mapping(target = "address", source = "address.address")
    @Mapping(target = "district", source = "address.district")
    @Mapping(target = "postalCode", source = "address.postalCode")
    @Mapping(target = "phone", source = "address.phone")
    StuffDto toDto(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "storeId", target = "store.storeId")
    @Mapping(source = "city", target = "address.city.city")
    @Mapping(source = "country", target = "address.city.country.country")
    @Mapping(source = "address", target = "address.address")
    @Mapping(source = "district", target = "address.district")
    @Mapping(source = "postalCode", target = "address.postalCode")
    @Mapping(source = "phone", target = "address.phone")
    Staff partialUpdate(StuffDto stuffDto, @MappingTarget Staff staff);

    @AfterMapping
    default void linkPayments(@MappingTarget Staff staff) {
        staff.getPayments().forEach(payment -> payment.setStaff(staff));
    }

    @AfterMapping
    default void linkRentals(@MappingTarget Staff staff) {
        staff.getRentals().forEach(rental -> rental.setStaff(staff));
    }
}