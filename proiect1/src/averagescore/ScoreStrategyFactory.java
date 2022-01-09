package averagescore;

import enums.AgeCategory;

/**
 * A strategy factory used to create a suitable strategy depending on the given age category
 * of our child. Since two different strategy factory cannot be different, it is a good
 * practice to simultaneously use the singleton pattern in order to create just one instance
 * of the strategy factory.
 */
public final class ScoreStrategyFactory {
    /**
     * One unique instance, which initially does not exist.
     */
    private static ScoreStrategyFactory factory = null;

    /**
     * Private constructor, as required by the singleton pattern
     */
    private ScoreStrategyFactory() { }

    /**
     * A getter metod used to access our unique ScoreStrategyFactory instance.
     * @return the desired unique instance
     */
    public static ScoreStrategyFactory getScoreStrategyFactory() {
        if (factory == null) {
            factory = new ScoreStrategyFactory();
        }

        return factory;
    }

    /**
     * The typical method for the Factory pattern, which uses the age category of the current child
     * and creates a suitable strategy.
     * @param category - the age category of the child
     * @return a suitable strategy (returned as a generic ScoreStrategy instance)
     */
    public ScoreStrategy createScoreStrategy(final AgeCategory category) {
        return switch (category) {
            case BABY -> new BabyScoreStrategy();
            case KID -> new KidScoreStrategy();
            case TEEN -> new TeenScoreStrategy();
            case YOUNG_ADULT -> new AdultScoreStrategy();
        };
    }
}
