package edu.badpals.domain;

public class Conjured implements Updateable {
    private Item item;

    public Conjured(String name, int sellIn, int quality){
        this.item = new Item(name, sellIn, quality, "CONJURED");
    }

    public Conjured(Item item) {
        this.item = item;
    }

    public String getName(){
        return this.item.name;
    }

    public int getSellIn(){
        return this.item.sellIn;
    }

    public int getQuality(){
        return this.item.quality;
    }

    public void setName(String newName){
        this.item.name = newName;
    }

    public void setSellIn(int newSellIn){
        this.item.sellIn = newSellIn;
    }

    public void setQuality(int newQuality){
        this.item.quality = newQuality;
    }

    @Override
    public void updateQuality() {
        if(getSellIn() >= 0){
            setQuality(getQuality() - 2);
        } else {
            setQuality(getQuality() - 4);
        }

        if(getQuality()<0){
            setQuality(0);
        }

    }
    @Override
    public String toString() {
        return this.item.toString();
    }

}
