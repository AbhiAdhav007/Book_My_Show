package com.TicketBooking.book_my_show.Services.Converters;

import com.TicketBooking.book_my_show.Models.Movie;
import com.TicketBooking.book_my_show.Req_DTOs.MovieEntryDto;

public class MovieConverter {

    public static Movie movieDtoToMovie(MovieEntryDto movieEntryDto){

        Movie movie = Movie.builder()
                .movieName(movieEntryDto.getMovieName()).duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre()).ratings(movieEntryDto.getRatings()).language(movieEntryDto.getLanguage())
                .build();

        return movie;
    }
}
