package com.microservices.restaurant.customapigatewayserver;

public class Booking {

    private Integer id;
    private int tableId;
    private int guestId;
    private String time;
    private String guestName;
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
}
