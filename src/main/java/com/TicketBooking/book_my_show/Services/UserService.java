package com.TicketBooking.book_my_show.Services;

import com.TicketBooking.book_my_show.Req_DTOs.UserEntryDto;
import com.TicketBooking.book_my_show.Models.User;
import com.TicketBooking.book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto){

        //here we need to convert userEntrydto to the user and save
        /*
            old method : create new object and save its attributes
         */

        User user = User.builder().age(userEntryDto.getAge()).name(userEntryDto.getName()).email(userEntryDto.getEmail()).
                mobNo(userEntryDto.getMobNo()).address(userEntryDto.getAddress()).build();

        userRepository.save(user);

        return "Profile is Successfully Created";
    }
}
