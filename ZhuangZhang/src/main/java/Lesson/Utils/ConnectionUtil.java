package Lesson.Utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public static Connection getTreadConnection() {

        //if (threadLocal == null){
        if (threadLocal.get() == null){
            try {
                Connection c = DruidUtil.getConnection();
                threadLocal.set(c);
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
        Connection connection = threadLocal.get();


        return connection;
    }

    public static void closeConnection() {
        threadLocal.remove();
    }


}
