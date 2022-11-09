package com.cassandra.cassandra_datastax.service;

import com.cassandra.cassandra_datastax.DAO.ShoppingCartDAO;
import com.cassandra.cassandra_datastax.cql.CqlSessionConnection;
import com.cassandra.cassandra_datastax.mapper.ShoppingCartMapper;
import com.cassandra.cassandra_datastax.model.ShoppingCart;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ProductService {
    CqlSessionConnection connection = new CqlSessionConnection();
    Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final CqlSession session;
    private final CqlIdentifier KEYSPACE_ID = CqlIdentifier.fromCql("store");
    ProductService() {
        connection.connect();
        session = connection.getSession();
    }

    public ShoppingCart getShoppingCartByUID(String uid) {
        ShoppingCartMapper shoppingCartMapper = ShoppingCartMapper
                .builder(session)
                .withDefaultKeyspace(KEYSPACE_ID)
                .build();
        ShoppingCartDAO shoppingCartDao = shoppingCartMapper.shoppingCartDao();
        return shoppingCartDao.findByID(uid);
    }

    public void saveShoppingCart() {
        ShoppingCartMapper shoppingCartMapper = ShoppingCartMapper
                .builder(session)
                .withDefaultKeyspace(KEYSPACE_ID)
                .build();
        ShoppingCartDAO shoppingCartDao = shoppingCartMapper.shoppingCartDao();
        Instant date = Instant.parse("2010-06-30T01:20:30Z");
        shoppingCartDao.save(new ShoppingCart("2121", 10, date));
    }
}

