package edu.badpals;

import org.junit.jupiter.api.Test;

import edu.badpals.domain.Item;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@QuarkusTest
public class ServiceTest {
     @PersistenceContext
    jakarta.persistence.EntityManager em;

    @Inject
    Service servicio;

    @Test
    @Transactional
    void updateDatabaseTest(){
        List<Item> items = Item.getAllItems();
        int quality0 = items.get(0).getQuality();
        int quality1 = items.get(1).getQuality();
        servicio.updateDatabase();
        assertEquals(quality0 - 1, items.get(0).getQuality());
        assertEquals(quality1 + 2, items.get(1).getQuality());
    }

    @Test
    @Transactional
    void createItemTest(){
        long initialItemCount = Item.count();
        servicio.createItem("Magic Pasta",10, 25, "NORMAL");
        assertEquals(initialItemCount + 1, Item.count());
    }

    @Test
    @Transactional
    void createAndUpdateItemTest(){
        servicio.createItem("Magic Pasta",10, 25, "NORMAL");
        servicio.updateDatabase();
        Item item = Item.getAllItems().getLast();
        assertEquals(9, item.getSellIn());
        assertEquals(24, item.getQuality());
    }

    @Test
    @Transactional
    void deleteItemTest(){
        long initialItemCount = Item.count();
        servicio.createItem("Magic Pasta",10, 25, "NORMAL");
        assertEquals(initialItemCount + 1, Item.count());
        Item item = Item.getAllItems().getLast();
        servicio.delete(item);
        assertEquals(initialItemCount, Item.count());

    }
}
