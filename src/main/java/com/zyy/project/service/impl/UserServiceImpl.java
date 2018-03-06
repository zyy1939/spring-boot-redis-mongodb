package com.zyy.project.service.impl;

import com.zyy.project.dao.UserDao;
import com.zyy.project.entity.User;
import com.zyy.project.service.UserService;
import com.zyy.project.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaoyangyang on 2018/3/2.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String saveUser(User user) {
        Integer insert = userDao.insert(user);
        return insert.toString();
    }

    @Override
    public String updateUser(User user) {
        User queryUser=new User();
        queryUser.setId(user.getId());
        User userDaoOne = userDao.findOne(queryUser);
        BeanUtil.copyProperties(user,userDaoOne);
        Integer update = userDao.update(userDaoOne);
        return update.toString();
    }

    @Override
    public User findUser(User user) {
        return userDao.findOne(user);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAll();
    }

    @Override
    public List<User> findListByUser(User user) {
        return userDao.findAll(user);
    }

    @Override
    public List<User> findListByUser(User user, Integer pageNo, Integer pageSize) {
        return userDao.findAll(user, pageNo, pageSize);
    }

    @Override
    public Integer findUserCount(User user) {
        return userDao.cont(user).intValue();
    }

    @Override
    public String deleteUserById(String id) {
        return userDao.delete(id).toString();
    }
}
