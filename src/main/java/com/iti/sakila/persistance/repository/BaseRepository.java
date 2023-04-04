package com.iti.sakila.persistance.repository;

import com.iti.sakila.Entity.Film;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.dao.BaseDao;
import com.iti.sakila.utils.GenerateSelectStatement;

import java.util.List;

public class BaseRepository<T> implements BaseDao<T> {
    private final Class<T> src;

    public BaseRepository(Class<T> currentCalss) {
        this.src = currentCalss;
    }

    public List<T> getAll() {
        return Database.doInTransaction(entityManager -> entityManager
                .createQuery(GenerateSelectStatement.getSelectQuery(src), src)
                .getResultList());
    }

    public boolean update(T entity) {
        if (isExist()) {
            Database.doInTransactionWithoutResult(entityManager -> entityManager.merge(entity));
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        T entity = findById(id);
        System.out.println(entity);
        return Database.doInTransaction(entityManager -> {
            if (entityManager.contains(entity)) {
                entityManager.remove(entity);
                System.out.println("contains actor");
                return true;
            } else {
                System.out.println("not contain actor");
                entityManager.remove(entityManager.merge(entity));
                return true;
            }
        });
    }

    public T findById(int id) {
        return Database.doInTransaction(entityManager -> entityManager.find(src, id));
    }

    @Override
    public boolean insert(T entity) {
        try {
            Database.doInTransactionWithoutResult(entityManager -> entityManager.persist(entity));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isExist() {
        return Database.doInTransaction(entityManager -> entityManager.find(src, 1) != null);
    }

    @Override
    public List<T> findByName(String name) {
        return Database.doSingleParameterSelectQuery(GenerateSelectStatement.getSelectNameQuery(src),
                name + "%", src);
    }
}
