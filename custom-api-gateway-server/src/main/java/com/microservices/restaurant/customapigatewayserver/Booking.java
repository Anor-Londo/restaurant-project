package com.microservices.restaurant.customapigatewayserver;

public class Booking {

    private Integer id;
    private int tableId;
    private int guestId;
    private String time;

    public Booking(){

    }

    public Booking(int tableId, int guestId, String time) {
        this.tableId = tableId;
        this.guestId = guestId;
        this.time = time;
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
}
