package com.springInPractice.chapter1.service;

import com.springInPractice.chapter1.dao.AccountDao;
import com.springInPractice.chapter1.domain.Account;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {

    List<Account> findDeliquentAccounts() throws Exception;
}
