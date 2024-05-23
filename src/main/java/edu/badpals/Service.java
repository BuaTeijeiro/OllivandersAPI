package edu.badpals;

import edu.badpals.domain.GildedRose;
import edu.badpals.domain.Item;
import edu.badpals.domain.ItemFactory;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class Service {

    @PersistenceContext
    jakarta.persistence.EntityManager em;

    Service(){}

    @Transactional
    public void updateDatabase(){
        GildedRose shop = new GildedRose();
        List<Item> items = Item.getAllItems();
        for (Item item: items){
            shop.addItem(ItemFactory.makeItem(item));
        }
        shop.updateItems();
    }

    @Transactional 
    void createItem(String name, int sell_in, int quality, String tipo){
        Item newItem = new Item(name, sell_in, quality, tipo);
        newItem.persist();
    }

    public void delete(Item item) {
        item.delete();
    }
}
