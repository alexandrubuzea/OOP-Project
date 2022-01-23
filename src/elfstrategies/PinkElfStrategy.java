package elfstrategies;

import common.Constants;
import roundstatus.ChildStatus;

/**
 * A class which performs a pink elf strategy: for the child the strategy is applied to, the
 * budget is increased by 30%.
 */
public class PinkElfStrategy implements ElfStrategy {

    /**
     * The method which represents the applied strategy: the budget is increased by 30%
     * @param status the current status of the child to which the strategy is applied.
     */
    @Override
    public void applyGiftStrategy(final ChildStatus status) {
        double budget = status.getAssignedBudget();
        budget += budget * Constants.THIRTY / Constants.MAKE_PERCENT;
        status.setAssignedBudget(budget);
    }
}
