package com.microservices.restaurant.customapigatewayserver;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(name = "guest-service", url = "localhost:8001")
public interface GuestServiceProxy {

    @RequestMapping(value = "guest/{id}", method = RequestMethod.GET)
    public Guest findGuestById(@PathVariable("id") int id);
}
