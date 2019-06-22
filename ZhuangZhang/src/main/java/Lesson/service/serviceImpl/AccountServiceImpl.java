package Lesson.service.serviceImpl;

import Lesson.dao.AccountDao;
import Lesson.dao.daoImpl.AccountDaoImpl;
import Lesson.service.AccountService;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao = new AccountDaoImpl();

    public void setAccount(int id,int id1, int money) {
        try {
            accountDao.setAccount(id,money);
            //添加异常
            int a = 1/0;
            accountDao.setAccountAdd(id1,money);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
