package com.springInPractice.chapter2.service;

import com.springInPractice.chapter2.domain.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service @Transactional
public class HibernateContactServiceImpl implements ContactService {
    @Inject private SessionFactory sessionFactory;

    @Override
    public void createContact(Contact contact) {
        getSession().save(contact);
    }

    @Override
    public List<Contact> getContacts() {
        return getSession().createQuery("select c from Contact c").list();
    }

    @Override
    public List<Contact> getContactsByEmail(String email) {
        return getSession()
                .getNamedQuery("findContactsByEmail")
                .setString("email","%"+email+"%")
                .list();
    }

    @Override
    public Contact getContact(Long id) {
        return getSession().get(Contact.class,id);
    }

    @Override
    public void updateContact(Contact contact) {
        getSession().update(contact);
    }

    @Override
    public void deleteContact(Long id) {
        getSession().delete(getContact(id));
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
