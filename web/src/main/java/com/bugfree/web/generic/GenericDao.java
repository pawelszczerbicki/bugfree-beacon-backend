package com.bugfree.web.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public abstract class GenericDao<T> {

    @Autowired
    protected MongoTemplate mongo;

    protected Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T save(T entity) {
        mongo.save(entity);
        return entity;
    }

    public Optional<T> findOne(String id) {
        return ofNullable(mongo.findOne(query(where("id").is(id)), clazz));
    }

    public List<T> find(Pageable pageable) {
        return mongo.find(new Query().with(pageable), clazz);
    }

    public List<T> findAll() {
        return mongo.findAll(clazz);
    }

    public void delete(String id) {
        mongo.remove(query(where("id").is(id)), clazz);
    }
}
