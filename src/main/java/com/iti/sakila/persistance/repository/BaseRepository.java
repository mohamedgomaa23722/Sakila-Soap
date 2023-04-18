package com.iti.sakila.persistance.repository;

import com.iti.sakila.bussiness.exceptions.NotExistException;
import com.iti.sakila.persistance.Database;
import com.iti.sakila.persistance.dao.BaseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class BaseRepository<T> implements BaseDao<T> {
    private final Class<T> src;

    public BaseRepository(Class<T> src) {
        this.src = src;
    }

    public List<T> getAll(int page, EntityManager entityManager) {
        return entityManager
                .createQuery("From " + src.getName(), src)
                .setFirstResult((page - 1) * 10)
                .setMaxResults(10)
                .getResultList();
    }

    public boolean update(T entity, int id, EntityManager entityManager) {
        if (findById(id, entityManager) != null) {
             entityManager.merge(entity);
            return true;
        }
        return false;
    }

    public boolean delete(int id, EntityManager entityManager) {
        T entity = findById(id, entityManager);
        System.out.println(entity);
            if (entityManager.contains(entity)) {
                entityManager.remove(entity);
                System.out.println("contains actor");
            } else {
                System.out.println("not contain actor");
                entityManager.remove(entityManager.merge(entity));
            }
            return true;
    }

    public T findById(int id, EntityManager entityManager) {
            try {
                return entityManager.find(src, id);
            } catch (Exception ex) {
                throw new NotExistException(src.getSimpleName() + " id is not exist into our database");
            }
    }

    @Override
    public T insert(T entity, EntityManager entityManager) {
        try {
            return  entityManager.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T isExist(String name, String fieldName, EntityManager entityManager) {
            try {
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<T> criteriaBuilderQuery = criteriaBuilder.createQuery(src);
                Root<T> root = criteriaBuilderQuery.from(src);
                criteriaBuilderQuery.where(criteriaBuilder.equal(root.get(fieldName), name));
                return entityManager.createQuery(criteriaBuilderQuery)
                        .getSingleResult();
            } catch (Exception ex) {
                return null;
            }
    }

    @Override
    public List<T> findByName(String name, String fieldName, int page, EntityManager entityManager) {
            try {
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery<T> criteriaBuilderQuery = criteriaBuilder.createQuery(src);
                Root<T> root = criteriaBuilderQuery.from(src);
                criteriaBuilderQuery.where(criteriaBuilder.like(root.get(fieldName), name + "%"));
                return entityManager.createQuery(criteriaBuilderQuery)
                        .getResultList();
            } catch (Exception ex) {
                throw new NotExistException("There are no results with name \"" + name + "\" into our database");
            }
    }
}
