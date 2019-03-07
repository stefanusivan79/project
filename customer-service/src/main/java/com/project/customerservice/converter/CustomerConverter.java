package com.project.customerservice.converter;

import com.project.customerservice.domain.Customer;
import com.project.customerservice.dto.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public CustomerDTO convertToDTO(Customer customer) {

        CustomerDTO response = new CustomerDTO();
        response.setId(customer.getCustomerId());
        response.setEmail(customer.getEmail());
        response.setName(customer.getName());
        response.setPhone(customer.getPhone());
        return response;
    }
}
