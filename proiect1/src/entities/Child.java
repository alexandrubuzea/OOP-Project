package entities;

import enums.AgeCategory;
import enums.Category;
import enums.Cities;
import input.ChildInputData;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private final String lastName;

    public String getLastName() {
        return lastName;
    }

    private final String firstName;

    public String getFirstName() {
        return firstName;
    }

    private final int id;

    public int getId() {
        return id;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void incrementAge() {
        ++age;
    }

    private final Cities city;

    public Cities getCity() {
        return city;
    }

    private List<Double> niceScores;

    public List<Double> getNiceScores() {
        return niceScores;
    }

    private List<Category> giftsPreferences;

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void addNewPreferences(List<Category> toAdd) {
        for (Category category : toAdd) {
            this.giftsPreferences.removeIf(category::equals);
        }

        List<Category> newPreferences = new ArrayList<>();
        newPreferences.addAll(toAdd);
        newPreferences.addAll(this.giftsPreferences);

        this.giftsPreferences = newPreferences;
    }

    public Child(ChildInputData child) {
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.id = child.getId();
        this.age = child.getAge();
        this.city = child.getCity();
        this.giftsPreferences = child.getGiftsPreferences();
        this.niceScores = new ArrayList<>();
        this.niceScores.add(child.getNiceScore());
    }

    public AgeCategory getAgeCategory() {
        return AgeCategory.getAgeCategory(this.age);
    }

    public void applyChange(ChildUpdate update) {
        if (update.getNiceScore() != null) {
            this.niceScores.add(update.getNiceScore());
        }

        this.addNewPreferences(update.getNewPreferences());
    }
}
