package com.itcast.controller;

import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String username,String password){
        System.out.println("hello springmvc");
        System.out.println(username + password);
        return "success";

    }
    @RequestMapping("/userGet")
    public String userGet(User user){

        System.out.println(user);

        return "success";
    }
}
