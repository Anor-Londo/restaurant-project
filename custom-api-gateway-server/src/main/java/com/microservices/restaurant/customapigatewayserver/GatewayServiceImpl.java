package com.microservices.restaurant.customapigatewayserver;

import org.springframework.stereotype.Service;

@Service
public class GatewayServiceImpl implements GatewayService{

    private GuestServiceProxy guestProxy;
    private TableServiceProxy tableProxy;
    private BookingServiceProxy bookingProxy;

    @Override
    public Booking add(int tableId, int guestId, Booking booking) {

        Table tableResponce = tableProxy.retrieveOneTable(tableId);
        Guest guestResponce = guestProxy.findGuestById(guestId);
        Booking newBooking = new Booking(tableResponce.getId(), guestResponce.getId(), booking.getTime());
        return newBooking;
    }
}
