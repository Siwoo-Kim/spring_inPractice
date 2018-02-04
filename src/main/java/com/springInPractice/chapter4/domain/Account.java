package com.springInPractice.chapter4.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NamedQuery(name="findAccountByUsername",
query = "select a from Account a where a.username = :username")
@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="INPRAC_ACCOUNT")
public class Account {

    @Id @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACCOUNT_SEQ_GENERATOR")
    @SequenceGenerator(name="ACCOUNT_SEQ_GENERATOR",
    sequenceName = "ACCOUNT_SEQUENCE",initialValue = 1,allocationSize = 1)
    private Long id;

    @NotNull
    @Size(min = 1,max = 5)
    private String username;

    private String firstName;

    private String lastName;

    @Column(insertable = false,updatable = false)
    private String password;

    private String email;

    @Builder.Default
    private boolean marketingOk = true;

    @Builder.Default
    private boolean acceptTerms = false;

    @Builder.Default
    private boolean activate = true;

    private static DateTimeFormatter dateCreatedFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    @Builder.Default
    private LocalDateTime dateCreated = LocalDateTime.now();

    @Transient //It might be useless , but for safety
    public String getFullName(){
        return firstName + " "+lastName;
    }
}
