package entities;

import input.ChangeInputData;
import input.ChildInputData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A class which represents an annual change to be applied on our database.
 */
public class Change {
    /**
     * The new budget for this year, which will be used to buy gifts for the children
     * in the database.
     */
    private final double newBudget;

    /**
     * A getter for the new budget field
     * @return the new budget, as it is stated in the annual change
     */
    public double getNewBudget() {
        return newBudget;
    }

    /**
     * the list of new gifts which need to be added in the database.
     */
    private final List<Gift> newGifts;

    /**
     * A getter for the list of new gifts field
     * @return a new collection of gifts to be added in the database.
     */
    public List<Gift> getNewGifts() {
        return newGifts;
    }

    /**
     * A map (yes, #welovemaps) which contains the new set of children to be added in the
     * database.
     */
    private final Map<Integer, Child> newChildren;

    /**
     * A getter for the newchildren field.
     * @return the new set of children to be added in the database.
     */
    public Map<Integer, Child> getNewChildren() {
        return newChildren;
    }

    /**
     * A list of child updates to be applied on the children existing in the database.
     */
    private final List<ChildUpdate> updates;

    /**
     * A getter for the updates field.
     * @return a list of child updates which will be applied on the database.
     */
    public List<ChildUpdate> getUpdates() {
        return updates;
    }

    /**
     * A constructor for the current class, which creates a new instance of the class
     * based on the input data (an instance of ChangeInputData class).
     * @param change
     */
    public Change(final ChangeInputData change) {
        this.newBudget = change.getNewBudget();
        this.newGifts = new ArrayList<>(change.getNewGifts().stream().map(Gift::new).toList());

        // creating a map from the ChildInputData list existing in the input.
        this.newChildren = new LinkedHashMap<>();
        for (ChildInputData input : change.getNewChildren()) {
            // populating the map.
            this.newChildren.put(input.getId(), new Child(input));
        }

        this.updates = new ArrayList<>(change.getUpdates().stream().
                map(ChildUpdate::new).toList());
    }
}
