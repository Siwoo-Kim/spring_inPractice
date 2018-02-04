package com.springInPractice.chapter4.repository;

import com.springInPractice.chapter2.repository.AbstractHibernateRepository;
import com.springInPractice.chapter4.domain.Account;
import org.hibernate.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class HbnAccountRepository extends AbstractHibernateRepository<Account> implements AccountRepository {

    private static final String UPDATE_PASSWORD_SQL = "update INPRAC_ACCOUNT set password = ? where username = ?";

    @Inject private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Account account, String password) {
        create(account);
        jdbcTemplate.update(
                UPDATE_PASSWORD_SQL,password,account.getUsername());

    }

    @Override
    public Account findByUsername(String username) {
        return (Account) getSession().getNamedQuery("findAccountByUsername")
                .setParameter("username",username)
                .uniqueResult();
    }
}
