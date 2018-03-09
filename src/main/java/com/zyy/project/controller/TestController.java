package com.zyy.project.controller;

import com.alibaba.fastjson.JSON;
import com.zyy.project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoyangyang on 2018/3/1.
 */
@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/addName")
    public String addName() {
        redisTemplate.opsForValue().set("index_name", "Hi,this is faster redis demo,you are greet!哈哈哈，爽了吧");
        return "add success";
    }

    @RequestMapping(value = "/getName")
    public String getName() {
        Object indexName = redisTemplate.opsForValue().get("index_name");
        return indexName.toString();
    }

    @RequestMapping("/session")
    public String session(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    @RequestMapping("/testObject")
    public String main(String[] ags) throws Exception {
        String result = "";

        User user = new User();
        user.setId("1");
        user.setAge(27);
        user.setGmtCreate(new Date());
        user.setMobile("15122226666");
        user.setName("malilianmenglu");
        user.setEmail("gjoweho@163.com");
        user.setAddr("普吉岛 马尔代夫 吉隆坡");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("login_user", user);
        operations.set("login_user_001", user, 5, TimeUnit.SECONDS);
        User login_user_001 = operations.get("login_user_001");
        System.out.println("get : " + JSON.toJSONString(login_user_001));
        Thread.sleep(5000);
        Object login_user_002 = redisTemplate.opsForValue().get("login_user_001");
        System.out.println("sleep 5s after : " + JSON.toJSONString(login_user_002));
        operations.set("login_user_001", user, 5, TimeUnit.SECONDS);
        redisTemplate.delete("login_user_001");
        Object login_user_003 = redisTemplate.opsForValue().get("login_user_001");
        System.out.println("delete after : " + JSON.toJSONString(login_user_002));
        operations.set("login_user_001", user, 5, TimeUnit.SECONDS);
        long timeMillis = System.currentTimeMillis();
        Object login_user_004 = redisTemplate.opsForValue().get("login_user_001");
        System.out.println("redis get login_user_001 time : "+(System.currentTimeMillis()-timeMillis));
        System.out.println(JSON.toJSONString(login_user_004));
        result = JSON.toJSONString(login_user_004);
        return result;
    }

}
