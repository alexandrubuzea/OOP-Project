package input;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;
import enums.ElvesType;

import java.util.List;

/**
 * A class for the child update input for the annual changes.
 */
public class ChildUpdateInputData {
    /**
     * The ID of the child for which the update must be applied.
     */
    @JsonProperty("id")
    private int id;

    /**
     * A getter for the ID field.
     * @return an integer representing the corresponding ID of the child update.
     */
    public int getId() {
        return id;
    }

    /**
     * A setter for the ID field - for jackson library.
     * @param id the nww ID of the child update
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * The optional niceScore field.
     */
    @JsonProperty("niceScore")
    private Double niceScore;

    /**
     * A getter for the nice score field.
     * @return a Double value (including null) which represents the new nice score that must be
     * added in the niceScore list of the child.
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * A setter for the nice score of the update - for jackson library.
     * @param niceScore the new nice score to be added.
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * The preferences field of the child update, which contains the new preferences to be added
     * in the child preferences list.
     */
    @JsonProperty("giftsPreferences")
    private List<Category> preferences;

    /**
     * A getter for the preferences list of the child update.
     * @return the desired list.
     */
    public List<Category> getPreferences() {
        return preferences;
    }

    /**
     * A setter for the new preferences to be added - for jackson library.
     * @param preferences the new preferences list to be added.
     */
    public void setPreferences(final List<Category> preferences) {
        this.preferences = preferences;
    }

    /**
     * The new elf to be given to the child
     */
    @JsonProperty("elf")
    private ElvesType newElf;

    /**
     * A getter for the new elf field
     * @return the new elf
     */
    public ElvesType getNewElf() {
        return newElf;
    }

    /**
     * A setter for the new eld field.
     * @param newElf the new elf
     */
    public void setNewElf(final ElvesType newElf) {
        this.newElf = newElf;
    }

    /**
     * The default constructor for checkstyle.
     */
    public ChildUpdateInputData() { }
}
