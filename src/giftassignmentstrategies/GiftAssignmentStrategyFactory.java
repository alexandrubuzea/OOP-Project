package giftassignmentstrategies;

import enums.CityStrategyEnum;

/**
 * A Singleton Strategy Factory used in order to create a suitable strategy to be applied.
 */
public final class GiftAssignmentStrategyFactory {
    private static GiftAssignmentStrategyFactory factory = null;

    /**
     * The default constructor for this type of strategy
     */
    private GiftAssignmentStrategyFactory() { }

    /**
     * A method which returns the factory and additionally can create a new instance if there
     * is no instance up to this moment.
     * @return the unique instance
     */
    public static GiftAssignmentStrategyFactory getFactory() {
        if (factory == null) {
            factory = new GiftAssignmentStrategyFactory();
        }

        return factory;
    }

    /**
     * The factory method, which creates a strategy according to the given strategy type.
     * @param strategy the desired strategy type
     * @return an instance representing the strategy that must be applied at the gift assignment
     */
    public GiftAssignmentStrategy createStrategy(final CityStrategyEnum strategy) {
        return switch (strategy) {
            case ID -> new IdGiftAssignmentStrategy();
            case NICE_SCORE -> new NiceScoreGiftAssignmentStrategy();
            case NICE_SCORE_CITY -> new CityGiftAssignmentStrategy();
        };
    }
}
