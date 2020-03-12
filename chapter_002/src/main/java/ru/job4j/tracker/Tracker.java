package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод возвращает массив Item`ов без null ячеек.
     * @return массив Item.
     */
    public Item[] findAll() {
        Item[] itemWithoutNull = new Item[position];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item != null) {
                itemWithoutNull[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemWithoutNull, size);
    }

    /**
     * Метод возвращает массив Item`ов с необходимым именем заявки.
     * @param key имя необходимой заявки
     * @return массив Item.
     */
    public Item[] findByName(String key) {
        Item[] itemWithoutNull = new Item[position];
        int size = 0;
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                itemWithoutNull[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemWithoutNull, size);
    }

    /**
     * Метод возвращает Item если он найден, если не найден возвращает null.
     * @param id id заявки
     * @return массив Item or null.
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public void replace(String id, Item item) {
        int index = indexOf(id);
        item.setId(items[index].getId());
        items[index] = item;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                return index;
            }
        }
        return rsl;
    }
}
