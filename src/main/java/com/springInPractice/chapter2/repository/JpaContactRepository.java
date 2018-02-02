package com.springInPractice.chapter2.repository;

import com.springInPractice.chapter2.domain.Contact;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Repository
public class JpaContactRepository implements ContactRepository{
    @PersistenceContext
    EntityManager entityManager;



    @Override
    public List<Contact> findByEmail(String email) {
        return entityManager.createQuery(
                "select c from Contact c where c.email = :email ",Contact.class
        ).setParameter("email",email).getResultList();
    }


    @Override
    public void create(Contact contact) {
        entityManager.persist(contact);
    }

    @Override
    public Contact get(Serializable id) {
        return entityManager.find(Contact.class,id);
    }

    @Override
    public Contact load(Serializable id) {
        return entityManager.getReference(Contact.class,id);
    }

    @Override
    public List<Contact> getAll() {
        return entityManager.createQuery(
                "select c from Contact c",Contact.class
        ).getResultList();
    }

    @Override
    public void update(Contact contact) {
        entityManager.merge(contact);
    }

    @Override
    public void delete(Contact contact) {
        entityManager.remove(contact);
    }

    @Override
    public void deleteById(Serializable id) {
        entityManager.remove(load(id));
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery(
                "delete from Contact c"
        ).executeUpdate();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean exists(Serializable id) {
        return false;
    }
}
