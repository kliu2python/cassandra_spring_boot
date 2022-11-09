package com.cassandra.cassandra_datastax.controller;

import com.cassandra.cassandra_datastax.DAO.ShoppingCartDAO;
import com.cassandra.cassandra_datastax.model.ShoppingCart;
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
    public ShoppingCart getItemCounts(@RequestParam String uid) {
        ShoppingCart res = new ShoppingCart();
        try {
            res = service.getShoppingCartByUID(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public void createShoppingCart() {
        try {
            service.saveShoppingCart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
