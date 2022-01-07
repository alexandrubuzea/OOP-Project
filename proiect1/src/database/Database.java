package database;

import entities.Change;
import entities.Child;
import entities.ChildUpdate;
import entities.Gift;
import enums.Category;
import input.ChildInputData;
import input.GiftInputData;
import input.InputData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static Database database = null;

    public static Database getDatabase() {
        if (database == null)
            database = new Database();
        return database;
    }

    public static void setDatabase(Database database) {
        Database.database = database;
    }

    private static InputData input = null;

    public static InputData getInput() {
        return input;
    }

    public static void setInput(InputData input) {
        Database.input = input;
    }

    private final Map<Integer, Child> children;

    public Map<Integer, Child> getChildren() {
        return children;
    }

    private final Map<Category, List<Gift>> gifts;

    public Map<Category, List<Gift>> getGifts() {
        return gifts;
    }

    private double santaBudget;

    public double getSantaBudget() {
        return santaBudget;
    }

    private Database() {
        this.santaBudget = Database.input.getSantaBudget();

        this.children = new LinkedHashMap<>();

        for (ChildInputData child : Database.input.getInitialData().getChildrenInputData()) {
            this.children.put(child.getId(), new Child(child));
        }

        this.gifts = new LinkedHashMap<>();

        for (GiftInputData gift : Database.input.getInitialData().getGifts()) {
            if (!this.gifts.containsKey(gift.getCategory())) {
                this.gifts.put(gift.getCategory(), new ArrayList<>());
            }

            this.gifts.get(gift.getCategory()).add(new Gift(gift));
        }
    }

    public void addNewGifts(List<Gift> newGifts) {
        for (Gift gift : newGifts) {
            if (!database.gifts.containsKey(gift.getCategory())) {
                database.gifts.put(gift.getCategory(), new ArrayList<>());
            }

            database.gifts.get(gift.getCategory()).add(gift);
        }
    }

    public void addNewChildren(Map<Integer, Child> newChildren) {
        for (Map.Entry<Integer, Child> entry : newChildren.entrySet()) {
            if (entry.getValue().getAge() > 18) {
                newChildren.remove(entry.getKey());
            }
        }

        database.children.putAll(newChildren);
    }

    public void updateBudget(double newBudget) {
        database.santaBudget = newBudget;
    }

    public void applyChildrenUpdates(List<ChildUpdate> childrenUpdates) {
        for (ChildUpdate update : childrenUpdates) {
            if (!database.children.containsKey(update.getId())) {
                continue;
            }

            database.children.get(update.getId()).applyChange(update);
        }
    }

    public void incrementAge() {
        for (Child child : database.children.values()) {
            child.incrementAge();
        }
    }

    public void removeAdults() {
        List<Integer> ids = database.children.keySet().stream().toList();
        for (int id : ids) {
            if (database.children.get(id).getAge() > 18) {
                database.children.remove(id);
            }
        }
    }

    public void applyChange(Change change) {
        Database database = Database.getDatabase();

        database.incrementAge();
        database.removeAdults();

        database.applyChildrenUpdates(change.getUpdates());

        database.addNewGifts(change.getNewGifts());
        database.addNewChildren(change.getNewChildren());
        database.updateBudget(change.getNewBudget());
    }
}
