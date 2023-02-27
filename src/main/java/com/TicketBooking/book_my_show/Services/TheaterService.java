package com.TicketBooking.book_my_show.Services;

import com.TicketBooking.book_my_show.Enums.SeatType;
import com.TicketBooking.book_my_show.Models.Theater;
import com.TicketBooking.book_my_show.Models.TheaterSeats;
import com.TicketBooking.book_my_show.Repositories.TheaterRepository;
import com.TicketBooking.book_my_show.Repositories.TheaterSeatsRepository;
import com.TicketBooking.book_my_show.Req_DTOs.TheaterEntryDto;
import com.TicketBooking.book_my_show.Services.Converters.TheaterConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto){

        /*
        1. create theater seats
        2.save theater : I need theater entity
        3. Save attributes before saving(Is tricky)
         */

        Theater theater = TheaterConverter.convertDtoToEntity(theaterEntryDto);

        List<TheaterSeats> theaterSeatsList = createTheaterSeats(theaterEntryDto , theater);

        theater.setTheaterSeatsList(theaterSeatsList);

        theaterRepository.save(theater);

        return "";
    }

    private List<TheaterSeats> createTheaterSeats(TheaterEntryDto theaterEntryDto , Theater theater){

        List<TheaterSeats> theaterSeatsList = new ArrayList<>();

        //creating the classic seats
        for(int count = 1 ; count <= theaterEntryDto.getClassicSeatsCount(); count++){

            TheaterSeats theaterSeats = TheaterSeats.builder().seatNo(count + "C").seatType(SeatType.CLASSIC).theater(theater).build();

            theaterSeatsList.add(theaterSeats);
        }

        //creating premium seats
        for(int count = 1 ; count <= theaterEntryDto.getPremiumSeatCount();count++){

            TheaterSeats theaterSeats = TheaterSeats.builder().seatNo(count + "P").seatType(SeatType.PREMIUM).theater(theater).build();

            theaterSeatsList.add(theaterSeats);
           }

        //save the theater seats
        theaterSeatsRepository.saveAll(theaterSeatsList);

        return theaterSeatsList;

    }
}
