package com.TicketBooking.book_my_show.Req_DTOs;

import lombok.Data;

@Data
public class TheaterEntryDto {

    private String name;

    private String location;

    private int premiumSeatsCount;
 
    private int classicSeatsCount;

}
