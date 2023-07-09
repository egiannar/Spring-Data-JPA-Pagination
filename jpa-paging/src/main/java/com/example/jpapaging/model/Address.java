package com.example.jpapaging.model;

import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {

    @Id
    @GeneratedValue
    private Integer id;
    private String address;
    private String city;
    private String state;
    private String zip;

    public Address(String address, String city, String state, String zip) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
