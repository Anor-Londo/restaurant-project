package com.microservices.restaurantservice.restaurantservice;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends CrudRepository<Table, Integer> {

    @Modifying
    @Query("update rest set reserved = true where id = :id")
    Table reserveTable(@Param("tableId") Integer id);
}
