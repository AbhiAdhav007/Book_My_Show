package com.TicketBooking.book_my_show.Services;


import com.TicketBooking.book_my_show.Models.Show;
import com.TicketBooking.book_my_show.Models.ShowSeat;
import com.TicketBooking.book_my_show.Models.Ticket;
import com.TicketBooking.book_my_show.Models.User;
import com.TicketBooking.book_my_show.Repositories.ShowRepository;
import com.TicketBooking.book_my_show.Repositories.TicketRepository;
import com.TicketBooking.book_my_show.Repositories.UserRepository;
import com.TicketBooking.book_my_show.Req_DTOs.TicketEntryDto;
import com.TicketBooking.book_my_show.Services.Converters.TicketConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String bookTicket(TicketEntryDto ticketEntryDto) throws Exception{

        Ticket ticket = TicketConverter.convertDtoToTicketEntity(ticketEntryDto);
        Show show = showRepository.findById(ticketEntryDto.getShowId()).get();

        int totalAmount = 0;
        try {
            totalAmount = getPriceAndCheckCheckValidityOfSeats(ticketEntryDto);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        List<ShowSeat> showSeatList = show.getListOfShowsSeats();
        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        String result = "";
        for (ShowSeat showSeat : showSeatList){

            if(requestedSeats.contains(showSeat.getSeatNo())){
                result += showSeat.getSeatNo() + ", ";
                showSeat.setBooked(true);
                showSeat.setBookedAt(new Date());
            }
        }

        ticket.setDate(show.getShowDate());
        ticket.setShowTime(show.getShowTime());
        ticket.setBookedSeats(result);
        ticket.setPrice(totalAmount);
        ticket.setTheaterName(show.getTheater().getName());
        ticket.setMovieName(show.getMovie().getMovieName());


        User user = userRepository.findById(ticketEntryDto.getUserId()).get();
        //setting the user
        ticket.setUser(user);
        ticket.setShow(show);

        ticket = ticketRepository.save(ticket);

        List<Ticket> ticketList = show.getListOfBookedTickets();
        ticketList.add(ticket);
        show.setListOfBookedTickets(ticketList);

        showRepository.save(show);

        List<Ticket> ticketList1 = user.getTicketList();
        ticketList1.add(ticket);
        user.setTicketList(ticketList1);

        userRepository.save(user);

        return "WoW You Are Ready To Go";

    }

    private int getPriceAndCheckCheckValidityOfSeats(TicketEntryDto ticketEntryDto) throws Exception{

        Show show = showRepository.findById(ticketEntryDto.getShowId()).get();

        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        List<ShowSeat> showSeatList = show.getListOfShowsSeats();

        int price = 0;
        //Iterating through the showSeat list to get the perticuular seats
        for(ShowSeat showSeat : showSeatList){
            if(requestedSeats.contains(showSeat.getSeatNo())){

                if(showSeat.isBooked()) throw new Exception("Requested Seats not Available");
                else{
                    price += showSeat.getPrice();
                }
            }
        }
        return price;
    }


}
