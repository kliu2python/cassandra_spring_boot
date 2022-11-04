package com.cassandra.cassandra_datastax.cql;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;


public class CqlSessionConnection {
    private CqlSession session;

    public void connect() {
        CqlSessionBuilder builder = CqlSession.builder();

        session = builder
                .withConfigLoader(DriverConfigLoader.fromClasspath("application.conf"))
                .build();
    }

    public CqlSession getSession() {
        return this.session;
    }

    public void exitSession() {
        session.close();
    }
}
