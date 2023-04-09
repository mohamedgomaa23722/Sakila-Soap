package com.iti.sakila.utils;

import com.iti.sakila.persistance.entity.Actor;

public class GenerateSelectStatement {

    public static String getSelectQuery(Class src) {
        return "From " + src.getName();
    }

    public static String getSelectNameQuery(Class src) {
        String query = "From ";
        if (src == Actor.class)
            query += "Actor a where a.firstName like ?1";
        return query;
    }
}
