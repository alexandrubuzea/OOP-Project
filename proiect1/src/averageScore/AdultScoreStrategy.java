package averageScore;

import entities.Child;

public class AdultScoreStrategy implements ScoreStrategy{
    public AdultScoreStrategy() { }

    @Override
    public double applyStrategy(Child child) {
        return 0;
    }
}
