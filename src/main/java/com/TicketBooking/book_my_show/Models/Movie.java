package com.TicketBooking.book_my_show.Models;

import com.TicketBooking.book_my_show.Enums.Genre;
import com.TicketBooking.book_my_show.Enums.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true , nullable = false)
    private String movieName;

    private double ratings;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //this is the parent wrt to show
    @OneToMany(mappedBy = "movie" , cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();
}
