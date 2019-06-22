package com.itcast.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Component
public class JdbcUtils {

    @Autowired
    @Qualifier("dataSource")
    private static ComboPooledDataSource ds;


    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnectionTo(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
