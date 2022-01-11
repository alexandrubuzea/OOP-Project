package roundstatus;

import entities.Child;
import entities.Gift;

import java.util.ArrayList;
import java.util.List;

/**
 * A class used to have a statistics of a child status during a round
 */
public class ChildStatus {
    /**
     * The ID of the child status is reffering to
     */
    private int id;

    /**
     * A getter for the ID field.
     * @return an integer representing the ID
     */
    public int getId() {
        return id;
    }

    /**
     * A setter for the ID field.
     * @param id the new ID.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * The average score field.
     */
    private double averageScore;

    /**
     * A getter for the average score field.
     * @return a double value representing the average score of the child during current round.
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * A setter for the average score
     * @param averageScore the new average score.
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * The received gifts field.
     */
    private List<Gift> gifts;

    /**
     * A getter for the received gifts field.
     * @return a list containing the received gifts of a child during current round.
     */
    public List<Gift> getGifts() {
        return gifts;
    }

    /**
     * The assigned budget field.
     */
    private double assignedBudget;

    /**
     * A getter for the assigned budget
     * @return a double value representing the assigned budget for the current round.
     */
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * A setter for the assigned budget.
     * @param assignedBudget the new assigned budget.
     */
    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * A constructor for the child status given the child to which the status reffers to.
     * @param child the child for which we create the current status.
     */
    public ChildStatus(final Child child) {
        this.id = child.getId();
        this.averageScore = 0;
        this.gifts = new ArrayList<>();
        this.assignedBudget = 0;
    }
}
