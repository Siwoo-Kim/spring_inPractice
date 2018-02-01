package com.springInPractice.chapter2.service;

import com.springInPractice.chapter2.domain.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Contact.builder()
                .id(resultSet.getLong(1))
                .lastName(resultSet.getString(2))
                .firstName(resultSet.getString(3))
                .middleInitial(resultSet.getString(4))
                .email(resultSet.getString(5))
                .build();
    }
}
