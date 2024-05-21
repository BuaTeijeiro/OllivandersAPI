package edu.badpals.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="T_ITEMS")
public class Item extends PanacheEntityBase{
    @Id
    @Column(name="ID")
    int id;

    @Column(name="NOMBRE")
    String name;

    @Column(name="QUALITY")
    int quality;

    @Column(name="SELL_IN")
    int sellIn;

    @Column(name="TIPO")
    String tipo;

    public Item() {
    }

    public Item(String nombre, int sell_in, int quality, String tipo) {
        this.name = nombre;
        this.quality = quality;
        this.sellIn = sell_in;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sell_in) {
        this.sellIn = sell_in;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    };

}
