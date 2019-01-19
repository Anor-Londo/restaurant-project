package com.microservices.booking.bookingservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

//@FeignClient(name = "guest-service", url = "localhost:8001")
//@FeignClient(name = "guest-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "guest-service")
public interface GuestServiceProxy {

    @RequestMapping(value = "guest-service/guest/{id}", method = RequestMethod.GET)
    public GuestBean findGuestById(@PathVariable("id") int id);
}
