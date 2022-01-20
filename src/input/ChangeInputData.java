package input;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.CityStrategyEnum;

import java.util.List;

/**
 * A class which is used to store input data representing an annual change
 */
public class ChangeInputData {
    /**
     * The new budget santa has to spend.
     */
    @JsonProperty("newSantaBudget")
    private double newBudget;

    /**
     * A getter for the new budget.
     * @return a double value representing the new budget.
     */
    public double getNewBudget() {
        return newBudget;
    }

    /**
     * A setter for the newBudget field - just for jackson package.
     * @param newBudget the new budget that must be used to buy gifts.
     */
    public void setNewBudget(final double newBudget) {
        this.newBudget = newBudget;
    }

    /**
     * A list containing the new gifts (and their input data) that must be added in santa's
     * database.
     */
    @JsonProperty("newGifts")
    private List<GiftInputData> newGifts;

    /**
     * A getter for the collection (list) of new gifts.
     * @return a list containing the new gifts that must be added in the database.
     */
    public List<GiftInputData> getNewGifts() {
        return newGifts;
    }

    /**
     * A setter for the new list of gifts that must be added in the database.
     * @param newGifts the new list of gifts.
     */
    public void setNewGifts(final List<GiftInputData> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     * The list of new children that must be added in the database.
     */
    @JsonProperty("newChildren")
    private List<ChildInputData> newChildren;

    /**
     * A getter for the newChildren field.
     * @return a collection (list) with the new children that must be added in the database.
     */
    public List<ChildInputData> getNewChildren() {
        return newChildren;
    }

    /**
     * A setter for the new list of children that must be added in the database.
     * @param newChildren a list containing the new children that must be added in the database.
     */
    public void setNewChildren(final List<ChildInputData> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     * A list of children updates that must be applied on the children in the database.
     */
    @JsonProperty("childrenUpdates")
    private List<ChildUpdateInputData> updates;

    /**
     * A getter for the updates field.
     * @return a list with the updates that must be performed.
     */
    public List<ChildUpdateInputData> getUpdates() {
        return updates;
    }

    /**
     * A setter for the list of updates that must be performed.
     * @param updates
     */
    public void setUpdates(final List<ChildUpdateInputData> updates) {
        this.updates = updates;
    }

    /**
     * The used strategy for this year
     */
    @JsonProperty("strategy")
    private CityStrategyEnum strategy;

    /**
     * A getter for the strategy field
     * @return the used strategy
     */
    public CityStrategyEnum getStrategy() {
        return strategy;
    }

    /**
     * A setter for the strategy field
     * @param strategy the new strategy to be applied (used)
     */
    public void setStrategy(CityStrategyEnum strategy) {
        this.strategy = strategy;
    }

    /**
     * A default constructor for checkstyle.
     */
    public ChangeInputData() { }
}
