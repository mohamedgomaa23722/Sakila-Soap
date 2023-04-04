package com.iti.sakila.persistance.repository;

import com.iti.sakila.Entity.Film;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.dao.BaseDao;
import com.iti.sakila.persistance.dao.FilmDao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class FilmRepository extends BaseRepository<Film> implements FilmDao {

    public FilmRepository() {
        super(Film.class);
    }

    public List<Film> findByCategoryId(int categoryId) {
        String query = "Select f From Film f, FilmCategory fc where f.filmId = fc.id.filmId And fc.id.categoryId = ?1";
        return Database.doSingleParameterSelectQuery(query, categoryId, Film.class);
    }

    @Override
    public List<Film> findByRate(BigDecimal rating) {
        String query = "From Film f where f.rentalRate >= ?1";
        return Database.doSingleParameterSelectQuery(query, rating, Film.class);
    }

    @Override
    public List<Film> findByCost(BigDecimal price) {
        String query = "From Film f where f.replacementCost >= ?1";
        return Database.doSingleParameterSelectQuery(query, price, Film.class);
    }
}
