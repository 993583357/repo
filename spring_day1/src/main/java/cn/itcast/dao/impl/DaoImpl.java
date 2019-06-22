package cn.itcast.dao.impl;

import cn.itcast.dao.Dao;
import cn.itcast.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoImpl implements Dao {
    public User getColumUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) ac.getBean("user");
        return user;
    }
}
