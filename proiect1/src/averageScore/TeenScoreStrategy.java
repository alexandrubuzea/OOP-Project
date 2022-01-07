package averageScore;

import entities.Child;
import utils.Utils;

public class TeenScoreStrategy implements ScoreStrategy{
    public TeenScoreStrategy() { }

    @Override
    public double applyStrategy(Child child) {
        return Utils.getWeightedMean(child.getNiceScores());
    }
}
