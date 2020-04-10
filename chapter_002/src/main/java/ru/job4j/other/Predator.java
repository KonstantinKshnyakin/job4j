package ru.job4j.other;

import ru.job4j.other.Animal;

public class Predator extends Animal {

    public Predator() {
        super();
        System.out.println("Predator");
    }

    public Predator(String name) {
        super(name);
    }
}
