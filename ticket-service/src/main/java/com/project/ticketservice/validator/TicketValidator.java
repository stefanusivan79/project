package com.project.ticketservice.validator;

import com.project.ticketservice.domain.Ticket;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TicketValidator {

    public Boolean validateTicketBought(Ticket ticket) {
        return ticket.getDate().compareTo(new Date()) > 0;
    }
}
