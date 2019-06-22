package com.itcast.controller;

import com.itcast.domain.TbUser;
import com.itcast.model.Result;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result login(TbUser user, HttpSession session){

        try{

            boolean login = userService.login(user);
            if (login){

                session.setAttribute("user",user);
                return new Result(true,"登录成功");
            }else {
                return new Result(false,"登陆失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,e.getMessage());

        }





    }
}
