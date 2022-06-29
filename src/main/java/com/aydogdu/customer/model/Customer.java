package com.aydogdu.customer.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name="customer_table")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column(name = "customer_name")
    String name;

    @Column(name = "customer_surName")
    String surName;

    @Column(name = "customer_age")
    int age;

    @Transient
    int minAge;
    @Transient
    int maxAge;
}
