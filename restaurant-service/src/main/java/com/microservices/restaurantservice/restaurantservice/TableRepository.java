package com.microservices.restaurantservice.restaurantservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends CrudRepository<Table, Integer> {
}
