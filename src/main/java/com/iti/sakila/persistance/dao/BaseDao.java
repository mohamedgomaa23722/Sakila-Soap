package com.iti.sakila.persistance.dao;

import com.iti.sakila.Entity.Film;

import java.util.List;

public interface BaseDao<T> {
    List<T> getAll();
    boolean update(T entity);
    boolean delete(int id);
    T findById(int id);
    boolean insert(T entity);
    boolean isExist();

    List<T> findByName(String name);
}
