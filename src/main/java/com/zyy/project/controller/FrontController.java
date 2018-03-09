package com.zyy.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaoyangyang on 2018/3/9.
 */
@Controller
@RequestMapping(value = "/front")
public class FrontController {
    @RequestMapping(value = "/landing.html")
    public String landing(Model model){
        model.addAttribute("name","ni hao");
        return "/front/landing";
    }

}
