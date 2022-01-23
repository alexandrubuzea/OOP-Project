package giftassignmentstrategies;

import roundstatus.Round;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IdGiftAssignmentStrategy implements GiftAssignmentStrategy {
    @Override
    public List<Integer> applyAssignmentStrategy(Round round) {
        List<Integer> ids = new ArrayList<>(round.getGlobalStatus().keySet());
        ids.sort(Comparator.comparingInt(o -> o));
        return ids;
    }
}
