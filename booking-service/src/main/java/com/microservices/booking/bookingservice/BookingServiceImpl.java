package com.microservices.booking.bookingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingService service;
    private BookingRepository repository;

    public BookingService getService() {
        return service;
    }

    @Autowired
    public void setService(BookingService service) {
        this.service = service;
    }

    public BookingRepository getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(BookingRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Booking> findBookedTables(int tableId) {
        List<Booking> bookingsFound = new ArrayList<Booking>();
        Iterable<Booking> allBookings = repository.findAll();
        for (Booking booking: allBookings) {
            if (booking.getTableId() == tableId){
                bookingsFound.add(booking);
            }
        }
        return bookingsFound;
    }



    @Override
    public Booking findBookedGuest(int guestId) {
        return null;
    }
}
