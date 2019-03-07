package com.project.ticketservice.web;

import com.project.ticketservice.dto.TicketBoughtDTO;
import com.project.ticketservice.dto.TicketDTO;
import com.project.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketResource {

    @Autowired
    TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicket(@PathVariable("id") String ticketId) {
        TicketDTO response = ticketService.findOne(ticketId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/bought")
    public ResponseEntity<Boolean> ticketBought(@RequestBody TicketBoughtDTO dto) {
        Boolean response = ticketService.ticketBought(dto.getTicketId(), dto.getQty());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<TicketDTO>> getTicketByName(@PathVariable("name") String film) {
        List<TicketDTO> response = ticketService.findTicketByName(film);
        return ResponseEntity.ok(response);
    }


}
