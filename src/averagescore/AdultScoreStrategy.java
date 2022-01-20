package averagescore;

import entities.Child;

/**
 * A class that is used to implement a score strategy when the current child is a young adult.
 * There will never be such an instance at the runtime, because we remove young adults every time.
 * Only for design purposes.
 */
public class AdultScoreStrategy implements ScoreStrategy {
    public AdultScoreStrategy() { }

    /**
     * The implementation of the abstract method existing in the ScoreStrategy interface.
     * @param child the child to which the strategy must be applied
     * @return a double value which represents the average score for our child instance given
     * its age category. (0.0 for all young adults)
     */
    @Override
    public double applyStrategy(final Child child) {
        return 0;
    }
}
