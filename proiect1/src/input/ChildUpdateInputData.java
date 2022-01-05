package input;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;

import java.util.List;

public class ChildUpdateInputData {
    @JsonProperty("id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("niceScore")
    private double niceScore;

    public double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(double niceScore) {
        this.niceScore = niceScore;
    }

    @JsonProperty("giftsPreferences")
    private List<Category> preferences;

    public List<Category> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Category> preferences) {
        this.preferences = preferences;
    }

    public ChildUpdateInputData() { }
}
