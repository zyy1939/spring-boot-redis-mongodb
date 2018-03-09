package com.zyy.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaoyangyang on 2018/3/6.
 */
@Controller
public class IndexController {
    @RequestMapping("/index.html")
    public String index(){
        return "front/landing";
    }

    @RequestMapping("/")
    public String index001(){
        return "front/landing";
    }
}
