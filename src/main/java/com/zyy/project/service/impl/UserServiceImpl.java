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
        userDao.insert(user);
        return "SUCCESS";
    }

    @Override
    public String updateUser(User user) {
        User userDaoOne = userDao.findById(user.getId());
        BeanUtil.copyProperties(user,userDaoOne);
        userDao.update(userDaoOne);
        return "SUCCESS";
    }

    @Override
    public User findUserById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAll();
    }

    @Override
    public List<User> findListByUser(User user, Integer pageNo, Integer pageSize) {
        return userDao.findAll(user, pageNo, pageSize);
    }

    @Override
    public Long findUserCount(User user) {
        return userDao.cont(user);
    }

    @Override
    public void deleteUserById(String id) {
        userDao.delete(id);
    }
}
