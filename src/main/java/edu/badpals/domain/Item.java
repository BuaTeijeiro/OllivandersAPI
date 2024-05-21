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
    String nombre;

    @Column(name="QUALITY")
    int quality;

    @Column(name="SELL_IN")
    int sell_in;

    @Column(name="TIPO")
    String tipo;

    public Item() {
    }

    public Item(String nombre, int quality, int sell_in, String tipo) {
        this.nombre = nombre;
        this.quality = quality;
        this.sell_in = sell_in;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSell_in() {
        return sell_in;
    }

    public void setSell_in(int sell_in) {
        this.sell_in = sell_in;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    };

}
