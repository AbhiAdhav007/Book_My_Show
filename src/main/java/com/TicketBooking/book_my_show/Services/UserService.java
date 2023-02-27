package com.TicketBooking.book_my_show.Services;

import com.TicketBooking.book_my_show.Services.Converters.UserConverter;
import com.TicketBooking.book_my_show.Req_DTOs.UserEntryDto;
import com.TicketBooking.book_my_show.Models.User;
import com.TicketBooking.book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) throws Exception{

        User user = UserConverter.convertDtoToEntity(userEntryDto);

        userRepository.save(user);

        return "Profile is Successfully Created";
    }
}
