package com.aydogdu.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerDto {

    Long id;

    String name;

    String surName;

    int age;


}
