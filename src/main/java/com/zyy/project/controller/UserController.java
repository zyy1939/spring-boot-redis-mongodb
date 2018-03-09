package com.zyy.project.controller;

import com.alibaba.fastjson.JSON;
import com.zyy.project.entity.User;
import com.zyy.project.service.UserService;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoyangyang on 2018/3/2.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser")
    public String addUser() {
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setAddr("北京市 朝阳区 建国门大厦 308号");
        user.setEmail("zhangsan@163.com");
        user.setMobile("18966668888");
        user.setGmtCreate(new Date());
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/findAllUser")
    public String findAllUser() {
        List<User> allUser = userService.findAllUser();
        return JSON.toJSONString(allUser);
    }

    @RequestMapping(value = "/findUserById")
    public String findUserById(String id) {
        long timeMillis = System.currentTimeMillis();
        User userDO = userService.findUserById(id);
        System.out.println("mongodb get user time : " + (System.currentTimeMillis() - timeMillis));
        return JSON.toJSONString(userDO);
    }

    @RequestMapping(value = "/findListByPage")
    public String findListByPage(User user, Integer pageNo, Integer pageSize) {
        Map<String, Object> result = Maps.newHashMap(null, null);
        List<User> listByUser = userService.findListByUser(user, pageNo, pageSize);
        Long userCount = userService.findUserCount(user);
        result.put("data", listByUser);
        result.put("total", userCount);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/updateUser")
    public String updateUser(User user) {
        return userService.updateUser(user);
    }


    @RequestMapping(value = "/deleteById")
    public String findUserList(String id) {
        userService.deleteUserById(id);
        return "SUCCESS";
    }


}
