package com.project.ticketservice.service;

import com.project.ticketservice.converter.TicketConverter;
import com.project.ticketservice.domain.Ticket;
import com.project.ticketservice.dto.TicketDTO;
import com.project.ticketservice.repository.TicketRepository;
import com.project.ticketservice.validator.TicketValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketConverter ticketConverter;

    @Autowired
    TicketValidator ticketValidator;

    public TicketDTO findOne(String id) {

        Ticket ticket = ticketRepository.findByTicketId(id).orElse(new Ticket());
        return ticketConverter.convertToDTO(ticket);
    }

    public List<TicketDTO> findTicketByName(String film) {

        List<Ticket> ticketList = ticketRepository.findByFilmContaining(film);
        return ticketList.stream()
                .map(ticket -> ticketConverter.convertToDTO(ticket)).collect(Collectors.toList());
    }

    public Boolean ticketBought(String ticketId, Integer sum) {

        Ticket ticket = ticketRepository.findByTicketId(ticketId).orElse(new Ticket());

        if (ticket.getQuantity() >= sum && ticket.getQuantity() != null) {
            Boolean valid = ticketValidator.validateTicketBought(ticket);
            if (!valid){
                log.error("Film yang lewat masa tayang tidak bisa di pilih");
                return false;
            }
            Integer qty = ticket.getQuantity();
            ticket.setQuantity(qty - sum);
            ticketRepository.saveAndFlush(ticket);
            return true;
        }

        return false;
    }

}
