package com.TicketBooking.book_my_show.Models;


import com.TicketBooking.book_my_show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theater_seats")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheaterSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;


    //this is child wrt show
    @ManyToOne
    @JoinColumn
    private Theater theater;

}
