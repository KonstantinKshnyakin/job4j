package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 464);
        Book rebelBiography = new Book("Быть Этони Хопкинсом", 546);
        Book feynman = new Book("Вы наверно шутите мистер фейман", 246);
        Book foldOfTime = new Book("Складка времен", 282);

        Book[] library = new Book[4];
        library[0] = cleanCode;
        library[1] = rebelBiography;
        library[2] = feynman;
        library[3] = foldOfTime;

        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i].getName() + " - " + library[i].getNumberOfPages());
        }

        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;

        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i].getName() + " - " + library[i].getNumberOfPages());
        }

        for (int i = 0; i < library.length; i++) {
            if (library[i].getName().equals("Clean Code")) {
                System.out.println(library[i].getName( ) + " - " + library[i].getNumberOfPages( ));
            }
        }


    }
}
