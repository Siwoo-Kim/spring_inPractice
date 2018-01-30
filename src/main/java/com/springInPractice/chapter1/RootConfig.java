package com.springInPractice.chapter1;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan("com.springInPractice.chapter1")
public class RootConfig {


    @Bean
    DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("java");
        dataSource.setPassword("java");
        dataSource.setURL("jdbc:oracle:thin://localhost:1521/orcl");
        return dataSource;
    }

    @Bean
    Resource csvResource(){
        Resource resource = new ClassPathResource("chapter1/accounts.csv");
        return resource;
    }



}
