package com.aydogdu.customer.services;

import com.aydogdu.customer.model.Customer;
import com.aydogdu.customer.model.CustomerDto;
import com.aydogdu.customer.repository.CustomerRepository;
import com.aydogdu.customer.service.impl.CustomerService;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author Ayse Aydogdu
 * @Date 7/2/2022 6:26 PM
 */
@SpringBootTest
public class CusomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomerTest()
    {
        CustomerDto expectedCustomerDto = CustomerDto.builder().id(3L).name("Ayse").surName("Aydogdu").age(23).build();
        CustomerDto actualCustomerDto= customerService.saveCustomer(expectedCustomerDto);
        assertEquals(expectedCustomerDto,actualCustomerDto);
    }

    @Test
    public void findAllCustomersTest()
    {
       List<CustomerDto> expectedCustomerDto = customerService.entityListToDtoList(customerRepository.findAll());
       List<CustomerDto> actualCustumers = customerService.findAllCustomers();

       assertEquals(expectedCustomerDto,actualCustumers);
    }


}
