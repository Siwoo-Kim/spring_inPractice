package com.springInPractice.chapter1.dao;

import com.springInPractice.chapter1.domain.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAll() throws Exception;

}
