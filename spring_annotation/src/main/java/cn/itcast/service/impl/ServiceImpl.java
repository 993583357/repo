package cn.itcast.service.impl;

import cn.itcast.dao.Dao;
import cn.itcast.dao.impl.DaoImpl;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceImpl")
public class ServiceImpl implements UserService {
    @Autowired
    @Qualifier("daoImpl")
    private Dao dao;

    public void checkUserPassWord(User user) {

        User columUser = dao.getColumUser();
        boolean equals = columUser.getUsername().equals(user.getUsername());
        System.out.println(equals);
    }

    public void selectAll(){
        List<User> users = dao.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
