package com.project.ticketservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    private String ticketId;

    @Column(name = "film")
    private String film;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Temporal(TemporalType.TIME)
    @Column(name = "start_time")
    private Date startTime;

    @Temporal(TemporalType.TIME)
    @Column(name = "finish_time")
    private Date finishTime;

    @Column(name = "quantity")
    private Integer quantity;
}
