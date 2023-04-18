package com.iti.sakila.api.soap.webservice;

import com.iti.sakila.api.soap.dtos.rentdtos.UpdateRentRequest;
import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.api.soap.dtos.rentdtos.InsertRentalRequest;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.bussiness.mapper.RentalMapper;
import com.iti.sakila.bussiness.service.RentService;
import com.iti.sakila.persistance.entity.Rental;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@WebService
public class RentalWebService {
    private final RentService rentService = new RentService();

    @WebMethod
    public List<RentDto> getRentals(@WebParam(name = "page") int page) {
        return rentService.getAll(page);
    }

    @WebMethod
    public RentDto findRentalById(@WebParam(name = "id") int id) {
        return rentService.findById(id);
    }

    @WebMethod
    public Message insertRental(@WebParam(name = "rental") InsertRentalRequest insertRentalRequest) {
        return rentService.insertRental(insertRentalRequest);
    }

    @WebMethod
    public Message updateRental(@WebParam(name = "rental") UpdateRentRequest updateRentRequest) {
        RentDto rentDto = RentalMapper.INSTANCE.fromRentalRequest(updateRentRequest);
        return rentService.update(rentDto, rentDto.getRentalId());
    }

    @WebMethod
    public Message delete(@WebParam(name = "id") int id) {
        return rentService.delete(id);
    }

    @WebMethod
    public List<RentDto> findCustomerRentals(@WebParam(name = "customerId") int customerId, @WebParam(name = "page") int page) {
        List<RentDto> rentals = rentService.findTransactionsForCustomer(customerId, page);
        System.out.println(rentals);
        return rentals;
    }

    @WebMethod
    public List<RentDto> findStaffRentals(@WebParam(name = "staffId") int staffId, @WebParam(name = "page") int page) {
        return rentService.findTransactionsForStaff(staffId, page);
    }

    @WebMethod
    public List<RentDto> findRentalsByRentalDate(@WebParam(name = "from") Date from, @WebParam(name = "to") Date to,
                                                 @WebParam(name = "page") int page) {
        return rentService.findTransactionByDate(from, to, page);
    }

    @WebMethod
    public List<RentDto> findRentalByInventory(@WebParam(name = "inventoryId") int id){
        return rentService.findRentalByInventory(id);
    }
}
