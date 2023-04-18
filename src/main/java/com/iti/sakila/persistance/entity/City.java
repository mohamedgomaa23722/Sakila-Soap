package com.iti.sakila.persistance.entity;
// Generated Apr 1, 2023, 5:10:50 AM by Hibernate Tools 6.1.7.Final


import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * City generated by hbm2java
 */
@Entity
@Table(name = "city"
        , catalog = "sakila"
)
public class City implements java.io.Serializable {
    private Short cityId;
    private Country country;
    private String city;
    private Timestamp lastUpdate = new Timestamp(new Date().getTime());
    private Set<Address> addresses = new HashSet<Address>(0);

    public City() {
    }


    public City(Country country, String city, Timestamp lastUpdate) {
        this.country = country;
        this.city = city;
        this.lastUpdate = lastUpdate;
    }

    public City(Country country, String city, Timestamp lastUpdate, Set<Address> addresses) {
        this.country = country;
        this.city = city;
        this.lastUpdate = lastUpdate;
        this.addresses = addresses;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)


    @Column(name = "city_id", unique = true, nullable = false)
    public Short getCityId() {
        return this.cityId;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    @Column(name = "city", nullable = false, length = 50)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update", nullable = false, length = 19)
    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }


}


