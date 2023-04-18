package com.iti.sakila.api.soap.webservice;

import com.iti.sakila.bussiness.dtos.Message;
import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.service.PaymentService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@WebService
public class PaymentWebService {
    private final PaymentService paymentService = new PaymentService();

    @WebMethod
    public List<PaymentDto> getPayments(@WebParam(name = "page") int page) {
        return paymentService.getAll(page);
    }

    @WebMethod
    public PaymentDto getPayment(@WebParam(name = "id") int id) {
        return paymentService.findById(id);
    }

    @WebMethod
    public Message updatePayment(@WebParam(name = "payment") PaymentDto payment) {
        return paymentService.update(payment, payment.getPaymentId());
    }

    @WebMethod
    public Message deletePayment(@WebParam(name = "id") int id) {
        return paymentService.delete(id);
    }

    @WebMethod
    public List<PaymentDto> findPaymentByAmount(@WebParam(name = "amount") String amount, @WebParam(name = "page") int page) {
        List<PaymentDto> payments = paymentService.findByAmount(new BigDecimal(amount), page);
        System.out.println("findPaymentByAmount : " + amount);
        System.out.println("Payments : " + payments);
        return payments;
    }

    @WebMethod
    public List<PaymentDto> findPaymentByRental(@WebParam(name = "rentalId") int rentalId, @WebParam(name = "page") int page) {
        return paymentService.findByRental(rentalId, page);
    }

    @WebMethod
    public List<PaymentDto> findPaymentByCustomer(@WebParam(name = "customerId") int customerId, @WebParam(name = "page") int page) {
        return paymentService.findTransactionsForCustomer(customerId, page);
    }

    @WebMethod
    public List<PaymentDto> findPaymentByDate(@WebParam(name = "from") Date from, @WebParam(name = "to") Date to, @WebParam(name = "page") int page) {
        return paymentService.findTransactionByDate(from, to, page);
    }

    @WebMethod
    public List<PaymentDto> findPaymentByStaff(@WebParam(name = "staffId") int id, @WebParam(name = "page") int page) {
        return paymentService.findTransactionsForStaff(id, page);
    }
}
