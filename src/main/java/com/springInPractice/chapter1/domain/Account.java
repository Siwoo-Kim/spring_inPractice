package com.springInPractice.chapter1.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class Account {

    private String accountNo;
    private BigDecimal balance;
    private LocalDate lastPaidOn;


}
