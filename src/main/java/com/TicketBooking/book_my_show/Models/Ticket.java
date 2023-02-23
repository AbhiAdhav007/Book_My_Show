package com.TicketBooking.book_my_show.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String ticketId = UUID.randomUUID().toString();

    private int price;

    private String movieName;

    private LocalTime showTime;

    private LocalDate date;

    private String theaterName;


    //this is the child wrt to user
    @ManyToOne
    @JoinColumn
    private User user;


    //this is child wrt to show
    @ManyToOne
    @JoinColumn
    private Show show;




}
