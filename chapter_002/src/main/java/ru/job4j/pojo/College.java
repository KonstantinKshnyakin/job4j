package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student kolay = new Student( );
        kolay.setName("Николай");
        kolay.setMiddleName("Павлович");
        kolay.setLastName("Якут");
        kolay.setGroup("СГН-221");
        kolay.setReceiptDate("10.08.2017");
        System.out.println("Имя : " + kolay.getName() + "\n" +
                "Отчество : " + kolay.getMiddleName() + "\n" +
                "Фомилия : " + kolay.getLastName() + "\n" +
                "Группа : " + kolay.getGroup()+ "\n" +
                "Дата поступления : " + kolay.getReceiptDate());
    }
}
