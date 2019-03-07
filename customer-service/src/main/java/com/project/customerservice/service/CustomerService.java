package com.project.customerservice.service;

import com.project.customerservice.converter.CustomerConverter;
import com.project.customerservice.domain.Customer;
import com.project.customerservice.dto.CustomerDTO;
import com.project.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerConverter customerConverter;

    public CustomerDTO findOne(String id) {
        Customer customer = customerRepository.findByCustomerId(id).orElse(new Customer());

        return customerConverter.convertToDTO(customer);
    }
}
