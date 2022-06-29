package com.aydogdu.customer.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {
    @Bean
    ModelMapper ModelMapper(){
        return new ModelMapper();
    }
}
