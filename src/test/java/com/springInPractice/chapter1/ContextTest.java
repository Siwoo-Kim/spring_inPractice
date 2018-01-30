package com.springInPractice.chapter1;

import com.springInPractice.chapter1.dao.JdbcAccountDao;
import com.springInPractice.chapter1.service.AccountService;
import com.springInPractice.chapter1.service.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class ContextTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void datasource(){

        assertNotNull(this.dataSource);

    }

    @Autowired
    AccountService accountService;

    @Test
    public void accountService(){

        assertNotNull(accountService);
        assertNotNull( ((AccountServiceImpl)accountService).getAccountDao() ) ;
        assertNotNull( ((JdbcAccountDao)((AccountServiceImpl)accountService).getAccountDao()).getDataSource() ) ;

    }
}
