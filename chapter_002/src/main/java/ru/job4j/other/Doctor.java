package ru.job4j.other;

public class Doctor extends Profession {

    private boolean license;
    private int experience;

    public boolean isLicense() {
        return license;
    }

    public int getExperience() {
        return experience;
    }

    public Diagnose heal(Pacient pacient) {
        return new Diagnose();
    }

    public Recipe getRecipe(String complaints) {
        return new Recipe();
    }
}
