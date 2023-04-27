package com.TicketBooking.book_my_show.Services.Converters;

import com.TicketBooking.book_my_show.Models.Theater;
import com.TicketBooking.book_my_show.Models.Ticket;
import com.TicketBooking.book_my_show.Req_DTOs.TicketEntryDto;

public class TicketConverter {

    public static Ticket convertDtoToTicketEntity(TicketEntryDto ticketEntryDto){

        return new Ticket();
    }
}
