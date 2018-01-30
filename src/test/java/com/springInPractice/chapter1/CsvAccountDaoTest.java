package com.springInPractice.chapter1;

import com.springInPractice.chapter1.dao.AccountDao;
import com.springInPractice.chapter1.domain.Account;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class CsvAccountDaoTest {

    @Autowired @Qualifier("csvAccountDao")
    AccountDao accountDao;

    @Test
    public void findAll() throws Exception {

        accountDao.findAll().stream().map(Account::toString)
                .forEach(log::warning);

        assertThat( accountDao.findAll().size() , is(3) );
    }
}
