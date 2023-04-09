package com.iti.sakila.persistance.repository;

import com.iti.sakila.persistance.entity.Actor;

public class ActorRepository extends BaseRepository<Actor> {
    public ActorRepository() {
        super(Actor.class);
    }
}
