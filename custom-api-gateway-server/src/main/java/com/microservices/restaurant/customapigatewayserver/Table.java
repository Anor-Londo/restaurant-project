package com.microservices.restaurant.customapigatewayserver;

public class Table {

    private Integer id;
    private int capacity;
    private int cost;
    private boolean reserved;
    private int tableNumber;

    public Table(){

    }

    public Table(int capacity, int cost, boolean reserved, int tableNumber) {
        this.capacity = capacity;
        this.cost = cost;
        this.reserved = reserved;
        this.tableNumber = tableNumber;
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

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}
