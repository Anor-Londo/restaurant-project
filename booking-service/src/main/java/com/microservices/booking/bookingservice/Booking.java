package com.microservices.booking.bookingservice;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "table_id")
    private int tableId;

    @Column(name = "guest_id")
    private int guestId;

    @Column(name = "time")
    private String time;

    @Column(name = "guest_name")
    private String guestName;

    @Column(name = "table_number")
    private int tableNumber;

    public Booking(){

    }

    public Booking(int tableId, int guestId, String time, String guestName, int tableNumber) {
        this.tableId = tableId;
        this.guestId = guestId;
        this.time = time;
        this.guestName = guestName;
        this.tableNumber = tableNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", tableId=" + tableId +
                ", guestId=" + guestId +
                ", time='" + time + '\'' +
                ", guestName=" + guestName +
                ", tableNumber"+ tableNumber +
                '}';
    }
}
