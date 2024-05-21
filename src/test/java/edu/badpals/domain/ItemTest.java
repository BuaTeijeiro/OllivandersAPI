package edu.badpals.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.persistence.PersistenceContext;

@QuarkusTest
public class ItemTest {
    @PersistenceContext
    jakarta.persistence.EntityManager em;

    @Test
    public void mapping_item(){
        Item item = em.find(Item.class, 2);
        assertNotNull(item);
        assertEquals("Aged Brie", item.getNombre());
        assertEquals(2, item.getQuality());
        assertEquals(0, item.getSell_in());
        assertEquals("AGED BRIE", item.getTipo());
    }

}
