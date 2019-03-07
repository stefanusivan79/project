package com.project.orderservice.service;

import com.project.orderservice.converter.OrderConverter;
import com.project.orderservice.domain.Order;
import com.project.orderservice.dto.OrderDTO;
import com.project.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Transactional
@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderConverter orderConverter;

    public OrderDTO saveOrder(OrderDTO dto) {

        Order order = orderConverter.convertToEntity(dto);
        Order savedOrder = orderRepository.save(order);

        dto.setId(savedOrder.getOrderId());
        return dto;
    }
}
