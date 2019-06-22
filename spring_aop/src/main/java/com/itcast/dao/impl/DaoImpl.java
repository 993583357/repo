package com.itcast.dao.impl;

import com.itcast.dao.Dao;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository("dao")
public class DaoImpl implements Dao{
    @Autowired
    private QueryRunner queryRunner;

    public void setAccount(int put,  int money) {
        String sql = "update account set account = account + ? where id = ?";

        try {
            queryRunner.update(sql,money,put);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setAccountOut(int out,int money){
        String sql1 = "update account set account = account - ? where id = ?";
        try {
            queryRunner.update(sql1,money,out);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
