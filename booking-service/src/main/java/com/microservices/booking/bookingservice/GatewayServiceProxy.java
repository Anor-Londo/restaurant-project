package com.microservices.booking.bookingservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "custom-api-gateway-service", url = "localhost:8090")
public interface GatewayServiceProxy {

    @RequestMapping(value = "booking-service/booking/table/{tableId}/guest/{guestId}", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void add(@PathVariable int tableId, @PathVariable int guestId, @RequestBody Booking booking);
}
