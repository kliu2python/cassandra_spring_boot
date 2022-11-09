package com.cassandra.cassandra_datastax.model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@CqlName("shopping_cart")
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    @PartitionKey
    private String userid;
    private int itemCount;
    private Instant lastUpdateTimestamp;
}
