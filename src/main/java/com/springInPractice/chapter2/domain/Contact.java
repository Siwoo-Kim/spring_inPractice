package com.springInPractice.chapter2.domain;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter @Setter @ToString @Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE) @AllArgsConstructor
@Entity @Table(name = "contact")
@NamedQuery(name="findContactsByEmail",
            query = "select c from Contact c where c.email like :email")
public class Contact {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="CONTACT_SEQ_GENERATOR",
    sequenceName = "CONTACT_SEQ",initialValue = 1,allocationSize = 1)
    private Long id;

    @NotNull
    @Length(min=1,max=40)
    @Column(name="LAST_NAME")
    private String lastName;

    @NotNull
    @Length(min=1,max = 40)
    @Column(name="FIRST_NAME")
    private String firstName;


    @Length(max=1)
    @Column(name="MIDDLE_INITIAL")
    private String middleInitial;

    @Email
    private String email;

    @Transient
    public String getFullName(){
        String fullName = lastName + ", " + firstName;
        if( !(middleInitial == null || "".equals(middleInitial.trim()))){
            fullName += " "+middleInitial+".";
        }
        return fullName;
    }

}
