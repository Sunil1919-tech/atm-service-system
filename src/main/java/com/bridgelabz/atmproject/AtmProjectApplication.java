package com.bridgelabz.atmproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Purpose: To demonstrate Atm management System
 *
 * @author Sunil
 * @since 03/12/2021
 */
@SpringBootApplication
public class AtmProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtmProjectApplication.class, args);
    }

    /**
     * purpose : determining the model mapper class as bean in our Spring Configuration
     * creating to make object mapping by auto
     *
     * @return: ModelMapper object
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
