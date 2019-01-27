package com.microservices.restaurant.customapigatewayserver;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface GatewayService {
    public Booking add(int tableId, int guestId, Booking booking);
}
