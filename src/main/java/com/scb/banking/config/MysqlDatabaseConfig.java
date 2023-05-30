package com.scb.banking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MysqlDatabaseConfig {
    @Value("${spring.datasource.first.url}")
    private String url;
    @Value("${spring.datasource.first.username}")
    private String username;
    @Value("${spring.datasource.first.password}")
    private String password;

    @Bean(name = "mysqlConnection")
    public JdbcTemplate getDataConnection() {
//        String url = "jdbc:mysql://localhost:3306/srv";
//        String username = "root";
//        String password = "";

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

}
