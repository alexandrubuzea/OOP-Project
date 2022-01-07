package averageScore;

import entities.Child;
import utils.Utils;

public class KidScoreStrategy implements ScoreStrategy{
    public KidScoreStrategy() { }

    @Override
    public double applyStrategy(Child child) {
        return Utils.getMean(child.getNiceScores());
    }
}
