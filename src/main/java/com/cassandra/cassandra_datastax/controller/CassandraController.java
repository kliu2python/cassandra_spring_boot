package com.cassandra.cassandra_datastax.controller;

import com.cassandra.cassandra_datastax.service.ProductService;
import com.datastax.oss.driver.api.core.cql.ExecutionInfo;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")
public class CassandraController {
    @Autowired
    private ProductService service;

    @RequestMapping(value = "/item/counts", method = RequestMethod.GET)
    public int getItemCounts(@RequestParam int uid) {
        int res = 0;
        try {
            res = service.getItemsCount(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
