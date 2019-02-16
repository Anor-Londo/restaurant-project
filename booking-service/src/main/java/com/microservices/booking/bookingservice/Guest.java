package com.microservices.booking.bookingservice;

public class Guest {

    private Integer id;
    private String name;
    private String phone;
    private boolean reserved;

    public Guest(){

    }

    public Guest(String name, String phone, boolean reserved) {
        this.name = name;
        this.phone = phone;
        this.reserved = reserved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
