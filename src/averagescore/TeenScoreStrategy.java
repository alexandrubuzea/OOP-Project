package averagescore;

import entities.Child;
import utils.Utils;

/**
 * A class that is used to implement a score strategy when the current child is a
 * teenager (12-18 years).
 */
public class TeenScoreStrategy implements ScoreStrategy {
    public TeenScoreStrategy() { }

    /**
     * The implementation of the abstract method existing in the ScoreStrategy interface.
     * @param child
     * @return a double value which represents the average score for our child instance given
     * its age category. (the arithmetic weighted mean of all his niceScores - the last niceScores
     * are more relevant.)
     */
    @Override
    public double applyStrategy(final Child child) {
        return Utils.getWeightedMean(child.getNiceScores());
    }
}
