package com.study.web.admin.config;

import lombok.Data;

@Data
public class HikariConfigProperties {
    private String poolName="hikari-pool";
    private String jdbcUrl;
    private String username;
    private String password;
    private String driverClassName;
    private int minimumIdle = 1;
    private int maximumPoolSize = 10;
    private int validationTimeout = 5000;
}
