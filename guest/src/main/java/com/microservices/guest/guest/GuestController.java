package com.microservices.guest.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GuestController {

    private GuestRepository repository;
    private GuestService service;

    public GuestRepository getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(GuestRepository repository) {
        this.repository = repository;
    }

    public GuestService getService() {
        return service;
    }

    @Autowired
    public void setService(GuestService service) {
        this.service = service;
    }

    @RequestMapping(value = "guest", method = RequestMethod.GET)
    public Iterable<Guest> retrieveAllGuests(){
        return repository.findAll();
    }

    @RequestMapping(value = "guest/{id}", method = RequestMethod.GET)
    public Optional<Guest> findGuestById(@PathVariable int id){
        return repository.findById(id);
    }

    @RequestMapping(value = "guest/find/{cs}", method = RequestMethod.GET)
    public List<Guest> findGuests(@PathVariable String cs){
        List<Guest> guests = service.findByCharSequance(cs);
        return guests;
    }

    @RequestMapping(value = "guest/create", method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Guest createGuest(@RequestBody Guest request){
    Guest guest = service.createGuest(request.getName(), request.getPhone());
    return null;
    }
}
