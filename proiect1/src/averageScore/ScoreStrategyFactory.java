package averageScore;

import enums.AgeCategory;

public class ScoreStrategyFactory {
    private static ScoreStrategyFactory factory = null;

    private ScoreStrategyFactory() { }

    public static ScoreStrategyFactory getScoreStrategyFactory() {
        if (factory == null) {
            factory = new ScoreStrategyFactory();
        }

        return factory;
    }

    public ScoreStrategy createScoreStrategy(AgeCategory category) {
        return switch (category) {
            case BABY -> new BabyScoreStrategy();
            case KID -> new KidScoreStrategy();
            case TEEN -> new TeenScoreStrategy();
            case YOUNG_ADULT -> new AdultScoreStrategy();
        };
    }
}
