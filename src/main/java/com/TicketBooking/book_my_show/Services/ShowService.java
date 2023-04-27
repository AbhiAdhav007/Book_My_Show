package com.TicketBooking.book_my_show.Services;

import com.TicketBooking.book_my_show.Enums.SeatType;
import com.TicketBooking.book_my_show.Models.*;
import com.TicketBooking.book_my_show.Repositories.MovieRepository;
import com.TicketBooking.book_my_show.Repositories.ShowRepository;
import com.TicketBooking.book_my_show.Repositories.TheaterRepository;
import com.TicketBooking.book_my_show.Req_DTOs.ShowEntryDto;
import com.TicketBooking.book_my_show.Services.Converters.ShowConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;


    public String addShow(ShowEntryDto showEntryDto){


        Show show = ShowConverter.convertShowDtoToShowEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();

        int theaterId = showEntryDto.getTheaterId();

        Movie movie = movieRepository.findById(movieId).get();

        Theater theater = theaterRepository.findById(theaterId).get();

        // Setting the attributes of the foreign key
        show.setMovie(movie);
        show.setTheater(theater);

        //Next goal is to create the show seats

        List<ShowSeat> showSeatList = createTheShowSeats(showEntryDto,show);
        show.setListOfShowsSeats(showSeatList);

        show = showRepository.save(show);

        movie.getShowList().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);
//        //Also we need to update the parent
//        List<Show> showList = movie.getShowList();
//        showList.add(show);
//        movie.setShowList(showList);
//
//        movieRepository.save(movie);
//
//        List<Show> showList1 = theater.getShowList();
//        showList1.add(show);
//        movie.setShowList(showList1);
//
//        theaterRepository.save(theater);


       // showRepository.save(show); //it had been done at the time parent is saved (theater and movie)

        return "Show is been added successfully";
    }

    private List<ShowSeat> createTheShowSeats(ShowEntryDto showEntryDto , Show show){

        Theater theater = show.getTheater();
        List<TheaterSeats> theaterSeatsList = theater.getTheaterSeatsList();

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheaterSeats theaterSeats : theaterSeatsList){

            ShowSeat showSeat = new ShowSeat();

            showSeat.setSeatNo(theaterSeats.getSeatNo());
            showSeat.setSeatType(theaterSeats.getSeatType());

            //setting the price for the seat

            if(theaterSeats.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(showEntryDto.getClassicSeatPrice());
            }else{
                showSeat.setPrice(showEntryDto.getPremiumSeatPrice());
            }

            showSeat.setBooked(false);
            showSeat.setShow(show);

            showSeatList.add(showSeat);
        }
        return showSeatList;

    }


    public List<LocalTime> getShowTiming(int theaterId , int movieId)throws Exception{

        Theater theater = theaterRepository.findById(theaterId).get();

        Movie movie = movieRepository.findById(movieId).get();

        if(theater == null || movie == null) throw new Exception("not found");


        List<Show> TheaterShowLists = theater.getShowList();

        List<LocalTime> showTimeList = new ArrayList<>();

        for(Show show : TheaterShowLists){

            if(show.getMovie().equals(movie)){

                showTimeList.add(show.getShowTime());
            }
        }

        return showTimeList;
    }
}
