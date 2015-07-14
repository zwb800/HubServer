package com.hubserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index()
    {
        return "index1.jsp";
    }

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public User getUser()
    {
        User user = new User();
        user.setName("Name");
        return user;
    }
}

