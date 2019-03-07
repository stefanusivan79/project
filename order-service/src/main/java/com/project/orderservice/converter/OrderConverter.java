package com.project.orderservice.converter;

import com.project.orderservice.dto.OrderDTO;
import com.project.orderservice.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public Order convertToEntity(OrderDTO dto){

        Order response = new Order();
        response.setTicketId(dto.getTicketId());
        response.setCustomerId(dto.getCustomerId());
        response.setBuy(dto.getBuy());
        return response;
    }
}
