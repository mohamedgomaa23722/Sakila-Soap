package com.iti.sakila.api.soap.dtos.rentdtos;

import lombok.Data;

@Data
public class InsertRentalRequest {
    private int filmId;
    private int customerId;
    private int staffId;
}
