package averagescore;

import entities.Child;
import utils.Utils;

/**
 * A class that is used to implement a score strategy when the current child is a kid (5-11 years).
 */
public class KidScoreStrategy implements ScoreStrategy {
    public KidScoreStrategy() { }

    /**
     * The implementation of the abstract method existing in the ScoreStrategy interface.
     * @param child the kid to which the strategy must be applied
     * @return a double value which represents the average score for our child instance given
     * its age category. (which is the arithmetic mean of all his niceScores: it matters if
     * the child has been bad in the past, isn't it ?)
     */
    @Override
    public double applyStrategy(final Child child) {
        return Utils.getMean(child.getNiceScores());
    }
}
