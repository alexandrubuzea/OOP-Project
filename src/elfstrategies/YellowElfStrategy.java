package elfstrategies;

import database.Database;
import entities.Child;
import entities.Gift;
import roundstatus.ChildStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class YellowElfStrategy implements ElfStrategy {

    @Override
    public void applyGiftStrategy(ChildStatus status) {
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
