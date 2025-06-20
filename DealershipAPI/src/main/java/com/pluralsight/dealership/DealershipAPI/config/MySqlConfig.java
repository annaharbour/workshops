package com.pluralsight.dealership.DealershipAPI.config;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class MySqlConfig {
    private BasicDataSource basicDataSource;
    @Bean
    public DataSource datasource(){
        return basicDataSource;
    }

    public MySqlConfig(@Value("${datasource.url}") String url,
                           @Value("${datasource.username}") String username,
                           @Value("${datasource.password}") String password
    ) {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
    }
}
