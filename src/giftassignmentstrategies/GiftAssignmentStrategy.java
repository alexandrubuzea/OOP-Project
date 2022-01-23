package giftassignmentstrategies;

import roundstatus.Round;

import java.util.List;

public interface GiftAssignmentStrategy {
    public List<Integer> applyAssignmentStrategy(Round round);
}
