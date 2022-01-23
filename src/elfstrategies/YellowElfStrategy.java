package elfstrategies;

import database.Database;
import entities.Child;
import entities.Gift;
import roundstatus.ChildStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A class which performs a yellow elf strategy: for the child the yellow elf strategy is applied
 * to, the child receives a gift (only if he hasn't received any gifts this year) and we have the
 * cheapest gift in the database.
 */
public class YellowElfStrategy implements ElfStrategy {

    /**
     * A method which applies the yellow elf strategy to the child with the given status
     * @param status the status of the child to which the strategy must be applied.
     */
    @Override
    public void applyGiftStrategy(final ChildStatus status) {
        Database database = Database.getDatabase();
        Child child = database.getChildren().get(status.getId());

        if (!status.getGifts().isEmpty()) {
            return;
        }

        List<Gift> availableGifts = new ArrayList<Gift>(database.getGifts().get(child
                .getGiftsPreferences().get(0)).keySet());

        availableGifts.sort(Comparator.comparingDouble(Gift::getPrice));

        int quantity = database.getGifts().get(child.getGiftsPreferences().get(0))
                .get(availableGifts.get(0));

        if (availableGifts.isEmpty() || quantity == 0) {
            return;
        }

        status.getGifts().add(availableGifts.get(0));
        database.getGifts().get(child.getGiftsPreferences().get(0)).
                replace(availableGifts.get(0), quantity - 1);
    }
}
