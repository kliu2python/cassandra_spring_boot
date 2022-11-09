package com.cassandra.cassandra_datastax.mapper;

import com.cassandra.cassandra_datastax.DAO.ShoppingCartDAO;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.MapperBuilder;
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper {
    @DaoFactory
    ShoppingCartDAO shoppingCartDao();

    static MapperBuilder<ShoppingCartMapper> builder(CqlSession session) {
        return new ShoppingCartMapperBuilder(session);
    }
}
