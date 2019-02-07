package com.microservices.restaurantservice.restaurantservice;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TableRepository extends CrudRepository<Table, Integer> {

    @Transactional
    @Modifying
    @Query("update Table set reserved = true where id = :id")
    Integer reserveTable(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update Table set reserved = false where id = :id")
    Integer cancelTable(@Param("id") Integer id);
}
