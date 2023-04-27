package com.TicketBooking.book_my_show.Controllers;

import com.TicketBooking.book_my_show.Models.Theater;
import com.TicketBooking.book_my_show.Req_DTOs.TheaterEntryDto;
import com.TicketBooking.book_my_show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity<String> addTheater(@RequestBody TheaterEntryDto theaterEntryDto){

        try{

            String response = theaterService.addTheater(theaterEntryDto);

            return new ResponseEntity<>(response , HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get_theaters")
    public List<Theater>getTheaters(@RequestParam int movieId){

             List<Theater> theaterList =  theaterService.getTheaters(movieId);

        return theaterList;
    }

}
