package entities;

import input.ChangeInputData;
import input.ChildInputData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Change {
    private final double newBudget;

    public double getNewBudget() {
        return newBudget;
    }

    private final List<Gift> newGifts;

    public List<Gift> getNewGifts() {
        return newGifts;
    }

    private final Map<Integer, Child> newChildren;

    public Map<Integer, Child> getNewChildren() {
        return newChildren;
    }

    private final List<ChildUpdate> updates;

    public List<ChildUpdate> getUpdates() {
        return updates;
    }

    public Change(ChangeInputData change) {
        this.newBudget = change.getNewBudget();
        this.newGifts = new ArrayList<>(change.getNewGifts().stream().map(Gift::new).toList());
        this.newChildren = new LinkedHashMap<>();
        for (ChildInputData input : change.getNewChildren()) {
            this.newChildren.put(input.getId(), new Child(input));
        }

        this.updates = new ArrayList<>(change.getUpdates().stream().map(ChildUpdate::new).toList());
    }
}
