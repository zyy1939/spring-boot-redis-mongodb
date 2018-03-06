package com.zyy.project.dao.impl;

import com.zyy.project.dao.UserDao;
import com.zyy.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by zhaoyangyang on 2018/3/2.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> findAll(User user, int pageNo, int pageSize) {
        Query query = new Query();
        this.queryParamInstall(user, query);
        query.limit(pageSize).skip((pageNo - 1) * pageSize);
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "age")));
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public Long cont(User user) {
        Query query = new Query();
        this.queryParamInstall(user, query);
        return mongoTemplate.count(query, User.class);
    }

    private void queryParamInstall(User user, Query query) {
        if (!StringUtils.isEmpty(user.getName())) {
            query.addCriteria(Criteria.where("name").is(user.getName()));
        }
        if (null != user.getAge() && user.getAge() > 0) {
            query.addCriteria(Criteria.where("age").is(user.getAge()));
        }
        if (!StringUtils.isEmpty(user.getId())) {
            query.addCriteria(Criteria.where("id").is(user.getId()));
        }
    }

}
