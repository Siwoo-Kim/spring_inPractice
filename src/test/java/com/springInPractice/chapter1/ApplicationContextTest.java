package com.springInPractice.chapter1;

import com.springInPractice.chapter1.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/chapter1/exclude/applicationContext.xml")
public class ApplicationContextTest {

    @Autowired
    AccountService accountService;

    @Test
    public void accountService(){

        assertNotNull(accountService);

    }
}
