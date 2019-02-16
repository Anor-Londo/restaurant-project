package com.microservices.restaurantservice.restaurantservice;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "rest")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "cost")
    private int cost;

    @Column(name = "reserved")
    private boolean reserved;

    @Column(name = "table_number")
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

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", cost=" + cost +
                ", reserved=" + reserved +
                ", tableNumber=" + tableNumber +
                '}';
    }
}
