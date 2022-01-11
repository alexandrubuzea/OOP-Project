package averagescore;

import common.Constants;
import entities.Child;

/**
 * A class that is used to implement a score strategy when the current child is a baby (0-4 years).
 */
public class BabyScoreStrategy implements ScoreStrategy {
    public BabyScoreStrategy() { }

    /**
     * The implementation of the abstract method existing in the ScoreStrategy interface.
     * @param child the corresponding child
     * @return a double value which represents the average score for our child instance given
     * its age category. (10.0 for all babies - they're too small to not be nice)
     */
    @Override
    public double applyStrategy(final Child child) {
        return Constants.BABY_AVERAGE_SCORE;
    }
}
