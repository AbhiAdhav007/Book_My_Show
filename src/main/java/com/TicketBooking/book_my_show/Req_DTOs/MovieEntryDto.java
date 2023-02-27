package com.TicketBooking.book_my_show.Req_DTOs;

import com.TicketBooking.book_my_show.Enums.Genre;
import com.TicketBooking.book_my_show.Enums.Language;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MovieEntryDto {


    private String movieName;

    private double ratings;

    private int duration;

    private Language language;

    private Genre genre;
}
