package cn.itcast.dao.impl;

import cn.itcast.config.AnnotationConfig;
import cn.itcast.dao.Dao;
import cn.itcast.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("daoImpl")
public class DaoImpl implements Dao {

    @Autowired
    private QueryRunner runner;
    public User getColumUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        User user = (User) ac.getBean("user");
        return user;
    }

    public List<User> selectAll() {
        String sql = "select * from user";
        try {
            List<User> query = runner.query(sql, new BeanListHandler<User>(User.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
