package input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * A clss which is used to parse the whole input file in it (all content of the input file
 * is an object of InputData type)
 */
public class InputData {
    /**
     * The number of years of the simulation
     */
    @JsonProperty("numberOfYears")
    private int numberOfYears;

    /**
     * A getter for the numberOfYears field.
     * @return an integer representing the number of years of the simulation
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * a setter for the number of years - for jackson library
     * @param numberOfYears an integer representing the new number of years.
     */
    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * The initial budget for round 0
     */
    @JsonProperty("santaBudget")
    private double santaBudget;

    /**
     * A getter for santaBudget field
     * @return a double value representing the santa initial budget
     */
    public double getSantaBudget() {
        return santaBudget;
    }

    /**
     * A setter for santaBudget field
     * @param santaBudget the new santa budget (for jackson library).
     */
    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     * The initial data (children and gifts) for the database.
     */
    @JsonProperty("initialData")
    private InitialData initialData;

    /**
     * A getter for initialData field.
     * @return the initial data (lists of children and gifts)
     */
    public InitialData getInitialData() {
        return initialData;
    }

    /**
     * A setter for the initialData field.
     * @param initialData the new initial data - for jackson library
     */
    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    /**
     * The annual changes list (one for every round - numberOfYears + 1 in total)
     */
    @JsonProperty("annualChanges")
    private List<ChangeInputData> changes;

    /**
     * A getter for the changes field.
     * @return the list of annual changes to perform.
     */
    public List<ChangeInputData> getChanges() {
        return changes;
    }

    /**
     * A setter for the list of changes.
     * @param changes the new list of changes.
     */
    public void setChanges(final List<ChangeInputData> changes) {
        this.changes = changes;
    }

    /**
     * A default constructor (for checkstyle)
     */
    public InputData() { }
}
