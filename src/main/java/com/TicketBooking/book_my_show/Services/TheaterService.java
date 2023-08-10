package com.TicketBooking.book_my_show.Services;

import com.TicketBooking.book_my_show.Enums.SeatType;
import com.TicketBooking.book_my_show.Models.Movie;
import com.TicketBooking.book_my_show.Models.Show;
import com.TicketBooking.book_my_show.Models.Theater;
import com.TicketBooking.book_my_show.Models.TheaterSeats;
import com.TicketBooking.book_my_show.Repositories.MovieRepository;
import com.TicketBooking.book_my_show.Repositories.ShowRepository;
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

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto) throws Exception{

        /*
        1. create theater seats
        2.save theater : I need theater entity
        3. Save attributes before saving(Is tricky)
         */
//

        //Do some validations :
        if(theaterEntryDto.getName()==null||theaterEntryDto.getLocation()==null){
            throw new Exception("Name and location should valid");
        }

        Theater theaterEntity = TheaterConverter.convertDtoToEntity(theaterEntryDto);
        List<TheaterSeats> theaterSeatEntityList = createTheaterSeats(theaterEntryDto,theaterEntity);

        theaterEntity.setTheaterSeatsList(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);

        return "Theater Added successfully";
    }

    private List<TheaterSeats> createTheaterSeats(TheaterEntryDto theaterEntryDto,Theater theaterEntity){

        int noClassicSeats = theaterEntryDto.getClassicSeatsCount();
        int noPremiumSeats = theaterEntryDto.getPremiumSeatsCount();

        List<TheaterSeats> theaterSeatEntityList = new ArrayList<>();

        //Created the classic Seats
        for(int count = 1;count<=noClassicSeats;count++){

            //We need to make a new TheaterSeatEntity
            TheaterSeats theaterSeatEntity = TheaterSeats.builder()
                    .seatType(SeatType.CLASSIC).seatNo(count+"C")
                    .theater(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }


        //Create the premium Seats
        for(int count=1;count<=noPremiumSeats;count++){

            TheaterSeats theaterSeatEntity = TheaterSeats.builder().
                    seatType(SeatType.PREMIUM).seatNo(count+"P").theater(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        //Not saving the child here
        return theaterSeatEntityList;

    }

    public List<Theater> getTheaters(int movieId){

        List<Theater> theaterList = new ArrayList<>();

        List<Show> showList = showRepository.findAll();

        for(Show show : showList){

            if(show.getMovie().getId() == movieId){

                theaterList.add(show.getTheater());
            }
        }
        return theaterList;
    }
}
