package com.demo.interviewdemo.jacksonToObjectDemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @description:
 * @author: jhyang
 * @create: 2019-08-14 18:20
 **/
@JsonIgnoreProperties(ignoreUnknown = false)
public class Name {

    @JsonIgnore
    private Integer id;
    private String firstName;
    private String lastName;

    public Name(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "[id=,firstName=,lastName=]";
    }
}
