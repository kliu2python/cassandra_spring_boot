package com.cassandra.cassandra_datastax.DAO;

import com.cassandra.cassandra_datastax.model.ShoppingCart;
import com.datastax.oss.driver.api.mapper.annotations.*;


@Dao
public interface ShoppingCartDAO {
   @Select
   ShoppingCart findByUserId();

   @Insert
   void save(ShoppingCart cart);

   @Delete
   void delete(ShoppingCart cart);

   @Query("SELECT * FROM store.shopping_cart WHERE userid = :id")
   ShoppingCart findByID(String id);
}
