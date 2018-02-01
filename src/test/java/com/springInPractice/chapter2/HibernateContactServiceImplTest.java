package com.springInPractice.chapter2;

import com.springInPractice.chapter2.domain.Contact;
import com.springInPractice.chapter2.service.ContactService;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/chapter2/hibernateContext.xml")
public class HibernateContactServiceImplTest {

    @Autowired
    ContactService contactService;

    @Test
    public void test(){

        assertNotNull(contactService);

        contactService.createContact(
                Contact.builder()
                .lastName("lastName1")
                .firstName("firstName1")
                .email("email1")
                .middleInitial("M")
                .build()
        );

        contactService.getContacts().stream().map(Contact::toString).forEach(log::warning);
    }
}
