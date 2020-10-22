package ru.job4j.tracker;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item implements Comparable<Item> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ' ' + name;
    }

    @Override
    public int compareTo(Item item) {
        return this.getName().compareTo(item.getName());
    }
}
