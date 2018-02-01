package com.springInPractice.chapter2.service;

import com.springInPractice.chapter2.domain.Contact;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Service
public class JdbcContactServiceImpl implements ContactService {
    private static final String CREATE_SQL =
            "insert into contact (id,last_name, first_name, middle_initial, email) values ( :id,:lastName, :firstName, :mi, :email)";
    private static final String FIND_ALL_SQL =
            "select id, last_name, first_name, middle_initial, email from contact";
    private static final String DELETE_SQL =
            "delete from contact where id = :id";

    @Inject private NamedParameterJdbcTemplate jdbcTemplate;

    private RowMapper rowMapper = new RowMapper<Contact>() {

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

    };

    @Override
    public void createContact(Contact contact) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("lastName",contact.getLastName())
                .addValue("firstName",contact.getFirstName())
                .addValue("mi",contact.getMiddleInitial())
                .addValue("email",contact.getEmail())
                .addValue("id",contact.getId());

        jdbcTemplate.update(CREATE_SQL,params);
    }

    @Override
    public List<Contact> getContacts() {
        return jdbcTemplate.query(FIND_ALL_SQL,new HashMap<String,Object>(),this.rowMapper);
    }

    @Override
    public List<Contact> getContactsByEmail(String email) {
        return null;
    }

    @Override
    public Contact getContact(Long id) {
        return null;
    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public void deleteContact(Long id) {
        this.jdbcTemplate.update(DELETE_SQL,new MapSqlParameterSource("id",id));
    }
}
