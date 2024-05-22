package edu.badpals.domain;

public interface Updateable {
    public int getSellIn();
    public void setSellIn(int newSellIn);
    public int getQuality();

    public default void updateSellIn(){
        setSellIn(getSellIn() - 1);
    }

    public void updateQuality();
    
    public default void updateItem(){
        updateSellIn();
        updateQuality();
    }

}
