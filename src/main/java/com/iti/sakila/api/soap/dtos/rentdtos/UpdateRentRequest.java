package com.iti.sakila.api.soap.dtos.rentdtos;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateRentRequest {
    private final int rentalId;
    private String customerId;
    private final Date returnDate;
    private final Date rentalDate;
}
