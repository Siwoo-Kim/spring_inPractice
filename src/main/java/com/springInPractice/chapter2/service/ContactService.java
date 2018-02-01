package com.springInPractice.chapter2.service;

import com.springInPractice.chapter2.domain.Contact;

import java.util.List;

public interface ContactService {

    void createContact(Contact contact);
    List<Contact> getContacts();
    List<Contact> getContactsByEmail(String email);
    Contact getContact(Long id);
    void updateContact(Contact contact);
    void deleteContact(Long id);

}
