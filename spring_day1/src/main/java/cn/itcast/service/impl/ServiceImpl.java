package cn.itcast.service.impl;

import cn.itcast.dao.Dao;
import cn.itcast.dao.impl.DaoImpl;
import cn.itcast.domain.User;
import cn.itcast.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceImpl implements Service {
    public void checkUserPassWord(User user) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        Dao dao =(DaoImpl) ac.getBean("dao");
        User columUser = dao.getColumUser();
        boolean equals = columUser.getUsername().equals(user.getUsername());
        System.out.println(equals);
    }
}
