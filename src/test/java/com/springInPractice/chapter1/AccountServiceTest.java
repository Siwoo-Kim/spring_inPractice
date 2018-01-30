package com.springInPractice.chapter1;

import com.springInPractice.chapter1.domain.Account;
import com.springInPractice.chapter1.service.AccountService;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Test
    public void find() throws Exception {

        this.accountService.findDeliquentAccounts().stream()
                .map(Account::toString).forEach(log::warning);

        this.accountService.findDeliquentAccounts().stream()
                .forEach(account -> {
                    assertThat(account.getLastPaidOn().compareTo(LocalDate.now().minusDays(30)) < 0, is(true));
                    assertThat(account.getBalance().compareTo(new BigDecimal(0)) ,is(true));
                });

    }
}
