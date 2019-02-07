package com.microservices.restaurantservice.restaurantservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements TableService {

    private TableRepository repository;

    @Autowired
    public void setRepository(TableRepository repository) {
        this.repository = repository;
    }

        public TableRepository getRepository() {
        return repository;
    }

    @Override
    public List<Table> findBetweenCost(int from, int to) {

        List<Table> tablesFound = new ArrayList<Table>();
        Iterable<Table> allTables = repository.findAll();
        for (Table table: allTables) {
            if (table.getCost() > from && table.getCost() < to){
                tablesFound.add(table);
            }
        }
        return tablesFound;
    }

    @Override
    public List<Table> findByCapacity(int capaity) {

        List<Table> tablesFound = new ArrayList<Table>();
        Iterable<Table> allTables = repository.findAll();
        for (Table table: allTables) {
            if (table.getCapacity() == capaity){
                tablesFound.add(table);
            }
        }
        return tablesFound;
    }

    @Override
    public void reserveTable(int id) {
        repository.reserveTable(id);
    }


}
