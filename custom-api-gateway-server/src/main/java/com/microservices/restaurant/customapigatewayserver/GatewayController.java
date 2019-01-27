package com.microservices.restaurant.customapigatewayserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GatewayController {

    private GuestServiceProxy guestProxy;
    private TableServiceProxy tableProxy;
    private BookingServiceProxy bookingProxy;

    private GatewayService gatewayService;

    public GuestServiceProxy getGuestProxy() {
        return guestProxy;
    }

    @Autowired
    public void setGuestProxy(GuestServiceProxy guestProxy) {
        this.guestProxy = guestProxy;
    }

    public TableServiceProxy getTableProxy() {
        return tableProxy;
    }

    @Autowired
    public void setTableProxy(TableServiceProxy tableProxy) {
        this.tableProxy = tableProxy;
    }

    public BookingServiceProxy getBookingProxy() {
        return bookingProxy;
    }

    @Autowired
    public void setBookingProxy(BookingServiceProxy bookingProxy) {
        this.bookingProxy = bookingProxy;
    }

    //-----------------------------------------------------------------------------------//

    @RequestMapping(value = "booking-service/booking/table/{tableId}/guest/{guestId}", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Booking add(@PathVariable int tableId, @PathVariable int guestId, @RequestBody Booking booking){

        Booking newBooking = gatewayService.add(tableId, guestId, booking);
        repository.save(newBooking);
        return newBooking;
    }

    @RequestMapping(value = "guest-service/guest/{id}", method = RequestMethod.GET)
    public Guest retrieveGuestById(@PathVariable int id){
        Guest guest = guestProxy.findGuestById(id);
        return guest;
    }
}
