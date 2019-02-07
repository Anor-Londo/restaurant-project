package com.microservices.restaurant.customapigatewayserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GatewayServiceImpl implements GatewayService{

    @Autowired
    private GuestServiceProxy guestProxy;

    @Autowired
    private TableServiceProxy tableProxy;

    @Autowired
    private BookingServiceProxy bookingProxy;

    @Override
    public  Booking add(int tableId, int guestId, Booking booking) {

        Table tableResponce = tableProxy.retrieveOneTable(tableId);
        Guest guestResponce = guestProxy.findGuestById(guestId);
        tableProxy.reserveTable(tableId);
        guestProxy.reserveGuest(guestId);
        return new Booking(tableResponce.getId(), guestResponce.getId(), booking.getTime());
    }

    @Override
    public void delete(int bookingId) {
        tableProxy.cancelTable(bookingProxy.retrieveReservedTable(bookingId));
        guestProxy.cancelGuest(bookingProxy.retrieveReservedGuest(bookingId));
        bookingProxy.deleteBookingById(bookingId);
    }
}
