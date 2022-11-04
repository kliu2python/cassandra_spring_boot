package com.cassandra.cassandra_datastax.DAO;

import com.cassandra.cassandra_datastax.model.ShoppingCart;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDAO {

    public String findItemCountById(int id) {
        return String.format("SELECT * FROM store.shopping_cart WHERE userid='%s';", id);
    }
}
