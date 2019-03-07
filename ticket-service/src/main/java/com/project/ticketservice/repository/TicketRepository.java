package com.project.ticketservice.repository;

import com.project.ticketservice.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByTicketId(String id);

    List<Ticket> findByFilmContaining(String film);
}
