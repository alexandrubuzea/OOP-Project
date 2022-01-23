package giftassignmentstrategies;

import enums.CityStrategyEnum;

public class GiftAssignmentStrategyFactory {
    public static GiftAssignmentStrategyFactory factory = null;

    private GiftAssignmentStrategyFactory() { }

    public static GiftAssignmentStrategyFactory getFactory() {
        if (factory == null) {
            factory = new GiftAssignmentStrategyFactory();
        }

        return factory;
    }

    public GiftAssignmentStrategy createStrategy(CityStrategyEnum strategy) {
        return switch (strategy) {
            case ID -> new IdGiftAssignmentStrategy();
            case NICE_SCORE -> new NiceScoreGiftAssignmentStrategy();
            case NICE_SCORE_CITY -> new CityGiftAssignmentStrategy();
        };
    }
}
