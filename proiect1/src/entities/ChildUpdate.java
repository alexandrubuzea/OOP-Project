package entities;

import enums.Category;
import input.ChildUpdateInputData;

import java.util.List;

public class ChildUpdate {
    private final int id;

    public int getId() {
        return id;
    }

    private final Double niceScore;

    public Double getNiceScore() {
        return niceScore;
    }

    private final List<Category> newPreferences;

    public List<Category> getNewPreferences() {
        return newPreferences;
    }

    public ChildUpdate(ChildUpdateInputData childUpdate) {
        this.id = childUpdate.getId();
        this.niceScore = childUpdate.getNiceScore();
        this.newPreferences = childUpdate.getPreferences();
    }
}
