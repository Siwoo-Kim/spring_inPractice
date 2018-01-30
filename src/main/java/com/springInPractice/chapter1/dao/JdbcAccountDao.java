package com.springInPractice.chapter1.dao;

import com.springInPractice.chapter1.domain.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository @Getter @Setter
public class JdbcAccountDao implements AccountDao {

    DataSource dataSource;

    @Override
    public List<Account> findAll() throws Exception {
        return null;
    }
}
