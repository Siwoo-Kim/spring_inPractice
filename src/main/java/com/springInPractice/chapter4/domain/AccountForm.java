package com.springInPractice.chapter4.domain;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Transient;

@Getter @Setter @Builder @ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE) @AllArgsConstructor
public class AccountForm {
    private String username;
    private String password;
    @Transient
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String email;
    @Builder.Default
    private boolean marketingOk = true;
    @Builder.Default
    private boolean acceptTerms = false;


/*
    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("username",username)
                .append("firstName",firstName)
                .append("lastName",lastName)
                .append("email",email)
                .append("marketingOk",marketingOk)
                .append("acceptTerms",acceptTerms)
                .toString();
    }
*/

}
