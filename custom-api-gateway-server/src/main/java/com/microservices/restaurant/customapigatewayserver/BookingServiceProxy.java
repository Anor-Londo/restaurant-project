package com.microservices.restaurant.customapigatewayserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(name = "booking-service", url = "localhost:8002")
public interface BookingServiceProxy {

    @RequestMapping(value = "booking/add", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Booking add(@RequestBody Booking booking);

    @RequestMapping(value = "booking", method = RequestMethod.GET)
    public Iterable<Booking> retrieveAllBookings();

    @RequestMapping(value = "booking/{id}", method = RequestMethod.GET)
    public Optional<Booking> retrieveBookingById(@PathVariable("id") int id);

    @RequestMapping(value = "booking/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBookingById(@PathVariable("id") int id);

    @RequestMapping(value = "booking/tableId/{id}", method = RequestMethod.GET)
    public Integer retrieveReservedTable(@PathVariable("id") int id);

}
