package giftassignmentstrategies;

import roundstatus.Round;

import java.util.List;

public interface GiftAssignmentStrategy {
    /**
     * A method which returns a sorted list of integers based on the given criteria (given in the
     * Factory class associated with the strategies from the same package).
     * @param round the round for which the strategy must be applied
     * @return the list of sorted integers
     */
    List<Integer> applyAssignmentStrategy(Round round);
}
