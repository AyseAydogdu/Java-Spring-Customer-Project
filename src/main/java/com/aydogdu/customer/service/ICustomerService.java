package com.aydogdu.customer.service;

import com.aydogdu.customer.model.Customer;
import com.aydogdu.customer.model.CustomerDto;

import java.util.List;


/**
 * Created By: Ayse Aydogdu   -> javadoc comments
 */
public interface ICustomerService {

    public List<CustomerDto> findAllCustomers();

    public CustomerDto entityToDto(Customer customer);

    public Customer dtoToEntity(CustomerDto customerDto);

    public CustomerDto saveCustomer(CustomerDto customerDto);

    public CustomerDto findCustomerById(Long id);

    public void deleteCustomerById(Long id);

    public String deleteCustomerByName(String name);

    public void postConstructTrash();

   // public void scheduledTrash();

    public CustomerDto updateCustomer(CustomerDto customerDto, Long id);


}
