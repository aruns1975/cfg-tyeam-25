package com.cfg.team25.socialtown.config;

import com.cfg.team25.socialtown.properties.DBProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
//@EnableConfigurationProperties(DBProperties.class)
@RequiredArgsConstructor
public class JdbcConfig {

    @NonNull private DBProperties dbProperties;

    @Bean
    public DataSource dataSource() {
        HikariConfig config=new HikariConfig();
        config.setPoolName(dbProperties.getPoolname());
        config.setDriverClassName(dbProperties.getDriverClassName());
        config.setJdbcUrl(dbProperties.getUrl());
        config.setUsername(dbProperties.getUserName());
        config.setPassword(dbProperties.getPassword());
        config.setMaximumPoolSize(10);

//        config.setPoolName("CFG-Team-25");
//        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
//        config.setUsername("root");
//        config.setPassword("test1234");
//        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
