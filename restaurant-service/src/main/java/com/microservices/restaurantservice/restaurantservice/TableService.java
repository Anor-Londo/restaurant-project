package com.microservices.restaurantservice.restaurantservice;

import java.util.List;

public interface TableService {
    List<Table> findBetweenCost(int from, int to);
    List<Table> findByCapacity(int capacity);
    void reserveTable(int id);
    void cancelTable(int id);
}
