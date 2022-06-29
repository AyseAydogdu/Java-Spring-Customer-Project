package com.aydogdu.customer.controller;

import com.aydogdu.customer.model.CustomerDto;
import com.aydogdu.customer.service.impl.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By: Ayse Aydogdu
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    //  FIND ALL CUSTOMER
    //http://localhost:8080/customer
    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAllCustomers() {

        return ResponseEntity.ok(customerService.findAllCustomers());

    }

    //  FIND ONE CUSTOMER BY ID
    //http://localhost:8080/customer/id
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findCustomerById(id));

    }

    //  SAVE CUSTOMER
    //http://localhost:8080/customer
    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {

        return ResponseEntity.ok(customerService.saveCustomer(customerDto));
    }

    //http://localhost:8080/customer/id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {

         customerService.deleteCustomerById(id);
         return ResponseEntity.ok("");
       // return customerService.deleteCustomerById(id);
    }

    //http://localhost:8080/customer/delete/name
    @DeleteMapping("/delete/{name}")
    public ResponseEntity< String> deleteCustomerById(@PathVariable String name) {
      return ResponseEntity.ok( customerService.deleteCustomerByName(name));
    }

    //http://localhost:8080/customer/update/id
    @PutMapping("update/{id}")
    public ResponseEntity< CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable Long id) {

        return ResponseEntity.ok(customerService.updateCustomer(customerDto, id));
    }


}
