package com.study.web.admin.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Bean("H2Properties")
    @ConfigurationProperties("spring.datasources.hikari.h2")
    public HikariConfigProperties h2DatasourceProperies() {
        return new HikariConfigProperties();
    }

    @Primary
    @Bean("H2DataSource")
    //@ConfigurationProperties("spring.datasources.hikari.h2")
    public DataSource h2Datasource(@Qualifier("H2Properties") HikariConfigProperties properties){

        // Hikari Datasource
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPoolName(properties.getPoolName());
        hikariConfig.setJdbcUrl(properties.getJdbcUrl());
        hikariConfig.setUsername(properties.getUsername());
        hikariConfig.setPassword(properties.getPassword());
        hikariConfig.setDriverClassName(properties.getDriverClassName());
        hikariConfig.setMinimumIdle(properties.getMaximumPoolSize());
        hikariConfig.setMaximumPoolSize(properties.getMaximumPoolSize());
        hikariConfig.addDataSourceProperty("sql-script-encoding", "utf-8");
        //hikariConfig.setValidationTimeout(properties.getValidationTimeout());
        //hikariConfig.setConnectionTimeout(3000);
        return new HikariDataSource(hikariConfig);

        /*
        // Spring Datasource
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
        */
    }

    @Primary
    @Bean("H2TransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("H2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean("MSSQLProperties")
    @ConfigurationProperties("spring.datasources.hikari.mssql")
    public HikariConfigProperties mssqlDatasourceProperies() {
        return new HikariConfigProperties();
    }

    @Bean("MsSQLDataSource")
    public DataSource mssqlDatasource(@Qualifier("MSSQLProperties") HikariConfigProperties properties){

        // Hikari Datasource
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPoolName(properties.getPoolName());
        hikariConfig.setJdbcUrl(properties.getJdbcUrl());
        hikariConfig.setUsername(properties.getUsername());
        hikariConfig.setPassword(properties.getPassword());
        hikariConfig.setDriverClassName(properties.getDriverClassName());
        hikariConfig.setMinimumIdle(properties.getMaximumPoolSize());
        hikariConfig.setMaximumPoolSize(properties.getMaximumPoolSize());
        hikariConfig.addDataSourceProperty("sql-script-encoding", "utf-8");
        //hikariConfig.setValidationTimeout(properties.getValidationTimeout());
        //hikariConfig.setConnectionTimeout(3000);
        return new HikariDataSource(hikariConfig);

        /*
        // Other Way
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
        */
    }

}
