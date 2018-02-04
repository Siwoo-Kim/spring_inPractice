package com.springInPractice.chapter4.service;

import com.springInPractice.chapter4.domain.Account;
import org.springframework.validation.Errors;

public interface AccountService {

    boolean registerAccount(Account account, String password, Errors errors);
}
