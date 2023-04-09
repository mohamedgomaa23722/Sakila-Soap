package com.iti.sakila.persistance.dao;

import java.util.List;

public interface BaseDao<T> {
    List<T> getAll(int page);
    boolean update(T entity);
    boolean delete(int id);
    T findById(int id);
    T insert(T entity);
    boolean isExist();
    List<T> findByName(String name, int page);
}
