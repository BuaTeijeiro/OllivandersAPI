package edu.badpals.domain;

import java.util.List;

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
        assertEquals("Aged Brie", item.getName());
        assertEquals("AGED BRIE", item.getTipo());
    }

    @Test
    public void getAllTest(){
        List<Item> items =  Item.getAllItems();
        assertEquals(Item.count(), items.size());
    }

    @Test
    public void getItemsByNameTest_OneItem(){
        List<Item> items = Item.getItemsByName("Aged Brie");
        assertEquals(1, items.size());
    }

}
