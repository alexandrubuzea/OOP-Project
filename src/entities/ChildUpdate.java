package entities;

import enums.Category;
import enums.ElvesType;
import input.ChildUpdateInputData;

import java.util.List;

/**
 * A class which retains an annual change/update. An update represents an optional nice score
 * and a list of new preferences.
 */
public class ChildUpdate {

    /**
     * The ID of the child for which the update is needed to be applied.
     */
    private final int id;

    /**
     * A getter for the id field.
     * @return an integer value representing the id of the child corresponding to
     * the update.
     */
    public int getId() {
        return id;
    }

    /**
     * The new nice score to be added to the child scores list.
     */
    private final Double niceScore;

    /**
     * A getter for the niceScore field
     * @return the double value representing the new nice score.
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * The new preferences list (collection) to be added in the preference list of the child.
     */
    private final List<Category> newPreferences;

    /**
     * A getter for the newPreferences field.
     * @return a collection (list) representing the new preferences list for the child.
     */
    public List<Category> getNewPreferences() {
        return newPreferences;
    }

    /**
     * A new Elf to use for the next years
     */
    private final ElvesType newElf;

    /**
     * A getter for the elf field
     * @return the desired field.
     */
    public ElvesType getNewElf() {
        return newElf;
    }

    /**
     * A constructor which builds an entity based on the given input (ChildUpdateInputData type)
     * @param childUpdate the input used to create a new ChildUpdate entity.
     */
    public ChildUpdate(final ChildUpdateInputData childUpdate) {
        this.id = childUpdate.getId();
        this.niceScore = childUpdate.getNiceScore();
        this.newPreferences = childUpdate.getPreferences();
        this.newElf = childUpdate.getNewElf();
    }
}
