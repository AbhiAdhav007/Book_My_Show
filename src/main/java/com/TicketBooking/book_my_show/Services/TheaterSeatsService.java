package com.TicketBooking.book_my_show.Services;

import com.TicketBooking.book_my_show.Repositories.TheaterSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterSeatsService {

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

}
