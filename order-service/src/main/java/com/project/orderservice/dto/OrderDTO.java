package com.project.orderservice.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private Long id;
    private String ticketId;
    private String customerId;
    private Integer buy;
}
