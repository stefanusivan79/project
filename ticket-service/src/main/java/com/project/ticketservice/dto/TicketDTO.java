package com.project.ticketservice.dto;

import lombok.Data;

@Data
public class TicketDTO {

    private String id;
    private String film;
    private String time;
    private String date;
    private Integer quantity;
}
