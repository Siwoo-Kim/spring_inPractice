package com.springInPractice.chapter1;

import com.springInPractice.chapter1.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/chapter1/exclude/autoContext.xml")
public class ComponentScanContext {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void componentScan(){

        AccountService accountService = this.applicationContext.getBean(AccountService.class);

    }
}
