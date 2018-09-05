package com.escuela.flyway.migration;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;

public class FlywayConfiguration {

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        final Flyway flyway = new Flyway();
//        flyway.setDataSource(this.dataSource());
        flyway.setDataSource("jdbc:mysql://localhost:3306/flyway", "flyway", "flyway123*");
        flyway.setLocations("filesystem:src/main/resources/db/migration");
        return flyway;
    }
}

