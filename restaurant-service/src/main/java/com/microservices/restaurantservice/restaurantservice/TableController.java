package com.microservices.restaurantservice.restaurantservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TableController {

    @Autowired
    private TableRepository repository;

    @Autowired
    private TableService service;

    @RequestMapping(value = "table", method = RequestMethod.GET)
    public Iterable<Table> retrieveAllTables() {
        return repository.findAll();
    }

    @RequestMapping(value = "table/{id}", method = RequestMethod.GET)
    public Optional<Table> retrieveOneTable(@PathVariable int id){
        return repository.findById(id);
    }

    @RequestMapping(value = "table/capacity/{capacity}", method = RequestMethod.GET)
    public List<Table> retrieveTableByCapacity(@PathVariable int capacity){
        List<Table> tables = service.findByCapacity(capacity);
        return tables;
    }

    @RequestMapping(value = "table/cost/from/{from}/to/{to}", method = RequestMethod.GET)
    public List<Table> retrieveTableByCost(@PathVariable int from, @PathVariable int to){
        List<Table> tables = service.findBetweenCost(from, to);
        return tables;
    }

    @RequestMapping(value = "table/reserve/{id}", method = RequestMethod.PUT)
    public void reserveTable(@PathVariable int id){
        service.reserveTable(id);
    }

    @RequestMapping(value = "table/cancel/{id}", method = RequestMethod.PUT)
    public void cancelGuest(@PathVariable int id){service.cancelTable(id);}
}
