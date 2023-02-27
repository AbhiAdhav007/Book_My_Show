package com.TicketBooking.book_my_show.Controllers;

import com.TicketBooking.book_my_show.Models.TheaterSeats;
import com.TicketBooking.book_my_show.Services.TheaterSeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterSeatsController {

    @Autowired
    TheaterSeatsService theaterSeatsService;
}
