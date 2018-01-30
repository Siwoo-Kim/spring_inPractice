package com.springInPractice.chapter1.dao;

import com.springInPractice.chapter1.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Repository @Qualifier("csvAccountDao")
public class CsvAccountDao implements AccountDao {

    @Autowired @Qualifier("csvResource")
    private Resource resource;

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMddyyyy");

    public List<Account> findAll() throws Exception {

        List<Account> results = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.resource.getFile()));

        String line;

        while((line = bufferedReader.readLine()) != null){

            String[] fields =  line.split(",");

            Account account = Account.builder()
                                    .accountNo(fields[0])
                                    .balance(new BigDecimal(fields[1]))
                                    .lastPaidOn(LocalDate.parse(fields[2],CsvAccountDao.dateTimeFormatter))
                                    .build();
            results.add(account);
        }

        bufferedReader.close();
        return results;
    }


}
