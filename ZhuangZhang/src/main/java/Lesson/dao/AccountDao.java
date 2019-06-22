package Lesson.dao;

import java.sql.SQLException;

public interface AccountDao {
    void setAccount(int id,int money) throws SQLException;

    void setAccountAdd(int id,int money) throws SQLException;
    /*
    * 1.转账的人
    * 2.接收的人
    * 3.转账的金额
    *
    *
    * */
}
