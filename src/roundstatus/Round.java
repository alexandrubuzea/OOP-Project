package roundstatus;

import database.Database;
import entities.Child;
import entities.Gift;
import enums.Category;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;

/**
 * A class which is used to retain the changes and statuses during one round.
 */
public class Round {
    /**
     * A map from ID of a child to his status during the current round. Yes, #welovemaps
     */
    private final Map<Integer, ChildStatus> globalStatus;

    /**
     * A getter for the globalStatus field.
     * @return the desired field (a map from ID to status)
     */
    public Map<Integer, ChildStatus> getGlobalStatus() {
        return globalStatus;
    }

    /**
     * A constructor for the current round, which uses the database at that moment).
     */
    public Round() {
        Map<Integer, Child> children = Database.getDatabase().getChildren();
        this.globalStatus = new LinkedHashMap<>();
        for (Child child : children.values()) {
            this.globalStatus.put(child.getId(), new ChildStatus(child));
        }
    }

    /**
     * A method which calculates the average score for every child in the database.
     */
    public void calculateAverageScores() {
        // get a database instance
        Database database = Database.getDatabase();

        // for all children in the database / in the status for the current round, get the score
        for (Integer id : this.globalStatus.keySet()) {
            this.globalStatus.get(id).setAverageScore(database.getChildren().get(id).
                    calculateAverageScore());
        }
    }

    /**
     * A method which calculates the assigned budget for each child in the database and writes it
     * in the child status.
     */
    public void calculateAssignedBudgets() {
        // get a database instance
        Database database = Database.getDatabase();

        // get the statuses for the children
        List<ChildStatus> statuses = new ArrayList<>(this.globalStatus.values());

        // sort the statuses after ID
        statuses.sort(Comparator.comparingInt(ChildStatus::getId));

        // get the sum of average scores in order to determine budgetUnit
        // our heart tells us to use streams here, isn't it ? <3
        double sumOfAverageScores = Utils.getSum(statuses.stream()
                .map(ChildStatus::getAverageScore).toList());

        // determining the budgetUnit
        double budgetUnit = database.getSantaBudget() / sumOfAverageScores;

        // for each child, set the assigned budget using the budgetUnit.
        for (ChildStatus status : this.globalStatus.values()) {
            status.setAssignedBudget(budgetUnit * status.getAverageScore());
        }
    }

    /**
     * A method used to assign gifts to each child.
     */
    public void assignGifts() {
        // get a Database instance
        Database database = Database.getDatabase();

        // for each child in the database
        for (Child child : database.getChildren().values()) {
            // get the available budget
            double availableBudget = this.globalStatus.get(child.getId()).getAssignedBudget();

            // for each preferred category
            for (Category category : child.getGiftsPreferences()) {
                // if there is no gift in the preferred category, skip
                if (!database.getGifts().containsKey(category)) {
                    continue;
                }

                // get the possible gifts
                List<Gift> availableGifts = new ArrayList<>(database.getGifts().get(category));

                // get the cheapest gift - we need to sort the gifts
                availableGifts.sort(Comparator.comparingDouble(Gift::getPrice));

                // if we do not have enough money, go to next preferrence, maybe we find something
                // cheaper
                if (availableGifts.get(0).getPrice() > availableBudget) {
                    continue;
                }

                // add the gift in the status gift list
                this.globalStatus.get(child.getId()).getGifts().add(availableGifts.get(0));

                // spend the amount of money required to buy the gift.
                availableBudget -= availableGifts.get(0).getPrice();
            }
        }
    }
}
