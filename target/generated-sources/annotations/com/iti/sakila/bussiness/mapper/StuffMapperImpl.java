package com.iti.sakila.bussiness.mapper;

import com.iti.sakila.bussiness.dtos.customerdtos.PaymentDto;
import com.iti.sakila.bussiness.dtos.persondtos.StuffDto;
import com.iti.sakila.bussiness.dtos.rentdtos.RentDto;
import com.iti.sakila.persistance.entity.Address;
import com.iti.sakila.persistance.entity.City;
import com.iti.sakila.persistance.entity.Country;
import com.iti.sakila.persistance.entity.Payment;
import com.iti.sakila.persistance.entity.Rental;
import com.iti.sakila.persistance.entity.Staff;
import com.iti.sakila.persistance.entity.Store;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-18T06:03:50+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class StuffMapperImpl implements StuffMapper {

    private final RentalMapper rentalMapper = RentalMapper.INSTANCE;

    @Override
    public List<StuffDto> toDtoList(List<Staff> list) {
        if ( list == null ) {
            return null;
        }

        List<StuffDto> list1 = new ArrayList<StuffDto>( list.size() );
        for ( Staff staff : list ) {
            list1.add( toDto( staff ) );
        }

        return list1;
    }

    @Override
    public Staff toEntity(StuffDto stuffDto) {
        if ( stuffDto == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setStore( stuffDtoToStore( stuffDto ) );
        staff.setAddress( stuffDtoToAddress( stuffDto ) );
        staff.setStaffId( stuffDto.getStaffId() );
        staff.setFirstName( stuffDto.getFirstName() );
        staff.setLastName( stuffDto.getLastName() );
        staff.setEmail( stuffDto.getEmail() );
        staff.setActive( stuffDto.isActive() );
        staff.setUsername( stuffDto.getUsername() );
        staff.setPayments( paymentDtoSetToPaymentSet( stuffDto.getPayments() ) );
        staff.setRentals( rentDtoSetToRentalSet( stuffDto.getRentals() ) );

        linkPayments( staff );
        linkRentals( staff );

        return staff;
    }

    @Override
    public StuffDto toDto(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        StuffDto stuffDto = new StuffDto();

        Integer storeId = staffStoreStoreId( staff );
        if ( storeId != null ) {
            stuffDto.setStoreId( storeId.byteValue() );
        }
        stuffDto.setCity( staffAddressCityCity( staff ) );
        stuffDto.setCountry( staffAddressCityCountryCountry( staff ) );
        stuffDto.setAddress( staffAddressAddress( staff ) );
        stuffDto.setDistrict( staffAddressDistrict( staff ) );
        stuffDto.setPostalCode( staffAddressPostalCode( staff ) );
        stuffDto.setPhone( staffAddressPhone( staff ) );
        stuffDto.setStaffId( staff.getStaffId() );
        stuffDto.setUsername( staff.getUsername() );
        stuffDto.setFirstName( staff.getFirstName() );
        stuffDto.setLastName( staff.getLastName() );
        stuffDto.setEmail( staff.getEmail() );
        stuffDto.setActive( staff.isActive() );
        stuffDto.setPayments( paymentSetToPaymentDtoSet( staff.getPayments() ) );
        stuffDto.setRentals( rentalSetToRentDtoSet( staff.getRentals() ) );

        return stuffDto;
    }

    @Override
    public Staff partialUpdate(StuffDto stuffDto, Staff staff) {
        if ( stuffDto == null ) {
            return staff;
        }

        if ( staff.getStore() == null ) {
            staff.setStore( new Store() );
        }
        stuffDtoToStore1( stuffDto, staff.getStore() );
        if ( staff.getAddress() == null ) {
            staff.setAddress( new Address() );
        }
        stuffDtoToAddress1( stuffDto, staff.getAddress() );
        staff.setStaffId( stuffDto.getStaffId() );
        if ( stuffDto.getFirstName() != null ) {
            staff.setFirstName( stuffDto.getFirstName() );
        }
        if ( stuffDto.getLastName() != null ) {
            staff.setLastName( stuffDto.getLastName() );
        }
        if ( stuffDto.getEmail() != null ) {
            staff.setEmail( stuffDto.getEmail() );
        }
        staff.setActive( stuffDto.isActive() );
        if ( stuffDto.getUsername() != null ) {
            staff.setUsername( stuffDto.getUsername() );
        }
        if ( staff.getPayments() != null ) {
            Set<Payment> set = paymentDtoSetToPaymentSet( stuffDto.getPayments() );
            if ( set != null ) {
                staff.getPayments().clear();
                staff.getPayments().addAll( set );
            }
        }
        else {
            Set<Payment> set = paymentDtoSetToPaymentSet( stuffDto.getPayments() );
            if ( set != null ) {
                staff.setPayments( set );
            }
        }
        if ( staff.getRentals() != null ) {
            Set<Rental> set1 = rentDtoSetToRentalSet( stuffDto.getRentals() );
            if ( set1 != null ) {
                staff.getRentals().clear();
                staff.getRentals().addAll( set1 );
            }
        }
        else {
            Set<Rental> set1 = rentDtoSetToRentalSet( stuffDto.getRentals() );
            if ( set1 != null ) {
                staff.setRentals( set1 );
            }
        }

        linkPayments( staff );
        linkRentals( staff );

        return staff;
    }

    protected Store stuffDtoToStore(StuffDto stuffDto) {
        if ( stuffDto == null ) {
            return null;
        }

        Store store = new Store();

        if ( stuffDto.getStoreId() != null ) {
            store.setStoreId( stuffDto.getStoreId() );
        }

        return store;
    }

    protected Country stuffDtoToCountry(StuffDto stuffDto) {
        if ( stuffDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountry( stuffDto.getCountry() );

        return country;
    }

    protected City stuffDtoToCity(StuffDto stuffDto) {
        if ( stuffDto == null ) {
            return null;
        }

        City city = new City();

        city.setCountry( stuffDtoToCountry( stuffDto ) );
        city.setCity( stuffDto.getCity() );

        return city;
    }

    protected Address stuffDtoToAddress(StuffDto stuffDto) {
        if ( stuffDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setCity( stuffDtoToCity( stuffDto ) );
        address.setAddress( stuffDto.getAddress() );
        address.setDistrict( stuffDto.getDistrict() );
        address.setPostalCode( stuffDto.getPostalCode() );
        address.setPhone( stuffDto.getPhone() );

        return address;
    }

    protected Payment paymentDtoToPayment(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setPaymentId( paymentDto.getPaymentId() );
        payment.setAmount( paymentDto.getAmount() );
        payment.setPaymentDate( paymentDto.getPaymentDate() );

        return payment;
    }

    protected Set<Payment> paymentDtoSetToPaymentSet(Set<PaymentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Payment> set1 = new LinkedHashSet<Payment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PaymentDto paymentDto : set ) {
            set1.add( paymentDtoToPayment( paymentDto ) );
        }

        return set1;
    }

    protected Set<Rental> rentDtoSetToRentalSet(Set<RentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Rental> set1 = new LinkedHashSet<Rental>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RentDto rentDto : set ) {
            set1.add( rentalMapper.toEntity( rentDto ) );
        }

        return set1;
    }

    private Integer staffStoreStoreId(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Store store = staff.getStore();
        if ( store == null ) {
            return null;
        }
        int storeId = store.getStoreId();
        return storeId;
    }

    private String staffAddressCityCity(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
        if ( address == null ) {
            return null;
        }
        City city = address.getCity();
        if ( city == null ) {
            return null;
        }
        String city1 = city.getCity();
        if ( city1 == null ) {
            return null;
        }
        return city1;
    }

    private String staffAddressCityCountryCountry(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
        if ( address == null ) {
            return null;
        }
        City city = address.getCity();
        if ( city == null ) {
            return null;
        }
        Country country = city.getCountry();
        if ( country == null ) {
            return null;
        }
        String country1 = country.getCountry();
        if ( country1 == null ) {
            return null;
        }
        return country1;
    }

    private String staffAddressAddress(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
        if ( address == null ) {
            return null;
        }
        String address1 = address.getAddress();
        if ( address1 == null ) {
            return null;
        }
        return address1;
    }

    private String staffAddressDistrict(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
        if ( address == null ) {
            return null;
        }
        String district = address.getDistrict();
        if ( district == null ) {
            return null;
        }
        return district;
    }

    private String staffAddressPostalCode(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
        if ( address == null ) {
            return null;
        }
        String postalCode = address.getPostalCode();
        if ( postalCode == null ) {
            return null;
        }
        return postalCode;
    }

    private String staffAddressPhone(Staff staff) {
        if ( staff == null ) {
            return null;
        }
        Address address = staff.getAddress();
        if ( address == null ) {
            return null;
        }
        String phone = address.getPhone();
        if ( phone == null ) {
            return null;
        }
        return phone;
    }

    protected PaymentDto paymentToPaymentDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setPaymentId( payment.getPaymentId() );
        paymentDto.setAmount( payment.getAmount() );
        paymentDto.setPaymentDate( payment.getPaymentDate() );

        return paymentDto;
    }

    protected Set<PaymentDto> paymentSetToPaymentDtoSet(Set<Payment> set) {
        if ( set == null ) {
            return null;
        }

        Set<PaymentDto> set1 = new LinkedHashSet<PaymentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Payment payment : set ) {
            set1.add( paymentToPaymentDto( payment ) );
        }

        return set1;
    }

    protected Set<RentDto> rentalSetToRentDtoSet(Set<Rental> set) {
        if ( set == null ) {
            return null;
        }

        Set<RentDto> set1 = new LinkedHashSet<RentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Rental rental : set ) {
            set1.add( rentalMapper.toDto( rental ) );
        }

        return set1;
    }

    protected void stuffDtoToStore1(StuffDto stuffDto, Store mappingTarget) {
        if ( stuffDto == null ) {
            return;
        }

        if ( stuffDto.getStoreId() != null ) {
            mappingTarget.setStoreId( stuffDto.getStoreId() );
        }
    }

    protected void stuffDtoToCountry1(StuffDto stuffDto, Country mappingTarget) {
        if ( stuffDto == null ) {
            return;
        }

        if ( stuffDto.getCountry() != null ) {
            mappingTarget.setCountry( stuffDto.getCountry() );
        }
    }

    protected void stuffDtoToCity1(StuffDto stuffDto, City mappingTarget) {
        if ( stuffDto == null ) {
            return;
        }

        if ( mappingTarget.getCountry() == null ) {
            mappingTarget.setCountry( new Country() );
        }
        stuffDtoToCountry1( stuffDto, mappingTarget.getCountry() );
        if ( stuffDto.getCity() != null ) {
            mappingTarget.setCity( stuffDto.getCity() );
        }
    }

    protected void stuffDtoToAddress1(StuffDto stuffDto, Address mappingTarget) {
        if ( stuffDto == null ) {
            return;
        }

        if ( mappingTarget.getCity() == null ) {
            mappingTarget.setCity( new City() );
        }
        stuffDtoToCity1( stuffDto, mappingTarget.getCity() );
        if ( stuffDto.getAddress() != null ) {
            mappingTarget.setAddress( stuffDto.getAddress() );
        }
        if ( stuffDto.getDistrict() != null ) {
            mappingTarget.setDistrict( stuffDto.getDistrict() );
        }
        if ( stuffDto.getPostalCode() != null ) {
            mappingTarget.setPostalCode( stuffDto.getPostalCode() );
        }
        if ( stuffDto.getPhone() != null ) {
            mappingTarget.setPhone( stuffDto.getPhone() );
        }
    }
}
