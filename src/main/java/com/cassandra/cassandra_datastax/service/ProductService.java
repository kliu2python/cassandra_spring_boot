package com.cassandra.cassandra_datastax.service;

import com.cassandra.cassandra_datastax.DAO.ShoppingCartDAO;
import com.cassandra.cassandra_datastax.cql.CqlSessionConnection;
import com.cassandra.cassandra_datastax.model.ShoppingCart;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ExecutionInfo;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    ShoppingCartDAO query;

    CqlSessionConnection connection = new CqlSessionConnection();
    Logger logger = LoggerFactory.getLogger(ProductService.class);
    private CqlSession session;

    ProductService() {
        connection.connect();
        session = connection.getSession();
    }

    public int getItemsCount(int uid) throws Exception {
        int count = 0;

        if (session == null) {
            connection.connect();
            session = connection.getSession();
        }

        ResultSet res = session.execute(query.findItemCountById(uid));

        Row row = res.one();

        if (row != null) {
            count = row.getInt("item_count");
        } else {
            logger.error("An error occurs");
            throw new Exception("Wrong ID was gave, please check it");
        }

        connection.exitSession();
        return count;
    }
}

