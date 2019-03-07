package com.project.customerservice.util;

import com.project.customerservice.domain.Customer;
import com.project.customerservice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@PropertySource("classpath:data.properties")
@Component
@Slf4j
public class InitDB {

    @Autowired
    CustomerRepository customerRepository;

    @Value("#{'${customer.id}'.split(',')}")
    private List<String> customerId;
    @Value("#{'${customer.name}'.split(',')}")
    private List<String> customerName;
    @Value("#{'${customer.phone}'.split(',')}")
    private List<String> customerPhone;
    @Value("#{'${customer.email}'.split(',')}")
    private List<String> customerEmail;

    @PostConstruct
    public void init() {
        log.info("INIT DB");
        initCustomer();
    }

    private void initCustomer() {
        int[] idx = {0};
        customerId.forEach(id -> {
            Optional<Customer> customer = customerRepository.findByCustomerId(id);
            if (!customer.isPresent()) {
                Customer entity = new Customer();
                entity.setCustomerId(customerId.get(idx[0]));
                entity.setName(customerName.get(idx[0]));
                entity.setEmail(customerEmail.get(idx[0]));
                entity.setPhone(customerPhone.get(idx[0]));
                idx[0]++;
                customerRepository.saveAndFlush(entity);
            }
        });

    }

}
