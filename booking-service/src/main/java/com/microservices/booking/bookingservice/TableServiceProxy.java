package com.microservices.booking.bookingservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

//@FeignClient(name = "table-service", url = "localhost:8000")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "guest-service")
public interface TableServiceProxy {

    @RequestMapping(value = "table-service/table/{id}", method = RequestMethod.GET)
    public TableBean retrieveOneTable(@PathVariable("id") int id);
}
