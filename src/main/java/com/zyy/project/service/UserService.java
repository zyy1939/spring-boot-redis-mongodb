package com.zyy.project.service;

import com.zyy.project.entity.User;

import java.util.List;

/**
 * Created by zhaoyangyang on 2018/3/2.
 */
public interface UserService {

    String saveUser(User user);

    String updateUser(User user);

    User findUserById(String id);

    List<User> findAllUser();

    List<User> findListByUser(User user, Integer pageNo, Integer pageSize);

    Long findUserCount(User user);

    void deleteUserById(String id);

}
