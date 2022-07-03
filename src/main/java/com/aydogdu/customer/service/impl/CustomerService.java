package com.aydogdu.customer.service.impl;


import com.aydogdu.customer.exception.CustomerNotExistException;
import com.aydogdu.customer.model.Customer;
import com.aydogdu.customer.model.CustomerDto;
import com.aydogdu.customer.repository.CustomerRepository;
import com.aydogdu.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created By: Ayse Aydogdu   -> javadoc comments
 */

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    public List<CustomerDto> findAllCustomers() {

        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer : customerList) {
            customerDtos.add(entityToDto(customer));
        }

        return customerDtos;
    }


    public CustomerDto entityToDto(Customer customer) {

        return modelMapper.map(customer, CustomerDto.class);

    }


    public Customer dtoToEntity(CustomerDto customerDto) {

        return modelMapper.map(customerDto, Customer.class);

    }
    public  List<CustomerDto>entityListToDtoList(List<Customer> customers)
    {
        List<CustomerDto> customerDto =new ArrayList<>();

        for(int i=0; i<customers.size(); i++)
        {
            customerDto.add(entityToDto(customers.get(i)));

        }
        return customerDto;
    }
    public CustomerDto saveCustomer(CustomerDto customerDto) {

        return entityToDto(customerRepository.save(dtoToEntity(customerDto)));
    }

    public CustomerDto findCustomerById(Long id) {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        return optionalCustomer.map(this::entityToDto).orElse(null);
    }

    public void deleteCustomerById(Long id) {

        try {
            customerRepository.deleteById(id);
            // return "Deleted customer with id\t" + id;
        } catch (EmptyResultDataAccessException e) {
            log.error("Customer Service -> deleteCustomerById method failed (EmptyResultDataAccessException) !!!");
            throw new CustomerNotExistException("Customer not exits, please check situation.");
            //return ("Customer not exits");
        }
    }

    @Transactional
    public String deleteCustomerByName(String name) {
        try {
            customerRepository.deleteByName(name);
            return "Deleted with name:\t" + name;
        } catch (EmptyResultDataAccessException e) {
            return "Delete operation failed";
        }

    }


    @PostConstruct
    public void postConstructTrash() {
        log.error("POSTCONSTRUCT");

    }


//    @Scheduled(cron = "* * * * * *") // -> saniye, dk , saat, gün, ay, yıl
//    public void scheduledTrash() {
//        Customer customer;
//        for(long i = 0; i++<1000;) {
//            customer  = Customer
//                    .builder()
//                    .age(29)
//                    .name("ahmet")
//                    .surName("akan")
//                    .id(i)
//                    .build();
//            customerRepository.save(customer);}
//    }


    public CustomerDto updateCustomer(CustomerDto customerDto, Long id) {
        Optional<Customer>  optionalCustomer = customerRepository.findById(id);
        return (optionalCustomer.isPresent() ? entityToDto(customerRepository.save(dtoToEntity(customerDto))) : null);
    }
}
