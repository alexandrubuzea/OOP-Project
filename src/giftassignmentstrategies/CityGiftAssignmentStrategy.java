package giftassignmentstrategies;

import database.Database;
import entities.Child;
import enums.Cities;
import roundstatus.Round;
import utils.Utils;

import java.util.stream.Collectors;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class CityGiftAssignmentStrategy implements GiftAssignmentStrategy {

    /**
     * A method which returns a list of sorted integers based on the city nice score (the mean
     * of nice scores of all children living in that city). In case of equality, other criteria
     * are applied: the children are sorted lexicographically after city name, then after their ID.
     * @param round the round for which the strategy must be applied
     * @return A sorted list containing the integers.
     */
    @Override
    public List<Integer> applyAssignmentStrategy(final Round round) {
        Database database = Database.getDatabase();

        Map<Cities, Double> scores = new LinkedHashMap<>();

        List<Cities> cities = Cities.getCities();

        for (Cities city : cities) {
            List<Child> children = new ArrayList<>(database.getChildren().values());
            children.removeIf((child) -> !child.getCity().equals(city));
            children.sort(Comparator.comparingInt(Child::getId));
            if (children.isEmpty()) {
                scores.put(city, 0.0);
                continue;
            }

            scores.put(city, Utils.getMean(new ArrayList<>(children.stream()
                    .map((child) -> round.getGlobalStatus().get(child.getId()).getAverageScore())
                    .collect(Collectors.toList()))));
        }

        List<Integer> ids = new ArrayList<>(round.getGlobalStatus().keySet());

        ids.sort((o1, o2) -> {
            Cities city1 = database.getChildren().get(o1).getCity();
            Cities city2 = database.getChildren().get(o2).getCity();

            if (!Objects.equals(scores.get(city1), scores.get(city2))) {
                return scores.get(city1) > scores.get(city2) ? -1 : 1;
            }

            int comparisonResult = city1.toString().compareTo(city2.toString());
            if (comparisonResult != 0) {
                return comparisonResult;
            }

            return o1 - o2;
        });

        return ids;
    }
}
