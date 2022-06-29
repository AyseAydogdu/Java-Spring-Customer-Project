package com.aydogdu.customer.repository;

import com.aydogdu.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    boolean deleteByName(String name);

}
