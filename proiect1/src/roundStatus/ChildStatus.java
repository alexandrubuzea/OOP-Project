package roundStatus;

import entities.Child;
import entities.Gift;

import java.util.ArrayList;
import java.util.List;

public class ChildStatus {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private double averageScore;

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    private List<Gift> gifts;

    public List<Gift> getGifts() {
        return gifts;
    }

    private double assignedBudget;

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public ChildStatus(Child child) {
        this.id = child.getId();
        this.averageScore = 0;
        this.gifts = new ArrayList<>();
        this.assignedBudget = 0;
    }
}
