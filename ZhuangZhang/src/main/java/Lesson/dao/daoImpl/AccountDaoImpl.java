package Lesson.dao.daoImpl;

import Lesson.Utils.ConnectionUtil;
import Lesson.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;


import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao{
    private QueryRunner queryRunner = new QueryRunner();
    public void setAccount(int id,int money) throws SQLException {
        String sql = "update account set account = account - ? where id = ?";
        queryRunner.update(ConnectionUtil.getTreadConnection(),sql,money,id);

    }

    public void setAccountAdd(int id, int money) throws SQLException {
        String sql = "update account set account = account + ? where id = ?";
        queryRunner.update(ConnectionUtil.getTreadConnection(),sql,money,id);

    }

}
