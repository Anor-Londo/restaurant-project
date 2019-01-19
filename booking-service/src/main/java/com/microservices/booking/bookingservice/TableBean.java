package com.microservices.booking.bookingservice;

public class TableBean {

    private Integer id;
    private int capacity;
    private int cost;

    public TableBean(){

    }

    public TableBean(int capacity, int cost) {
        this.capacity = capacity;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
