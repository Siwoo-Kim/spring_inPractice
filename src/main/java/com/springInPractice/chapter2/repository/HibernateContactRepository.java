package com.springInPractice.chapter2.repository;

import com.springInPractice.chapter2.domain.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateContactRepository extends AbstractHibernateRepository<Contact> implements ContactRepository {

    @Override
    public List<Contact> findByEmail(String email) {
        return getSession()
                .getNamedQuery("findContactsByEmail")
                .setParameter("email","%"+email+"%").list();
    }

}
