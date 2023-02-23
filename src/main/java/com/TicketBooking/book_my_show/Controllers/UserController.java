package com.TicketBooking.book_my_show.Controllers;

import com.TicketBooking.book_my_show.Req_DTOs.UserEntryDto;
import com.TicketBooking.book_my_show.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public String addUser(@RequestBody UserEntryDto userEntryDto){

        return userService.addUser(userEntryDto);
    }
}
