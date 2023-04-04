package com.iti.sakila.persistance.repository;

import com.iti.sakila.Entity.Actor;

public class ActorRepository extends BaseRepository<Actor> {
    public ActorRepository() {
        super(Actor.class);
    }
}
