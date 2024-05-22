package edu.badpals.domain;

public class BackstagePass implements Updateable{
    private Item item;

    public BackstagePass(String name, int sellIn, int quality){
        this.item = new Item(name,sellIn,quality,"BACKSTAGE PASS");
    }

    

    public BackstagePass(Item item) {
        this.item = item;
    }



    public String getName() {
        return item.name;
    }

    public int getQuality() {
        return item.quality;
    }

    @Override
    public int getSellIn() {
        return this.item.sellIn;
    }

    @Override
    public void setSellIn(int newSellIn) {
        this.item.sellIn = newSellIn;
    }
    public void setName(String newName) {
        this.item.name = newName;
    }

    public void setQuality(int newQuality) {
        this.item.quality = newQuality;
    }

    @Override
    public void updateQuality() {
        if(getSellIn()>10){
            setQuality(getQuality()+1);
        } else if (getSellIn()<=10 && getSellIn()>5) {
            setQuality(getQuality()+2);
        } else if (getSellIn()<=5 && getSellIn()>=0) {
            setQuality(getQuality()+3);
        } else if (getSellIn()<0) {
            setQuality(0);
        }
        if(getQuality()>50){
            setQuality(50);
        }
    }
    @Override
    public String toString() {
        return this.item.toString();
    }
}
