package com.TicketBooking.book_my_show.Controllers;

import com.TicketBooking.book_my_show.Req_DTOs.TicketEntryDto;
import com.TicketBooking.book_my_show.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/Book_Ticket")
    public String bookTicket(@RequestBody TicketEntryDto ticketEntryDto){

        try{
            return ticketService.bookTicket(ticketEntryDto);
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
