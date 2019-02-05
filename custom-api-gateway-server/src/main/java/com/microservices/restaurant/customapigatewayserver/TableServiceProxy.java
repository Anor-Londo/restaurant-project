package com.microservices.restaurant.customapigatewayserver;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "table-service", url = "localhost:8000")
public interface TableServiceProxy {

    @RequestMapping(value = "table", method = RequestMethod.GET)
    public Iterable<Table> retrieveAllTables();

    @RequestMapping(value = "table/{id}", method = RequestMethod.GET)
    public Table retrieveOneTable(@PathVariable("id") int id);

    @RequestMapping(value = "table/capacity/{capacity}", method = RequestMethod.GET)
    public List<Table> retrieveTableByCapacity(@PathVariable("capacity") int capacity);

    @RequestMapping(value = "table/cost/from/{from}/to/{to}", method = RequestMethod.GET)
    public List<Table> retrieveTableByCost(@PathVariable("from") int from, @PathVariable("to") int to);

}
