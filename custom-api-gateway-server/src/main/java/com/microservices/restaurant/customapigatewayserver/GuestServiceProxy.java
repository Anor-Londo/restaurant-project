package com.microservices.restaurant.customapigatewayserver;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "guest-service", url = "localhost:8001")
public interface GuestServiceProxy {

    @RequestMapping(value = "guest/{id}", method = RequestMethod.GET)
    public Guest findGuestById(@PathVariable("id") int id);

    @RequestMapping(value = "guest", method = RequestMethod.GET)
    public Iterable<Guest> retrieveAllGuests();

    @RequestMapping(value = "guest/find/{cs}", method = RequestMethod.GET)
    public List<Guest> findGuests(@PathVariable("cs") String cs);

    @RequestMapping(value = "guest/create", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Guest createGuest(@RequestBody Guest request);

    @RequestMapping(value = "guest/reserve/{id}", method = RequestMethod.PUT)
    public void reserveGuest(@PathVariable("id") int id);

    @RequestMapping(value = "guest/cancel/{id}", method = RequestMethod.PUT)
    public void cancelGuest(@PathVariable("id") int id);
}
