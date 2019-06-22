package com.itcast.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
@Component
public class ConnectionUtils {
    @Autowired
    @Qualifier("dataSource")
    private  ComboPooledDataSource ds;

    private  ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    public  Connection getConnectionTo() throws SQLException {

        if (tl.get() == null){
            Connection c = ds.getConnection();
            tl.set(c);
        }
        return tl.get();
    }

    public  void removeConnection(){

        tl.remove();

    }
}
