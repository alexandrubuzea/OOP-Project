package roundStatus;

import database.Database;
import entities.Child;
import entities.Gift;
import enums.Category;
import utils.Utils;

import java.util.*;

public class Round {
    private final Map<Integer, ChildStatus> globalStatus;

    public Map<Integer, ChildStatus> getGlobalStatus() {
        return globalStatus;
    }

    public Round() {
        Map<Integer, Child> children = Database.getDatabase().getChildren();
        this.globalStatus = new LinkedHashMap<>();
        for (Child child : children.values()) {
            this.globalStatus.put(child.getId(), new ChildStatus(child));
        }
    }

    public void calculateAverageScores() {
        Database database = Database.getDatabase();
        for (Integer id : this.globalStatus.keySet()) {
            this.globalStatus.get(id).setAverageScore(database.getChildren().get(id).calculateAverageScore());
        }
    }

    public void calculateAssignedBudgets() {
        Database database = Database.getDatabase();
        List<ChildStatus> statuses = new ArrayList<>(this.globalStatus.values());
        statuses.sort(Comparator.comparingInt(ChildStatus::getId));
        double sumOfAverageScores = Utils.getSum(statuses.stream().map(ChildStatus::getAverageScore).toList());
        double budgetUnit = database.getSantaBudget() / sumOfAverageScores;
        for (ChildStatus status : this.globalStatus.values()) {
            status.setAssignedBudget(budgetUnit * status.getAverageScore());
        }
    }

    public void assignGifts() {
        Database database = Database.getDatabase();

        for (Child child : database.getChildren().values()) {
            double availableBudget = this.globalStatus.get(child.getId()).getAssignedBudget();
            for (Category category : child.getGiftsPreferences()) {
                if (!database.getGifts().containsKey(category)) {
                    continue;
                }

                List<Gift> availableGifts = new ArrayList<>(database.getGifts().get(category));

                availableGifts.sort(Comparator.comparingDouble(Gift::getPrice));
                if (availableGifts.get(0).getPrice() > availableBudget) {
                    continue;
                }

                this.globalStatus.get(child.getId()).getGifts().add(availableGifts.get(0));
                availableBudget -= availableGifts.get(0).getPrice();
            }
        }
    }
}
