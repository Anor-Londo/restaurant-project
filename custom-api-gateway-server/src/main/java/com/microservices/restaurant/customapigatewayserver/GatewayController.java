package com.microservices.restaurant.customapigatewayserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @RequestMapping(value = "booking-service/booking", method = RequestMethod.GET)
    public Iterable<Booking> retrieveAllBookings(){
        Iterable<Booking> allBookings = bookingProxy.retrieveAllBookings();
        return allBookings;
    }

    @RequestMapping(value = "booking-service/booking/{id}", method = RequestMethod.GET)
    public Optional<Booking> retrieveBookingById(@PathVariable int id){
        Optional<Booking> booking = bookingProxy.retrieveBookingById(id);
        return booking;
    }

    @RequestMapping(value = "booking-service/booking/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBookingById(@PathVariable int id){
        bookingProxy.deleteBookingById(id);
    }

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

    @RequestMapping(value = "table-service/table", method = RequestMethod.GET)
    public Iterable<Table> retrieveAllTables(){
        Iterable<Table> allTables = tableProxy.retrieveAllTables();
        return allTables;
    }

    @RequestMapping(value = "table-service/table/{id}", method = RequestMethod.GET)
    public Table retrieveOneTable(@PathVariable int id){
        Table tableFound = tableProxy.retrieveOneTable(id);
        return tableFound;
    }

    @RequestMapping(value = "table-service/table/capacity/{capacity}", method = RequestMethod.GET)
    public List<Table> retrieveTableByCapacity(@PathVariable int capacity){
        List<Table> tablesFound = tableProxy.retrieveTableByCapacity(capacity);
        return tablesFound;
    }

    @RequestMapping(value = "table-service/table/cost/from/{from}/to/{to}", method = RequestMethod.GET)
    public List<Table> retrieveTableByCost(@PathVariable("from") int from, @PathVariable("to") int to){
        List<Table> tablesFound = tableProxy.retrieveTableByCost(from, to);
        return tablesFound;
    }
}
