package cn.itcast.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

public class JdbcConfig {

    @Value("${driver}")
    private String driver;

    @Value("${url}")
    private String url;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;


    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createRunner(@Qualifier("ds") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "ds")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setPassword(password);
            ds.setUser(user);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
