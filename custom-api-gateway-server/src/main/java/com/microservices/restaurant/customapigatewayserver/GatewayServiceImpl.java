package com.microservices.restaurant.customapigatewayserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatewayServiceImpl implements GatewayService{

    @Autowired
    private GuestServiceProxy guestProxy;

    @Autowired
    private TableServiceProxy tableProxy;

    @Override
    public  Booking add(int tableId, int guestId, Booking booking) {

        Table tableResponce = tableProxy.retrieveOneTable(tableId);
        Guest guestResponce = guestProxy.findGuestById(guestId);
        return new Booking(tableResponce.getId(), guestResponce.getId(), booking.getTime());
    }
}
