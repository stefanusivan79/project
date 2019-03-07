package com.project.ticketservice.util;

import com.project.ticketservice.domain.Ticket;
import com.project.ticketservice.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@PropertySource("classpath:data.properties")
@Component
@Slf4j
public class InitDB {

    @Autowired
    TicketRepository ticketRepository;

    @Value("#{'${ticket.id}'.split(',')}")
    private List<String> ticketId;
    @Value("#{'${ticket.film}'.split(',')}")
    private List<String> ticketFilm;
    @Value("#{'${ticket.date}'.split(',')}")
    private List<String> ticketDate;
    @Value("#{'${ticket.start.time}'.split(',')}")
    private List<String> ticketStartTime;
    @Value("#{'${ticket.finish.time}'.split(',')}")
    private List<String> ticketFinishTime;
    @Value("#{'${ticket.quantity}'.split(',')}")
    private List<String> ticketQuantity;

    @PostConstruct
    public void init() {
        log.info("INIT DB");
        initTicket();
    }

    private void initTicket() {
        int[] idx = {0};
        ticketId.forEach(id -> {
            Optional<Ticket> ticket = ticketRepository.findByTicketId(id);
            if (!ticket.isPresent()) {
                Ticket entity = new Ticket();
                entity.setTicketId(ticketId.get(idx[0]));
                entity.setFilm(ticketFilm.get(idx[0]));
                entity.setQuantity(Integer.valueOf(ticketQuantity.get(idx[0])));
                try {
                    entity.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(ticketDate.get(idx[0])));
                    entity.setStartTime(new SimpleDateFormat("hh:mm").parse(ticketStartTime.get(idx[0])));
                    entity.setFinishTime(new SimpleDateFormat("hh:mm").parse(ticketFinishTime.get(idx[0])));
                    ticketRepository.saveAndFlush(entity);
                } catch (ParseException e) {
                    log.error("Error parse time");
                }
                idx[0]++;
            }
        });

    }
}
