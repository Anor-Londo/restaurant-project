package com.microservices.booking.bookingservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BookingController {

    @Autowired
    private TableServiceProxy tableProxy;

    @Autowired
    private GuestServiceProxy guestProxy;

    @Autowired
    private BookingRepository repository;

    private BookingService service;

    @RequestMapping(value = "booking/table/{tableId}/guest/{guestId}", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Booking add(@PathVariable int tableId, @PathVariable int guestId, @RequestBody Booking booking){

        TableBean tableResponse = tableProxy.retrieveOneTable(tableId);
        GuestBean guestResponse = guestProxy.findGuestById(guestId);
        Booking newBooking = new Booking(tableResponse.getId(), guestResponse.getId(), booking.getTime());
        repository.save(newBooking);
        return newBooking;
    }
/*
    @RequestMapping(value = "booking", method = RequestMethod.GET)
    public Iterable<Booking> retrieveAllBookings(){
        return repository.findAll();
    }

    @RequestMapping(value = "booking/{id}", method = RequestMethod.GET)
    public Optional<Booking> retrieveBookingById(@PathVariable int id){
        Optional<Booking> booking = repository.findById(id);
        return booking;
    }


    @RequestMapping(value = "booking/guest/{id}", method = RequestMethod.GET)
    public List<Booking> retrieveTablesBooking(@PathVariable int id){
        List<Booking> bookings = service.findBookedTables(id);
        return bookings;
    }
    */
}
