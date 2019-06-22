package Lesson.config;

import Lesson.dao.AccountDao;
import Lesson.dao.daoImpl.AccountDaoImpl;

import java.sql.SQLException;

public class Demo {
    //有两个人，id1 zhangsan

    //id2 lisi
    AccountDao  accountDao = new AccountDaoImpl();
    //模拟转账
    public void setAccount(int id,int money) {

        //张三借给李四 8000 块钱

        try {
            accountDao.setAccount(id,money);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //李四收到  8000块钱




    }
    public void setAccountAdd(int id,int money) {
        try {
            accountDao.setAccountAdd(id,money);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
