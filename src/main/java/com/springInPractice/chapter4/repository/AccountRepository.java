package com.springInPractice.chapter4.repository;

import com.springInPractice.chapter2.repository.GenericRepository;
import com.springInPractice.chapter4.domain.Account;

public interface AccountRepository extends GenericRepository<Account> {

    void create(Account account,String password);
    Account findByUsername(String username);

}
