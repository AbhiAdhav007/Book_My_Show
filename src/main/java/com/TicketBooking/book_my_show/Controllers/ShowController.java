package com.TicketBooking.book_my_show.Controllers;

import com.TicketBooking.book_my_show.Req_DTOs.ShowEntryDto;
import com.TicketBooking.book_my_show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){

        return new ResponseEntity<>(showService.addShow(showEntryDto), HttpStatus.CREATED);

    }
    //working fine
    @GetMapping("/get_showTiming")
    public ResponseEntity<List<LocalTime>> getShowTime(@RequestParam int theaterId , @RequestParam int movieId){

        try {
            List<LocalTime> showTimings = showService.getShowTiming(theaterId,movieId);
            return new ResponseEntity<>(showTimings , HttpStatus.FOUND);
        }catch (Exception e){

            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
        }
    }




}
