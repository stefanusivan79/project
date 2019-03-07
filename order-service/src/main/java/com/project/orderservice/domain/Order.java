package com.project.orderservice.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "ticket_id")
    private String ticketId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "buy")
    private Integer buy;

}
