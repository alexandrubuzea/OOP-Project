package input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChangeInputData {
    @JsonProperty("newSantaBudget")
    private double newBudget;

    public double getNewBudget() {
        return newBudget;
    }

    public void setNewBudget(double newBudget) {
        this.newBudget = newBudget;
    }

    @JsonProperty("newGifts")
    private List<GiftInputData> newGifts;

    public List<GiftInputData> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(List<GiftInputData> newGifts) {
        this.newGifts = newGifts;
    }

    @JsonProperty("newChildren")
    private List<ChildInputData> newChildren;

    public List<ChildInputData> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(List<ChildInputData> newChildren) {
        this.newChildren = newChildren;
    }

    @JsonProperty("childrenUpdates")
    private List<ChildUpdateInputData> updates;

    public List<ChildUpdateInputData> getUpdates() {
        return updates;
    }

    public void setUpdates(List<ChildUpdateInputData> updates) {
        this.updates = updates;
    }

    public ChangeInputData() { }
}
