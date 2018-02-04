package com.springInPractice.chapter1;

import com.springInPractice.chapter1.domain.Person;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/chapter1/exclude/applicationContext.xml")
public class CNamespaceTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void c_Namespace(){

        Person person1 = applicationContext.getBean("siwoo",Person.class);
        Person person2 = applicationContext.getBean("iu",Person.class);

        log.warning(person1::toString);
        log.warning(person2::toString);

    }
}
