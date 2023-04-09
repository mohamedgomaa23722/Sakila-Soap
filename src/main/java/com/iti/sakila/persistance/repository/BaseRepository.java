package com.iti.sakila.persistance.repository;

import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.dao.BaseDao;
import com.iti.sakila.utils.GenerateSelectStatement;

import java.util.List;

public class BaseRepository<T> implements BaseDao<T> {
    private final Class<T> src;

    public BaseRepository(Class<T> currentCalss) {
        this.src = currentCalss;
    }

    public List<T> getAll(int page) {
        return Database.doInTransaction(entityManager -> entityManager
                .createQuery(GenerateSelectStatement.getSelectQuery(src), src)
                .setFirstResult((page-1) * 10)
                .setMaxResults(10)
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
    public T insert(T entity) {
        try {
            return Database.doInTransaction(entityManager -> entityManager.merge(entity));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isExist() {
        return Database.doInTransaction(entityManager -> entityManager.find(src, 1) != null);
    }

    @Override
    public List<T> findByName(String name, int page) {
        return Database.doSingleParameterSelectQuery(GenerateSelectStatement.getSelectNameQuery(src),
                name + "%", src, page);
    }
}
