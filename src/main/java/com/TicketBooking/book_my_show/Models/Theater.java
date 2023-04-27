package com.TicketBooking.book_my_show.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    // this is parent wrt theater seats
    @OneToMany(mappedBy = "theater" , cascade = CascadeType.ALL)
    private List<TheaterSeats> theaterSeatsList = new ArrayList<>();

    //this is parent wrt show
    @OneToMany(mappedBy = "theater" , cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();

}
