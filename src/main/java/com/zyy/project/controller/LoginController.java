package com.zyy.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaoyangyang on 2018/3/9.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/admin/login.html")
    public String login(){
        return "admin/login";
    }

    @RequestMapping(value = "/admin/index.html")
    public String adminLogin(){
        return "admin/index";
    }
}
