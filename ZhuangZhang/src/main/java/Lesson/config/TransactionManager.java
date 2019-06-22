package Lesson.config;

import Lesson.Utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
    //开启事务
    public static void beginConnection() {
        try {
            ConnectionUtil.getTreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //提交事务
    public static void commitConnection() {
        try {
            ConnectionUtil.getTreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //回滚事务
    public static void rollBackConnection() {
        try {
            ConnectionUtil.getTreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //释放资源
    public static void closeConnection() {
        ConnectionUtil.closeConnection();
    }
}
