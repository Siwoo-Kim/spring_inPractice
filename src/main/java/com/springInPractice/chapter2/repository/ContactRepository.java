package com.springInPractice.chapter2.repository;

import com.springInPractice.chapter2.domain.Contact;

import java.util.List;

public interface ContactRepository extends GenericRepository<Contact>{

    List<Contact> findByEmail(String email);

}
