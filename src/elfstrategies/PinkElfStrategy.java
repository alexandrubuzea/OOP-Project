package elfstrategies;

import roundstatus.ChildStatus;

public class PinkElfStrategy implements ElfStrategy {

    @Override
    public void applyGiftStrategy(ChildStatus status) {
        double budget = status.getAssignedBudget();
        budget += budget * 30 / 100;
        status.setAssignedBudget(budget);
    }
}
