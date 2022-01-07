package averageScore;

import entities.Child;

public class BabyScoreStrategy implements ScoreStrategy {
    public BabyScoreStrategy() { }

    @Override
    public double applyStrategy(Child child) {
        return 10;
    }
}
