package com.TicketBooking.book_my_show.Req_DTOs;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserEntryDto {

    private String name;

    private int age;

    private String email;

    private String mobNo;

    private String address;

}
