package com.microservices.guest.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    private GuestRepository repository;

    @Autowired
    public void setRepository(GuestRepository repository) {
        this.repository = repository;
    }

    public GuestRepository getRepository() {
        return repository;
    }

    @Override
    public Guest createGuest(String name, String phone) {
        Guest guest = new Guest(name, phone, false);
        repository.save(guest);
        return null;
    }

    @Override
    public List<Guest> findByCharSequance(String cs) {
        List<Guest> guestsFound = new ArrayList<Guest>();
        Iterable<Guest> allPosts = repository.findAll();
        for (Guest guest: allPosts) {
            if (guest.getName().contains(cs) || guest.getPhone().contains(cs)){
                guestsFound.add(guest);
            }
        }
        return guestsFound;
    }

    @Override
    public void reserveGuest(int id) {
        repository.reserveGuest(id);
    }

    @Override
    public void cancelGuest(int id) {
        repository.cancelGuest(id);
    }
}
