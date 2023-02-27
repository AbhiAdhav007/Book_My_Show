package com.TicketBooking.book_my_show.Repositories;


import com.TicketBooking.book_my_show.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie , Integer> {

}
