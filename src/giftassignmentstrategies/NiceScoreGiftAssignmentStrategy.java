package giftassignmentstrategies;

import roundstatus.Round;

import java.util.ArrayList;
import java.util.List;

public class NiceScoreGiftAssignmentStrategy implements GiftAssignmentStrategy {
    @Override
    public List<Integer> applyAssignmentStrategy(Round round) {
        List<Integer> ids = new ArrayList<>(round.getGlobalStatus().keySet());
        ids.sort((o1, o2) -> {
            double score1 = round.getGlobalStatus().get(o1).getAverageScore();
            double score2 = round.getGlobalStatus().get(o2).getAverageScore();

            if (score1 != score2) {
                return score1 > score2 ? -1 : 1;
            }

            return 0;
        });

        return ids;
    }
}
