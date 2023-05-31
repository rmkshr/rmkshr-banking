package com.scb.banking.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MysqlDatabaseConfig {

    @Configuration
    public class DataSourceConfig {
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

}
