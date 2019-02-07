package com.microservices.booking.bookingservice;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

    @Transactional
    @Query("select tableId from Booking where id = :id")
    Integer findTableId(@Param("id") Integer id);
}
