package com.atguigu.gmall.pms.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

   /* @Bean
    //@Primary //主要
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariDataSource hikariDataSource(@Value("${spring.datasource.url}") String jdbcUrl) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(jdbcUrl);
        return hikariDataSource;
    }

    @Primary
    @Bean("dataSource")
    public DataSource dataSource(HikariDataSource hikariDataSource) {
        return new DataSourceProxy(hikariDataSource);
    }*/

    @Primary
    @Bean("dataSource")
    public DataSource dataSource(@Value("${spring.datasource.url}")String url,
                                 @Value("${spring.datasource.username}")String username,
                                 @Value("${spring.datasource.password}")String password,
                                 @Value("${spring.datasource.driver-class-name}")String driverClassName) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driverClassName);
        return new DataSourceProxy(hikariDataSource);
    }
}
