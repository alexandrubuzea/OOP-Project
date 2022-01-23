package giftassignmentstrategies;

import roundstatus.Round;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IdGiftAssignmentStrategy implements GiftAssignmentStrategy {
    /**
     * A method which returns a sorted list of child ID's (the sort criteria is the
     * ID)
     * @param round the current round for the strategy to be applied to.
     * @return A list containing the sorted integers
     */
    @Override
    public List<Integer> applyAssignmentStrategy(final Round round) {
        List<Integer> ids = new ArrayList<>(round.getGlobalStatus().keySet());
        ids.sort(Comparator.comparingInt(o -> o));
        return ids;
    }
}
