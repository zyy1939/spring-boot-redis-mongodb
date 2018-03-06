package com.zyy.project.dao.impl;

import com.zyy.project.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by zhaoyangyang on 2018/3/6.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Autowired
    private MongoTemplate mongoTemplate;

    private Class clazzP;

    public BaseDaoImpl() {
        //目的：得到实际类型参数
        //得到当前运行对象
        Class clazz = this.getClass();
        //得到当前对象父类的参数化类型,一般使用type子接口ParameterizedType
        Type type = clazz.getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType) type;
        //得到实际类型参数
        Type[] types = ptype.getActualTypeArguments();
        Class clazzParameter = (Class) types[0];
        this.clazzP = clazzParameter;
    }

    @Override
    public List<T> findAll() {
        return mongoTemplate.findAll(clazzP);
    }

    @Override
    public T findById(String id) {
        return (T) mongoTemplate.findById(id, clazzP);
    }

    @Override
    public void insert(T t) {
        mongoTemplate.insert(t);
    }

    @Override
    public void update(T t) {
        mongoTemplate.save(t);
    }

    @Override
    public void delete(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, clazzP);
    }

}
