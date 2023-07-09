package com.example.jpapaging.model;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Person {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")//this is the reference to the column name id
    private Address address;

    public Person(String firstName, String lastName, String phoneNumber, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}


