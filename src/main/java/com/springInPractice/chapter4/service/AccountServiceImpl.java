package com.springInPractice.chapter4.service;

import com.springInPractice.chapter4.domain.Account;
import com.springInPractice.chapter4.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import javax.inject.Inject;

@Service @Transactional(readOnly = true)    //Class Level Transactional will be good practice
public class AccountServiceImpl implements AccountService{

    @Inject private AccountRepository accountRepository;


    @Override @Transactional(readOnly = false)  //Override class level transaction
    public boolean registerAccount(Account account, String password, Errors errors) {

        valdiateUsername(account.getUsername(),errors);
        boolean valid = !errors.hasErrors();
        if(valid) { accountRepository.create(account,password); }   //whitelist validation
        return valid;
    }

    private void valdiateUsername(String username, Errors errors) {
        if(accountRepository.findByUsername(username) != null){
                //error code will be error.duplicate.[modelName].[property]
            errors.rejectValue("username","error.duplicate",new String[] { username },null); //third of the argument is for arguments for message
        }
    }
}
