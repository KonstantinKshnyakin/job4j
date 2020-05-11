package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> contName = p -> p.getName().contains(key);
        Predicate<Person> contSurname = p -> p.getSurname().contains(key);
        Predicate<Person> contAddress = p -> p.getAddress().contains(key);
        Predicate<Person> contPhone = p -> p.getPhone().contains(key);
        Predicate<Person> combine = contName.or(contSurname).or(contAddress).or(contPhone);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
