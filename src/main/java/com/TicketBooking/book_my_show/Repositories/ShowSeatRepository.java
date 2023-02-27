package com.TicketBooking.book_my_show.Repositories;

import com.TicketBooking.book_my_show.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat , Integer> {
}
