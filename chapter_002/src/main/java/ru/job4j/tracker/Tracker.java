package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    /**
     * Лист для хранения заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод добавления заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
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
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    /**
     * Метод возвращает массив Item`ов с необходимым именем заявки.
     * @param key имя необходимой заявки
     * @return массив Item.
     */
    public List<Item> findByName(String key) {
        List<Item> itemWithoutNull = new ArrayList<>(items.size());
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemWithoutNull.add(item);
            }
        }
        return List.copyOf(itemWithoutNull);
    }

    /**
     * Метод возвращает Item если он найден, если не найден возвращает null.
     * @param id id заявки
     * @return массив Item or null.
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(items.get(index).getId());
        items.set(index, item);
        return true;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                return index;
            }
        }
        return rsl;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        return true;
    }
}
