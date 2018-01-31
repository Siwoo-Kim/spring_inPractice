package com.springInPractice.chapter1.domain;

import lombok.ToString;

@ToString
public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
