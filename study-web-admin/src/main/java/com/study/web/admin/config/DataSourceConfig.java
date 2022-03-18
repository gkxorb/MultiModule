package com.study.web.admin.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("H2DataSource")
    @ConfigurationProperties("spring.datasources.hikari.h2")
    public DataSource h2Datasource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


}
