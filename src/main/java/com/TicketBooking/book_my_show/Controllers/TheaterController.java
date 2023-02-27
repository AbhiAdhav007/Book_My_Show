package com.TicketBooking.book_my_show.Controllers;

import com.TicketBooking.book_my_show.Req_DTOs.TheaterEntryDto;
import com.TicketBooking.book_my_show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity<String> addTheater(@RequestBody TheaterEntryDto theaterEntryDto){

        String response = theaterService.addTheater(theaterEntryDto);

        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

}
