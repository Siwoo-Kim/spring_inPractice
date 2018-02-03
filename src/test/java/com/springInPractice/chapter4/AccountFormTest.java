package com.springInPractice.chapter4;


import com.springInPractice.chapter4.domain.AccountForm;
import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class AccountFormTest {

    @Test
    public void initiate(){

        AccountForm accountForm = AccountForm.builder()
                .firstName("first1")
                .lastName("last1")
                .email("email")
                .build();

        System.out.println(accountForm);
    }
}
