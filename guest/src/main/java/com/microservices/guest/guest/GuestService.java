package com.microservices.guest.guest;

import java.util.List;

public interface GuestService {
    Guest createGuest(String name, String phone);
    List<Guest> findByCharSequance(String cs);
    void reserveGuest(int id);
    void cancelGuest(int id);
}
