package com.TicketBooking.book_my_show.Req_DTOs;

import com.TicketBooking.book_my_show.Enums.ShowType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {

    private LocalDate showDate;

    private LocalTime showTime;

    private int theaterId;

    private int movieId;

    private int classicSeatPrice;

    private int premiumSeatPrice;

    private ShowType showType;


}


