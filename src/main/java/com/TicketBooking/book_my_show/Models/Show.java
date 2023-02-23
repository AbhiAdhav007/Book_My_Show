package com.TicketBooking.book_my_show.Models;

import com.TicketBooking.book_my_show.Enums.ShowType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@NoArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private LocalTime showTime;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    //this is child wrt to movie Entity

    @ManyToOne
    @JoinColumn
    private Movie movie;

    //
    @ManyToOne
    @JoinColumn
    private Theater theater;

    //show is the parent wrt ticket
    @OneToMany(mappedBy = "show" , cascade = CascadeType.ALL)
    private List<Ticket> listOfBookedTickets = new ArrayList<>();

    //this is parent wrt to show seats
    @OneToMany(mappedBy = "show" , cascade = CascadeType.ALL)
    private List<ShowSeat> listOfShowsSeats  = new ArrayList<>();



}
