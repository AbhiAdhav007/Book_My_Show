package com.TicketBooking.book_my_show.Services;

import com.TicketBooking.book_my_show.Services.Converters.MovieConverter;
import com.TicketBooking.book_my_show.Models.Movie;
import com.TicketBooking.book_my_show.Repositories.MovieRepository;
import com.TicketBooking.book_my_show.Req_DTOs.MovieEntryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto) throws Exception{

        Movie movie = MovieConverter.movieDtoToMovie(movieEntryDto);

        movieRepository.save(movie);

        return "Movie Added Successfully";
    }
}
