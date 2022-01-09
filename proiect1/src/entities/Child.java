package entities;

import averagescore.ScoreStrategy;
import averagescore.ScoreStrategyFactory;
import enums.AgeCategory;
import enums.Category;
import enums.Cities;
import input.ChildInputData;

import java.util.ArrayList;
import java.util.List;

/**
 * A class used to retain the informations about a child (such as age, name, city etc) and that
 * has a number of useful methods in order to perform changes (such as finding out his age category
 * and add new gift preferences).
 */
public class Child {

    /**
     * The last name of the child.
     */
    private final String lastName;

    /**
     * A getter for the lastname field
     * @return a string which represents the lastname of the child
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * The firstname of the child.
     */
    private final String firstName;

    /**
     * A getter for the firstname field.
     * @return a string which represents the firstname of the child.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * The ID (unique identifier) of the child.
     */
    private final int id;

    /**
     * A getter for the ID field
     * @return an integer value representing the ID of the current child.
     */
    public int getId() {
        return id;
    }

    /**
     * The age of the child
     */
    private int age;

    /**
     * A getter for the age field
     * @return an integer value representing the age of the current child.
     */
    public int getAge() {
        return age;
    }

    /**
     * A method which increases the age of the current child (it is used when we perform an
     * annual change over the database)
     */
    public void incrementAge() {
        ++age;
    }

    /**
     * The city where the child lives
     */
    private final Cities city;

    /**
     * A getter for the city field
     * @return an enum value (Cities type) representing the city where the child lives.
     */
    public Cities getCity() {
        return city;
    }

    /**
     * A collection (list) of double values we use to store the niceScores a child receives.
     */
    private List<Double> niceScores;

    /**
     * A getter for the niceScores field.
     * @return a list of double values representing the niceScores the current child received.
     */
    public List<Double> getNiceScores() {
        return niceScores;
    }

    /**
     * A collection (list) which represents the gift preferences of a child (the categories he is
     * most interested in)
     */
    private List<Category> giftsPreferences;

    /**
     * A getter for the giftsPreferences field
     * @return a list of enum values (Category type) representing the gift preferences of a child.
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * A method which is used to add new gift preferences in the preferences list of the
     * current child
     * @param toAdd a list containing the new gift preferences a child has.
     */
    public void addNewPreferences(final List<Category> toAdd) {
        for (Category category : toAdd) {
            this.giftsPreferences.removeIf(category::equals);
        }

        List<Category> newPreferences = new ArrayList<>();

        // remove duplicate values from the new preferences
        newPreferences = new ArrayList<>(toAdd);
        newPreferences = new ArrayList<>(newPreferences.stream().distinct().toList());
        newPreferences.addAll(this.giftsPreferences);

        this.giftsPreferences = newPreferences;
    }

    /**
     * A constructor which builds a Child instance based on the input given (ChildInputData type)
     * @param child which represents the input given.
     */
    public Child(final ChildInputData child) {
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.id = child.getId();
        this.age = child.getAge();
        this.city = child.getCity();
        this.giftsPreferences = child.getGiftsPreferences();

        // remove duplicate values from the preferences list.
        this.giftsPreferences = new ArrayList<>(this.giftsPreferences.stream()
                .distinct().toList());
        this.niceScores = new ArrayList<>();
        this.niceScores.add(child.getNiceScore());
    }

    /**
     * A method which determines the age category of the current child
     * @return an enum value (AgeCategory type) representing the age category of the current child
     */
    public AgeCategory getAgeCategory() {
        return AgeCategory.getAgeCategory(this.age);
    }

    /**
     * An useful method which applies a change/update for the child.
     * @param update an instance which contains changes to apply to the current child, such as
     *               a new nice score (or not) or a new list of preferences.
     */
    public void applyChange(final ChildUpdate update) {
        if (update.getNiceScore() != null) {
            this.niceScores.add(update.getNiceScore());
        }

        this.addNewPreferences(update.getNewPreferences());
    }

    /**
     * A method which calculates the average score for the current child using a suitable
     * strategy. The effective calculations will take place in the one of the score strategy
     * classes (very similar to Visitor pattern)
     * @return a double vlue representing the average score of the child.
     */
    public double calculateAverageScore() {
        ScoreStrategyFactory factory = ScoreStrategyFactory.getScoreStrategyFactory();
        ScoreStrategy strategy = factory.createScoreStrategy(this.getAgeCategory());
        return strategy.applyStrategy(this);
    }
}
