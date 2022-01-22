package output;

import com.fasterxml.jackson.annotation.JsonProperty;
import database.Database;
import entities.Child;
import enums.Category;
import enums.Cities;
import roundstatus.ChildStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class which stores the output data for a child in the database.
 */
public class ChildOutputData {
    /**
     * The ID field for the child.
     */
    @JsonProperty("id")
    private int id;

    /**
     * A getter for the ID field.
     * @return an integer representing the child ID.
     */
    public int getId() {
        return id;
    }

    /**
     * A setter for the ID field.
     * @param id the new ID of the child (for jackson library)
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * The last name of the child.
     */
    @JsonProperty("lastName")
    private String lastName;

    /**
     * A getter for the last name field.
     * @return a String which represents the last name of the child.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * A setter for the last name of the child.
     * @param lastName the new last name of the child (for jackson library).
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * The first name field of a child.
     */
    @JsonProperty("firstName")
    private String firstName;

    /**
     * A getter for the first name field.
     * @return a Stirng which represents the first name of a child.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * A setter for the first name of the child.
     * @param firstName the new first name of the child.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * The city field for a child.
     */
    @JsonProperty("city")
    private Cities city;

    /**
     * A getter for the city field of a child.
     * @return an enum value (Cities type) which represents the city a child lives in.
     */
    public Cities getCity() {
        return city;
    }

    /**
     * A setter for the city field of a child.
     * @param city the new city for the given instance.
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * The age field for the child.
     */
    @JsonProperty("age")
    private int age;

    /**
     * A getter for the age field.
     * @return an integer which represents the age of the child.
     */
    public int getAge() {
        return age;
    }

    /**
     * A setter for the age field.
     * @param age the new age for the given child.
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * The preferences of the child, given as a collection (list) of enum Category type.
     */
    @JsonProperty("giftsPreferences")
    private List<Category> preferences;

    /**
     * A getter for the preferences field.
     * @return
     */
    public List<Category> getPreferences() {
        return preferences;
    }

    /**
     * A setter for the given preferences field.
     * @param preferences a list which contains the new preferences field - for jackson library.
     */
    public void setPreferences(final List<Category> preferences) {
        this.preferences = preferences;
    }

    /**
     * The average score field for the child.
     */
    @JsonProperty("averageScore")
    private double averageScore;

    /**
     * A getter for the averageScore field.
     * @return a double value representing the average score value for the given child.
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * A setter for the averageScore field.
     * @param averageScore the new average score for the child.
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * The nice score history list for the child.
     */
    @JsonProperty("niceScoreHistory")
    private List<Double> niceScoreHistory;

    /**
     * A getter for the score history list field.
     * @return A collection (list) which contains the nice score history of the child.
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * A setter for the score history list field.
     * @param niceScoreHistory a list which contains the new scores for the child.
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * The assigned budget field for the child.
     */
    @JsonProperty("assignedBudget")
    private double assignedBudget;

    /**
     * A getter for the assigned budget field.
     * @return a double value representing the assigned budget value.
     */
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * A setter for the assigned budget field.
     * @param assignedBudget a double value representing the new assigned budget.
     */
    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * The list of gifts for the child.
     */
    @JsonProperty("receivedGifts")
    private List<GiftOutputData> gifts;

    /**
     * A getter for the list of given gifts.
     * @return the desired list.
     */
    public List<GiftOutputData> getGifts() {
        return gifts;
    }

    /**
     * A setter for the list of given gifts.
     * @param gifts the new list of gifts.
     */
    public void setGifts(final List<GiftOutputData> gifts) {
        this.gifts = gifts;
    }

    /**
     * A constructor for the ChildOutputData instance. It uses a status instance and the
     * database in its current state.
     * @param status the status instance which is used to create the output for one child.
     */
    public ChildOutputData(final ChildStatus status) {
        Child child = Database.getDatabase().getChildren().get(status.getId());
        this.age = child.getAge();
        this.gifts = new ArrayList<>(status.getGifts().stream().map(GiftOutputData::new).collect(Collectors.toList()));
        this.id = child.getId();
        this.assignedBudget = status.getAssignedBudget();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.city = child.getCity();
        this.preferences = new ArrayList<>(child.getGiftsPreferences());
        this.averageScore = status.getAverageScore();
        this.niceScoreHistory = new ArrayList<>(child.getNiceScores());
    }
}
