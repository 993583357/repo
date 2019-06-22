package Lesson.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtil {
    private static DataSource ds;

    static {
        InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //获取连接池
    public static DataSource getDataSource() {
        return ds;
    }
    //获取连接对象
    public static Connection getConnection() throws SQLException {

        Connection c = ds.getConnection();
        return c ;

    }

}
