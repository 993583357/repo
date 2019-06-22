package com.itcast.aop;

import com.itcast.utils.ConnectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
@Component("accountAop")
public class AccountAop {

    @Autowired
    private ConnectionUtils connectionUtils;


    public void before(){
        try {
            Connection c =  connectionUtils.getConnectionTo();
            c.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afterRunning(){
        try {
            Connection c =  connectionUtils.getConnectionTo();
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afterThrowing(){
        try {
            Connection c =  connectionUtils.getConnectionTo();
            c.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void after(){
        connectionUtils.removeConnection();
    }
}
