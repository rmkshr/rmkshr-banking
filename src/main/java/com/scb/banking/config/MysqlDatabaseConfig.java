package com.scb.banking.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author ramkishore
 * This class contains the bean configurations for mysql database.
 */
@Configuration
public class MysqlDatabaseConfig {

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/srv")
                .username("root")
                .password("")
                .build();
    }

}
