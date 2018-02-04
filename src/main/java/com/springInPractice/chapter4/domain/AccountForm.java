package com.springInPractice.chapter4.domain;

import lombok.*;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class AccountForm {
    @NotNull
    @Size(min=1,max = 50)
    private String username;
    @NotNull
    @Size(min=4,max = 50)
    private String password;
    @NotNull
    @Size(min=4,max = 50)
    private String confirmPassword;
    private String firstName;
    private String lastName;
    @NotNull
    @Size(min=3,max = 50)
    private String email;
    @Builder.Default
    private boolean marketingOk = true;
    @AssertTrue(message = "{account.acceptTerms.assertTrue.message}")
    @Builder.Default
    private boolean acceptTerms = false;
    @Builder.Default
    private boolean isActivated = false;


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
