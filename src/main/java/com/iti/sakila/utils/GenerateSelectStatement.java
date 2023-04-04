package com.iti.sakila.utils;

import com.iti.sakila.Entity.Actor;

public class GenerateSelectStatement {

    public static String getSelectQuery(Class src) {
        String query = "From";
        if (src == Actor.class)
            query += " Actor";
        return query;
    }

    public static String getSelectNameQuery(Class src) {
        String query = "From ";
        if (src == Actor.class)
            query += "Actor a where a.firstName like ?1";
        return query;
    }
}
