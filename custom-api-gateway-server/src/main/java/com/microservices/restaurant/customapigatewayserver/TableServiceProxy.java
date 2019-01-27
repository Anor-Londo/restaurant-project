package com.microservices.restaurant.customapigatewayserver;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "table-service", url = "localhost:8000")
public interface TableServiceProxy {

    @RequestMapping(value = "table/{id}", method = RequestMethod.GET)
    public Table retrieveOneTable(@PathVariable("id") int id);
}
