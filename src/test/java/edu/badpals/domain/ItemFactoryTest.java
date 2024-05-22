package edu.badpals.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class ItemFactoryTest {

    @Test
    void createNormalItem(){
        Item item = new Item("Pasta", 20, 10, "NORMAL");
        Updateable normal = ItemFactory.makeItem(item);
        assertTrue(normal instanceof NormalItem);
        normal.updateItem();
        assertEquals(19, normal.getSellIn());
        assertEquals(9, normal.getQuality());
    }

    @Test
    void createAgedBrie(){
        Item item = new Item("Aged Brie", -2, 10, "AGED BRIE");
        Updateable normal = ItemFactory.makeItem(item);
        assertTrue(normal instanceof AgedBrie);
        normal.updateItem();
        assertEquals(-3, normal.getSellIn());
        assertEquals(12, normal.getQuality());
    }

    @Test
    void createConjured(){
        Item item = new Item("Pasta", 20, 10, "CONJURED");
        Updateable normal = ItemFactory.makeItem(item);
        assertTrue(normal instanceof Conjured);
        normal.updateItem();
        assertEquals(19, normal.getSellIn());
        assertEquals(8, normal.getQuality());
    }

    @Test
    void createBackstage(){
        Item item = new Item("BS", 3, 20, "BACKSTAGE PASS");
        Updateable normal = ItemFactory.makeItem(item);
        assertTrue(normal instanceof BackstagePass);
        normal.updateItem();
        assertEquals(2, normal.getSellIn());
        assertEquals(23, normal.getQuality());
    }

    @Test
    void createSulfuras(){
        Item item = new Item("sulfuras", 3, 80, "SULFURAS");
        Updateable normal = ItemFactory.makeItem(item);
        assertTrue(normal instanceof Sulfuras);
        normal.updateItem();
        assertEquals(3, normal.getSellIn());
        assertEquals(80, normal.getQuality());
    }

    @Test
    void createInvalidType(){
        Item item = new Item("sulfuras", 3, 80, "SULFURA");
        Updateable normal = ItemFactory.makeItem(item);
        assertNull(normal);
    }

    @Test
    void conexionBaseDeDatos(){
        List<Item> items = Item.listAll();
        List<Updateable> updateables = new ArrayList<>();
        for (Item item: items){
            updateables.add(ItemFactory.makeItem(item));
        }
        assertTrue(updateables.get(0) instanceof NormalItem);
        assertTrue(updateables.get(1) instanceof AgedBrie);
        assertTrue(updateables.get(2) instanceof NormalItem);
        assertTrue(updateables.get(3) instanceof Sulfuras);
        assertTrue(updateables.get(4) instanceof Sulfuras);
        assertTrue(updateables.get(5) instanceof BackstagePass);
        assertTrue(updateables.get(6) instanceof BackstagePass);
        assertTrue(updateables.get(7) instanceof BackstagePass);
        assertTrue(updateables.get(8) instanceof Conjured);
    }
}
