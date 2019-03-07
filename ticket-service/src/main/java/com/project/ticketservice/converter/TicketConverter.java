package com.project.ticketservice.converter;

import com.project.ticketservice.domain.Ticket;
import com.project.ticketservice.dto.TicketDTO;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class TicketConverter {

    public TicketDTO convertToDTO(Ticket ticket) {

        SimpleDateFormat time = new SimpleDateFormat("HH:mm");

        TicketDTO response = new TicketDTO();
        response.setId(ticket.getTicketId());
        response.setFilm(ticket.getFilm());
        response.setQuantity(ticket.getQuantity());
        response.setDate(new SimpleDateFormat("dd MMM yyyy").format(ticket.getDate()));
        response.setTime(String.format("%s - %s",
                time.format(ticket.getStartTime()), time.format(ticket.getFinishTime())));
        return response;
    }
}
