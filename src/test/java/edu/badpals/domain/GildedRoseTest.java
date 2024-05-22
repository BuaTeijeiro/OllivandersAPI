package edu.badpals.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void test_addItem(){
        GildedRose shop = new GildedRose();
        assertEquals(0,shop.getSize());

        shop.addItem(new NormalItem("+5 Dexterity Vest", 10, 20));
        shop.addItem(new AgedBrie("Aged Brie", 2, 0));
        shop.addItem(new NormalItem("Elixir of the Mongoose", 5, 7));
        shop.addItem(new Sulfuras("Sulfuras, Hand of Ragnaros", 0));
        shop.addItem(new Sulfuras("Sulfuras, Hand of Ragnaros", -1));
        shop.addItem(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        shop.addItem(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        shop.addItem(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        shop.addItem(new Conjured("Conjured Mana Cake", 3, 6));

        assertEquals(9,shop.getSize());
    }

    @Test
    void test_getItem(){
        GildedRose shop = new GildedRose();
        shop.addItem(new NormalItem("+5 Dexterity Vest", 10, 20));
        shop.addItem(new AgedBrie("Aged Brie", 2, 0));
        shop.addItem(new NormalItem("Elixir of the Mongoose", 5, 7));
        shop.addItem(new Sulfuras("Sulfuras, Hand of Ragnaros", 0));
        shop.addItem(new Sulfuras("Sulfuras, Hand of Ragnaros", -1));
        shop.addItem(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        shop.addItem(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        shop.addItem(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        shop.addItem(new Conjured("Conjured Mana Cake", 3, 6));

        AgedBrie expectedBrie = (AgedBrie) shop.getItem(1);
        assertEquals("Aged Brie",expectedBrie.getName());
        assertEquals(2,expectedBrie.getSellIn());
        assertEquals(0,expectedBrie.getQuality());

    }

    @Test
    void testUpdateItems(){
        GildedRose shop = new GildedRose();


        shop.addItem(new NormalItem("+5 Dexterity Vest", 10, 20));
        shop.addItem(new AgedBrie("Aged Brie", 2, 0));
        shop.addItem(new NormalItem("Elixir of the Mongoose", 5, 7));
        shop.addItem(new Sulfuras("Sulfuras, Hand of Ragnaros", 0));
        shop.addItem(new Sulfuras("Sulfuras, Hand of Ragnaros", -1));
        shop.addItem(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        shop.addItem(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        shop.addItem(new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        shop.addItem(new Conjured("Conjured Mana Cake", 3, 6));

        shop.updateItems();
        assertEquals(9,shop.getItem(0).getSellIn());
        assertEquals(19,shop.getItem(0).getQuality());
        assertEquals(1,shop.getItem(1).getSellIn());
        assertEquals(1,shop.getItem(1).getQuality());
        assertEquals(4,shop.getItem(2).getSellIn());
        assertEquals(6,shop.getItem(2).getQuality());
        assertEquals(0,shop.getItem(3).getSellIn());
        assertEquals(80,shop.getItem(3).getQuality());
        assertEquals(-1,shop.getItem(4).getSellIn());
        assertEquals(80,shop.getItem(4).getQuality());
        assertEquals(14,shop.getItem(5).getSellIn());
        assertEquals(21,shop.getItem(5).getQuality());
        assertEquals(9,shop.getItem(6).getSellIn());
        assertEquals(50,shop.getItem(6).getQuality());
        assertEquals(4,shop.getItem(7).getSellIn());
        assertEquals(50,shop.getItem(7).getQuality());
        assertEquals(2,shop.getItem(8).getSellIn());
        assertEquals(4,shop.getItem(8).getQuality());

    };



    }


