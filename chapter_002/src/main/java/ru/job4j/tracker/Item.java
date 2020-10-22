package ru.job4j.tracker;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "items")
public class Item implements Comparable<Item> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Timestamp created;

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, String description, Timestamp created) {
        this.name = name;
        this.description = description;
        this.created = created;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", description='" + description + '\''
                + ", created=" + created
                + '}';
    }

    @Override
    public int compareTo(Item item) {
        return this.getName().compareTo(item.getName());
    }
}
