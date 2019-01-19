package com.microservices.booking.bookingservice;

import java.util.List;

public interface BookingService {
    List<Booking> findBookedTables(int tableId);
    Booking findBookedGuest(int guestId);
}
