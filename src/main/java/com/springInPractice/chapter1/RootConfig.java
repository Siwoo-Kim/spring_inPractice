package com.springInPractice.chapter1;

import com.springInPractice.chapter1.dao.AccountDao;
import com.springInPractice.chapter1.dao.CsvAccountDao;
import com.springInPractice.chapter1.dao.JdbcAccountDao;
import com.springInPractice.chapter1.service.AccountService;
import com.springInPractice.chapter1.service.AccountServiceImpl;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
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

    @Bean
    AccountDao accountDao(){
        return new CsvAccountDao();
    }

    @Bean
    AccountService accountService(){
        AccountServiceImpl accountService = new AccountServiceImpl();
        return accountService;
    }



}
