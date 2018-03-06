package com.zyy.project.dao;

import com.zyy.project.entity.User;

import java.util.List;

/**
 * Created by zhaoyangyang on 2018/3/2.
 */
public interface UserDao extends BaseDao<User> {
    /**
     * 搜索列表
     */
    List<User> findAll(User user, int pageNo, int pageSize);

    /**
     * 搜索列表总数量
     */
    Long cont(User user);
}
