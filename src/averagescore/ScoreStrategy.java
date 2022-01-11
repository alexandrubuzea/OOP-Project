package averagescore;

import entities.Child;

/**
 * An interface for the score strategy, which will be implemented by specific strategies
 * for each age category (it contains a method which will be used in this calculation of
 * the average score).
 */
public interface ScoreStrategy {
    /**
     * The generic strategy applying method that will be implemented in all classes, depending on
     * their age category
     * @param child the child for which the strategy needs to be implemented
     * @return a double value representing the average score according to the used strategy
     */
    double applyStrategy(Child child);
}
