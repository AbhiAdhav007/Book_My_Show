package com.TicketBooking.book_my_show.Services.Converters;

import com.TicketBooking.book_my_show.Models.Theater;
import com.TicketBooking.book_my_show.Req_DTOs.TheaterEntryDto;

public class TheaterConverter {

    public static Theater convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        return Theater.builder().location(theaterEntryDto.getLocation()).name(theaterEntryDto.getName())
                .build();
    }
}
