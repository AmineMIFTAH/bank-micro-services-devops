package com.amine.accountservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
