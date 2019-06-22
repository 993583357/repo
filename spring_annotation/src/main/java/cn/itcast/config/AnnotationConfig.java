package cn.itcast.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("cn.itcast")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcconfig.properties")
public class AnnotationConfig {





}
