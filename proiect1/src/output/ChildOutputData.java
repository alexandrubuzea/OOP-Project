package output;

import com.fasterxml.jackson.annotation.JsonProperty;
import database.Database;
import entities.Child;
import enums.Category;
import enums.Cities;
import roundStatus.ChildStatus;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ChildOutputData {
    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("lastName")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("firstName")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("city")
    private Cities city;

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    @JsonProperty("age")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JsonProperty("giftsPreferences")
    private List<Category> preferences;

    public List<Category> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Category> preferences) {
        this.preferences = preferences;
    }

    @JsonProperty("averageScore")
    private double averageScore;

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @JsonProperty("niceScoreHistory")
    private List<Double> niceScoreHistory;

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    @JsonProperty("assignedBudget")
    private double assignedBudget;

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    @JsonProperty("receivedGifts")
    private List<GiftOutputData> gifts;

    public List<GiftOutputData> getGifts() {
        return gifts;
    }

    public void setGifts(List<GiftOutputData> gifts) {
        this.gifts = gifts;
    }

    public ChildOutputData(ChildStatus status) {
        Child child = Database.getDatabase().getChildren().get(status.getId());
        this.age = child.getAge();
        this.gifts = new ArrayList<>(status.getGifts().stream().map(GiftOutputData::new).toList());
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
