package database;

import common.Constants;
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

/**
 * A class which represents the santa's database. For our project the database is unique, so we
 * used the Singleton Pattern in order to make it available to other packages and classes.
 */
public final class Database {
    /**
     * Our unique database instance
     */
    private static Database database = null;

    /**
     * Our getter in order to make unique database everywhere.
     * @return database instance
     */
    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }

        return database;
    }

    /**
     * Our setter of the database (is used only at the final of the every test, when we need
     * to clear up the database for the next test.
     * @param database our unique database (or null)
     */
    public static void setDatabase(final Database database) {
        Database.database = database;
    }

    /**
     * Our input data (for one test), as described in the input.InputData class
     */
    private static InputData input = null;

    /**
     * A getter for our static input field.
     * @return the desired input.
     */
    public static InputData getInput() {
        return input;
    }

    /**
     * A setter which is used only at the final of a test (to clear the input static field).
     * @param input the given input data
     */
    public static void setInput(final InputData input) {
        Database.input = input;
    }

    /**
     * In order to increase efficiency, we use maps instead of lists (access in O(1) instead
     * of O(lengthOfCollection) complexity). #welovemaps
     */
    private final Map<Integer, Child> children;

    /**
     * A getter for our children field.
     * @return the desired field.
     */
    public Map<Integer, Child> getChildren() {
        return children;
    }

    /**
     * In order to increase efficiency, we use maps instead of lists (access in O(1) instead
     * of O(lengthOfCollection) complexity) #welovemaps . Also, we use the most efficient approach
     * (by grouping the gifts from the same category in a collection, which is the value of the map
     * entry).
     */
    private final Map<Category, List<Gift>> gifts;

    /**
     * A getter for our gifts field.
     * @return the desired field.
     */
    public Map<Category, List<Gift>> getGifts() {
        return gifts;
    }

    /**
     * The budget Santa has to spend on gifts for the children from his database.
     */
    private double santaBudget;

    /**
     * A getter for our santaBudget field.
     * @return the desired field.
     */
    public double getSantaBudget() {
        return santaBudget;
    }

    /**
     * The private constructor (specific to the Singleton Pattern) which uses the previously
     * given input.
     */
    private Database() {
        // extracting the initial available budget
        this.santaBudget = Database.input.getSantaBudget();

        // creating a map for the child register
        this.children = new LinkedHashMap<>();

        // populating the child register
        for (ChildInputData child : Database.input.getInitialData().getChildrenInputData()) {
            this.children.put(child.getId(), new Child(child));
        }

        // creating a map for the gift register
        this.gifts = new LinkedHashMap<>();

        // populating the gift register
        for (GiftInputData gift : Database.input.getInitialData().getGifts()) {
            if (!this.gifts.containsKey(gift.getCategory())) {
                this.gifts.put(gift.getCategory(), new ArrayList<>());
            }

            this.gifts.get(gift.getCategory()).add(new Gift(gift));
        }
    }

    /**
     * A method which is used to add a new collection of gifts to santa's Database (for yearly
     * update)
     * @param newGifts - a list containing the new gifts that must be added.
     */
    public void addNewGifts(final List<Gift> newGifts) {
        for (Gift gift : newGifts) {
            // if the gift to add is from a new category
            if (!database.gifts.containsKey(gift.getCategory())) {
                database.gifts.put(gift.getCategory(), new ArrayList<>());
            }

            // add the gift into the database.
            database.gifts.get(gift.getCategory()).add(gift);
        }
    }

    /**
     * A method which is used to add a new collection of children into the santa's database.
     * (for yearly update).
     * @param newChildren - a list containing the new children that must be added.
     */
    public void addNewChildren(final Map<Integer, Child> newChildren) {
        for (Map.Entry<Integer, Child> entry : newChildren.entrySet()) {
            // put the child in the database only if he is not an adult.
            if (entry.getValue().getAge() < Constants.MINIMUM_ADULT_AGE) {
                database.children.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * A setter method for the available budget santa must spend.
     * @param newBudget a double value.
     */
    public void updateBudget(final double newBudget) {
        database.santaBudget = newBudget;
    }

    /**
     * A method which applies the available updates to the corresponding children.
     * @param childrenUpdates a list which contains updates for each child (such as new
     *                        gift preferences, a new nice score).
     */
    public void applyChildrenUpdates(final List<ChildUpdate> childrenUpdates) {
        // search for each update and applies it on the corresponding child
        for (ChildUpdate update : childrenUpdates) {
            // if the update corresponds to a child which is not in the database, ignore it
            if (!database.children.containsKey(update.getId())) {
                continue;
            }

            // apply update on the corresponding child.
            database.children.get(update.getId()).applyChange(update);
        }
    }

    /**
     * A method which increments the age for all children in the database.
     */
    public void incrementAge() {
        for (Child child : database.children.values()) {
            child.incrementAge();
        }
    }

    /**
     * A method which removes the adults and young adults from the database (the children
     * whose ages are over 18 years).
     */
    public void removeAdults() {
        // getting the id's of the children existing in the database.
        List<Integer> ids = database.children.keySet().stream().toList();

        // removing each child which has become adult.
        for (int id : ids) {
            if (database.children.get(id).getAge() >= Constants.MINIMUM_ADULT_AGE) {
                database.children.remove(id);
            }
        }
    }

    /**
     * A method which applies a change on the database (a change contains children updates,
     * new gifts and children that must be added in the database, a new available budget etc).
     * @param change a change entity which contains children updates, new children and gifts
     *               and a new budget
     */
    public void applyChange(final Change change) {
        // doing the necessary changes for this year.
        database.incrementAge();
        database.removeAdults();

        // update the database using the change entity
        database.applyChildrenUpdates(change.getUpdates());

        database.addNewGifts(change.getNewGifts());
        database.addNewChildren(change.getNewChildren());
        database.updateBudget(change.getNewBudget());
    }
}
