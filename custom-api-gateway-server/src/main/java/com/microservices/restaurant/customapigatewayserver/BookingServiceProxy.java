package com.microservices.restaurant.customapigatewayserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "booking-service", url = "localhost:8002")
public interface BookingServiceProxy {

    @RequestMapping(value = "booking/table/{tableId}/guest/{guestId}", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Booking add(@PathVariable("tableId") int tableId,
                       @PathVariable("guestId") int guestId,
                       @RequestBody Booking booking);
}
