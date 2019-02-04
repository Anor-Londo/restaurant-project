package com.microservices.restaurant.customapigatewayserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GatewayController {

    @Autowired
    private GuestServiceProxy guestProxy;

    @Autowired
    private TableServiceProxy tableProxy;

    @Autowired
    private BookingServiceProxy bookingProxy;

    private GatewayService gatewayService;

    //-----------------------------------------------------------------------------------//

    @RequestMapping(value = "booking-service/booking/table/{tableId}/guest/{guestId}", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Booking add(@PathVariable int tableId, @PathVariable int guestId, @RequestBody Booking booking){

        Booking newBooking = gatewayService.add(tableId, guestId, booking);
        bookingProxy.add(newBooking);
        return null;
    }

    @RequestMapping(value = "guest-service/guest/{id}", method = RequestMethod.GET)
    public Guest retrieveGuestById(@PathVariable int id){
        Guest guest = guestProxy.findGuestById(id);
        return guest;
    }
}
