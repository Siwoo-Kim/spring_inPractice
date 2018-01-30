package com.springInPractice.chapter1.service;

import com.springInPractice.chapter1.dao.AccountDao;
import com.springInPractice.chapter1.domain.Account;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service @Getter
public class AccountServiceImpl implements AccountService {

    @Autowired @Qualifier("csvAccountDao")
    AccountDao accountDao;

    @Override
    public List<Account> findDeliquentAccounts() throws Exception {

        LocalDate _30DaysAgo = LocalDate.now().minusDays(30);

        return this.accountDao.findAll().stream()
                .filter(account -> account.getBalance().compareTo(BigDecimal.ZERO) < 0)
                .filter(account -> account.getLastPaidOn().compareTo(_30DaysAgo) <= 0)
                .collect(Collectors.toList());

    }
}
