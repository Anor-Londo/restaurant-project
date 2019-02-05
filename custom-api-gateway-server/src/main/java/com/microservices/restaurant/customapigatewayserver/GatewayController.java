package com.microservices.restaurant.customapigatewayserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GatewayController {

    @Autowired
    private GuestServiceProxy guestProxy;

    @Autowired
    private TableServiceProxy tableProxy;

    @Autowired
    private BookingServiceProxy bookingProxy;

    @Autowired
    private GatewayService gatewayService;

    //--------------------------------BOOKING-----------------------------------------//

    @RequestMapping(value = "booking-service/booking/table/{tableId}/guest/{guestId}", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Booking add(@PathVariable int tableId, @PathVariable int guestId, @RequestBody Booking booking){

        Booking newBooking = gatewayService.add(tableId, guestId, booking);
        bookingProxy.add(newBooking);
        return null;
    }



    //--------------------------------GUEST--------------------------------------------//

    @RequestMapping(value = "guest-service/guest", method = RequestMethod.GET)
    public Iterable<Guest> retrieveAllGuests(){
        Iterable<Guest> allGuests = guestProxy.retrieveAllGuests();
        return allGuests;
    }

    @RequestMapping(value = "guest-service/guest/find/{cs}", method = RequestMethod.GET)
    public List<Guest> findGuests(@PathVariable String cs){
        List<Guest> guestsFound = guestProxy.findGuests(cs);
        return guestsFound;
    }

    @RequestMapping(value = "guest-service/guest/{id}", method = RequestMethod.GET)
    public Guest retrieveGuestById(@PathVariable int id){
        Guest guest = guestProxy.findGuestById(id);
        return guest;
    }

    @RequestMapping(value = "guest-service/guest/create", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Guest createGuest(@RequestBody Guest request){
        Guest guest = guestProxy.createGuest(request);
        return null;
    }

    //------------------------------Table--------------------------------------------//
    
}
