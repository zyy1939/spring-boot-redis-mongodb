package com.zyy.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by zhaoyangyang on 2018/3/1.
 */
@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/")
    public String index() {
        return "hello";
    }

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

//    @Test
//    public void testObj() throws Exception {
//        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
//        ValueOperations<String, User> operations=redisTemplate.opsForValue();
//        operations.set("com.neox", user);
//        operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        //redisTemplate.delete("com.neo.f");
//        boolean exists=redisTemplate.hasKey("com.neo.f");
//        if(exists){
//            System.out.println("exists is true");
//        }else{
//            System.out.println("exists is false");
//        }
//        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//    }

}
