package com.TicketBooking.book_my_show.Services.Converters;

import com.TicketBooking.book_my_show.Models.User;
import com.TicketBooking.book_my_show.Req_DTOs.UserEntryDto;

public class UserConverter {

    public static User convertDtoToEntity(UserEntryDto userEntryDto){

        //here we need to convert userEntrydto to the user and save
        /*
            old method : create new object and save its attributes
         */
        User user = User.builder().age(userEntryDto.getAge()).name(userEntryDto.getName()).email(userEntryDto.getEmail()).
                mobNo(userEntryDto.getMobNo()).address(userEntryDto.getAddress()).build();

        return user;

    }
}
