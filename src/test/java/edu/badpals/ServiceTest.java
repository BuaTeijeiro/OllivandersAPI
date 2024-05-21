package edu.badpals;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;

@QuarkusTest
public class ServiceTest {
     @PersistenceContext
    jakarta.persistence.EntityManager em;

    @Inject
    Service servicio;

    @Test
    void updateDatabaseTest(){
        servicio.updateDatabase();
    }
}
