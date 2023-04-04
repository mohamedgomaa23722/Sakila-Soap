package com.iti.sakila.persistance.dao;

import com.iti.sakila.Entity.Actor;
import com.iti.sakila.Entity.Film;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface FilmDao {
    List<Film> findByCategoryId(int categoryId);

    List<Film> findByRate(BigDecimal rating);

    List<Film> findByCost(BigDecimal price);
}
