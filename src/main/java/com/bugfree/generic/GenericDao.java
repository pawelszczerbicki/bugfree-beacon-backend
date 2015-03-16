package com.bugfree.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public abstract class GenericDao<T> {

    @Autowired
    protected MongoTemplate mongo;

    protected Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity) {
        mongo.save(entity);
    }

    public T findOne(String id) {
        return mongo.findOne(Query.query(Criteria.where("id").is(id)), clazz);
    }

    public List<T> find(Pageable pageable) {
        return mongo.find(new Query().with(pageable), clazz);
    }

    public List<T> findAll(){
        return mongo.findAll(clazz);
    }
}
