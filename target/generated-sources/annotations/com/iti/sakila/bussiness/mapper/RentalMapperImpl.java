package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.api.soap.dtos.customerdtos.CustomerRentalResponse;
import com.iti.sakila.api.soap.dtos.rentdtos.UpdateRentRequest;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.persistance.entity.Customer;
import com.iti.sakila.persistance.entity.Film;
import com.iti.sakila.persistance.entity.Inventory;
import com.iti.sakila.persistance.entity.Rental;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-18T06:03:51+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class RentalMapperImpl implements RentalMapper {

    @Override
    public List<RentDto> toDtoList(List<Rental> list) {
        if ( list == null ) {
            return null;
        }

        List<RentDto> list1 = new ArrayList<RentDto>( list.size() );
        for ( Rental rental : list ) {
            list1.add( toDto( rental ) );
        }

        return list1;
    }

    @Override
    public Rental toEntity(RentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Rental rental = new Rental();

        rental.setRentalId( dto.getRentalId() );
        rental.setRentalDate( dto.getRentalDate() );
        rental.setReturnDate( dto.getReturnDate() );

        return rental;
    }

    @Override
    public Rental partialUpdate(RentDto dto, Rental entity) {
        if ( dto == null ) {
            return entity;
        }

        if ( dto.getRentalId() != null ) {
            entity.setRentalId( dto.getRentalId() );
        }
        if ( dto.getRentalDate() != null ) {
            entity.setRentalDate( dto.getRentalDate() );
        }
        if ( dto.getReturnDate() != null ) {
            entity.setReturnDate( dto.getReturnDate() );
        }

        return entity;
    }

    @Override
    public RentDto toDto(Rental entity) {
        if ( entity == null ) {
            return null;
        }

        RentDto rentDto = new RentDto();

        Short customerId = entityCustomerCustomerId( entity );
        if ( customerId != null ) {
            rentDto.setCustomerId( String.valueOf( customerId ) );
        }
        rentDto.setCustomerName( entityCustomerFirstName( entity ) );
        rentDto.setFilmName( entityInventoryFilmTitle( entity ) );
        rentDto.setRentalId( entity.getRentalId() );
        rentDto.setRentalDate( entity.getRentalDate() );
        rentDto.setReturnDate( entity.getReturnDate() );

        return rentDto;
    }

    @Override
    public CustomerRentalResponse toRentalResponse(Rental rental) {
        if ( rental == null ) {
            return null;
        }

        CustomerRentalResponse customerRentalResponse = new CustomerRentalResponse();

        Short customerId = entityCustomerCustomerId( rental );
        if ( customerId != null ) {
            customerRentalResponse.setCustomerId( customerId );
        }
        customerRentalResponse.setCustomerName( entityCustomerFirstName( rental ) );

        return customerRentalResponse;
    }

    @Override
    public RentDto fromRentalRequest(UpdateRentRequest rentalRequest) {
        if ( rentalRequest == null ) {
            return null;
        }

        RentDto rentDto = new RentDto();

        rentDto.setCustomerId( rentalRequest.getCustomerId() );
        rentDto.setRentalId( rentalRequest.getRentalId() );
        rentDto.setRentalDate( rentalRequest.getRentalDate() );
        rentDto.setReturnDate( rentalRequest.getReturnDate() );

        return rentDto;
    }

    @Override
    public List<CustomerRentalResponse> toRentalResponseList(List<Rental> rentals) {
        if ( rentals == null ) {
            return null;
        }

        List<CustomerRentalResponse> list = new ArrayList<CustomerRentalResponse>( rentals.size() );
        for ( Rental rental : rentals ) {
            list.add( toRentalResponse( rental ) );
        }

        return list;
    }

    private Short entityCustomerCustomerId(Rental rental) {
        if ( rental == null ) {
            return null;
        }
        Customer customer = rental.getCustomer();
        if ( customer == null ) {
            return null;
        }
        Short customerId = customer.getCustomerId();
        if ( customerId == null ) {
            return null;
        }
        return customerId;
    }

    private String entityCustomerFirstName(Rental rental) {
        if ( rental == null ) {
            return null;
        }
        Customer customer = rental.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String firstName = customer.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String entityInventoryFilmTitle(Rental rental) {
        if ( rental == null ) {
            return null;
        }
        Inventory inventory = rental.getInventory();
        if ( inventory == null ) {
            return null;
        }
        Film film = inventory.getFilm();
        if ( film == null ) {
            return null;
        }
        String title = film.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }
}
