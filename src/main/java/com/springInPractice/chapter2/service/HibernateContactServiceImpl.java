package com.springInPractice.chapter2.service;

import com.springInPractice.chapter2.domain.Contact;
import com.springInPractice.chapter2.repository.ContactRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service @Transactional
public class HibernateContactServiceImpl implements ContactService {

    @Autowired @Qualifier("hibernateContactRepository")
    ContactRepository contactRepository;

    @Override
    public void createContact(Contact contact) {
        this.contactRepository.create(contact);
    }

    @Override
    public List<Contact> getContacts() {
        return this.contactRepository.getAll();
    }

    @Override
    public List<Contact> getContactsByEmail(String email) {
        return this.contactRepository.findByEmail(email);
    }

    @Override
    public Contact getContact(Long id) {
        return this.contactRepository.get(id);
    }

    @Override
    public void updateContact(Contact contact) {
        this.contactRepository.update(contact);
    }

    @Override
    public void deleteContact(Long id) {
        this.contactRepository.deleteById(id);
    }

}
