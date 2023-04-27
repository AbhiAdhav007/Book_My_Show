package com.TicketBooking.book_my_show.Services.Converters;

import com.TicketBooking.book_my_show.Models.Show;
import com.TicketBooking.book_my_show.Req_DTOs.ShowEntryDto;

public class ShowConverter {

    public static Show convertShowDtoToShowEntity(ShowEntryDto showEntryDto){

        return Show.builder()
                .showDate(showEntryDto.getShowDate()).showTime(showEntryDto.getShowTime())
                .showType(showEntryDto.getShowType()).build();
    }
}
