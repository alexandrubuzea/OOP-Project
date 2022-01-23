package input;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.List;

/**
 * A class which contains the input data for a child.
 */
public class ChildInputData {
    /**
     * The ID (identifier) of the child.
     */
    @JsonProperty("id")
    private int id;

    /**
     * A getter for the ID field.
     * @return an integer representing the ID of the child.
     */
    public int getId() {
        return id;
    }

    /**
     * A setter for the ID field.
     * @param id the new ID of the child.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * The lastName field of the child (which is a String)
     */
    @JsonProperty("lastName")
    private String lastName;

    /**
     * A getter for the lastName field.
     * @return a string representing the lastname of the child.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * A setter for the lastName field.
     * @param lastName the new lastName (a String) of the child - for jackson library.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * The firstName field of the child (which is a String)
     */
    @JsonProperty("firstName")
    private String firstName;

    /**
     * A getter for the firstName of the child.
     * @return a string representing the firstname of the child.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * A setter for the firstname of the child.
     * @param firstName the new firstname (a String) of the child - for jackson library
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * The age field of a child.
     */
    @JsonProperty("age")
    private int age;

    /**
     * A getter for the age field.
     * @return an integer representing the age of the child.
     */
    public int getAge() {
        return age;
    }

    /**
     * A setter for the age field - for jackson library
     * @param age an integer representing the new age of the child.
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * The city field for the child.
     */
    @JsonProperty("city")
    private Cities city;

    /**
     * A getter for the city field.
     * @return an enum (Cities type) representing the city where the child lives.
     */
    public Cities getCity() {
        return city;
    }

    /**
     * A setter for the city field - for jackson library.
     * @param city which is the value of the city (enum type) where the child lives.
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * The niceScore field of the child.
     */
    @JsonProperty("niceScore")
    private double niceScore;

    /**
     * A getter for the niceScore field.
     * @return a double value representing the nice score of the child.
     */
    public double getNiceScore() {
        return niceScore;
    }

    /**
     *A setter for the niceScore field.
     * @param niceScore a double value representing the new nice score of the child.
     */
    public void setNiceScore(final double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * The gifts preferences of the child
     */
    @JsonProperty("giftsPreferences")
    private List<Category> giftsPreferences;

    /**
     * A getter for the gifts preferences of the child
     * @return a collection (list) of Category type representing the gifts preferences.
     */
    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * A setter for the gifts preferences of the child - for jackson library
     * @param giftsPreferences a collection (list) of Category type representing the gifts
     *                         preferences
     */
    public void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * The elf field for the child
     */
    @JsonProperty("elf")
    private ElvesType elf;

    /**
     * A getter for the elf field
     * @return the corresponding elf
     */
    public ElvesType getElf() {
        return elf;
    }

    /**
     * A setter for the elf field
     * @param elf the new type of elf.
     */
    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }

    /**
     * The nice score bonus field for the child (a value from 0 to 100 specifying the
     * percent bonus)
     */
    @JsonProperty("niceScoreBonus")
    private Double niceScoreBonus;

    /**
     * A getter for the nice score bonus field
     * @return the desired bonus
     */
    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * A setter for the nice score bonus
     * @param niceScoreBonus the new bonus
     */
    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    /**
     * a default contructor - for checkstyle
     */
    public ChildInputData() { }
}
