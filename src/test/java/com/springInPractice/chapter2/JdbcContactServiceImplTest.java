package com.springInPractice.chapter2;

import com.springInPractice.chapter2.domain.Contact;
import com.springInPractice.chapter2.service.ContactService;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/chapter2/jdbcContext.xml")
public class JdbcContactServiceImplTest {

    @Autowired
    ContactService contactService;

    @Test
    public void create(){

        this.contactService.deleteContact(1L);

        Contact contact = Contact
                .builder()
                .id(1L)
                .email("email@email.com")
                .firstName("firstName1")
                .lastName("lastName1").build();

        this.contactService.createContact(contact);

        this.contactService.getContacts().stream()
                .forEach(foundContact -> {
                    log.warning(foundContact::toString);
                });

        assertThat(this.contactService.getContacts().size(),is(1));
    }
}
