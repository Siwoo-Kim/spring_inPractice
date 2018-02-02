package com.springInPractice.chapter3.domain;


import lombok.*;

@Getter @Setter @ToString @Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE) @AllArgsConstructor
public class Member {
    private String firstName;
    private String lastName;

    public String getFullName(){
        return firstName+ " "+lastName;
    }

}
