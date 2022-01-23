package roundstatus;

import database.Database;
import elfstrategies.ElfStrategy;
import elfstrategies.ElfStrategyFactory;
import entities.Child;
import entities.Gift;
import enums.Category;
import enums.ElvesType;
import giftassignmentstrategies.GiftAssignmentStrategy;
import giftassignmentstrategies.GiftAssignmentStrategyFactory;
import utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

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
                .map(ChildStatus::getAverageScore).collect(Collectors.toList()));

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

        GiftAssignmentStrategyFactory assignmentStrategyFactory = GiftAssignmentStrategyFactory
                .getFactory();
        GiftAssignmentStrategy strategy = assignmentStrategyFactory.createStrategy(database.getStrategy());
        List<Integer> ids = strategy.applyAssignmentStrategy(this);

        ElfStrategyFactory elfStrategyFactory = ElfStrategyFactory.getElfStrategyFactory();

        // for each child in the database
        for (Integer id : ids) {
            if (!database.getChildren().get(id).getElf().equals(ElvesType.YELLOW)) {
                ElfStrategy elfStrategy = elfStrategyFactory.createElfStrategy(database.
                        getChildren().get(id).getElf());
                elfStrategy.applyGiftStrategy(this.globalStatus.get(id));
            }

            database.getChildren().get(id).assignGifts(this.globalStatus.get(id));
        }

        for (Integer id : ids) {
            if (database.getChildren().get(id).getElf().equals(ElvesType.YELLOW)) {
                ElfStrategy elfStrategy = elfStrategyFactory.createElfStrategy(database
                        .getChildren().get(id).getElf());
                elfStrategy.applyGiftStrategy(this.globalStatus.get(id));
            }
        }
    }
}
