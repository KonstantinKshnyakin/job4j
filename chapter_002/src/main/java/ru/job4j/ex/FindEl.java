package ru.job4j.ex;

public class FindEl {

    public static void main(String[] args) {
        try {
            FindEl.indexOf(new String[]{"Len", "Tort"}, "Jon");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException{
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element not found in array");
    }
}
