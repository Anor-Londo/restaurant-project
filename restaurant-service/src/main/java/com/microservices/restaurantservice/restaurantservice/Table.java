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

    public Table(){

    }

    public Table(int capacity, int cost) {
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

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", cost=" + cost +
                '}';
    }
}
