package edu.badpals;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@QuarkusTest
public class ServiceTest {
     @PersistenceContext
    jakarta.persistence.EntityManager em;

    @Inject
    Service servicio;

    @Test
    @Transactional
    void updateDatabaseTest(){
        servicio.updateDatabase();
    }
}
