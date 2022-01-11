package utils;

import java.util.List;

/**
 * A class that stores some useful methods
 */
public final class Utils {
    private Utils() { }

    /**
     * A method that calculates the arithmetic mean of the double list given
     * @param list a list containing double values
     * @return the arithmetic mean of the values in the given list.
     */
    public static double getMean(final List<Double> list) {
        return Utils.getSum(list) / list.size();
    }

    /**
     * A method that calculates the arithmetic weighted mean of the double list given.
     * The weights of the element in the ith position is (i + 1).
     * @param list a list containing double values
     * @return te arithmetic weighted mean of the values in the given list.
     */
    public static double getWeightedMean(final List<Double> list) {
        double sum = 0;

        for (int i = 0; i < list.size(); ++i) {
            sum += (i + 1) * list.get(i);
        }

        return 2 * sum / (list.size() * list.size() + list.size());
    }

    /**
     * A method which calculates the sum of elements in a double list.
     * @param list the list of elements whose elements must be summed
     * @return the desired sum
     */
    public static double getSum(final List<Double> list) {
        double sum = 0;

        for (Double number : list) {
            sum += number;
        }

        return sum;
    }
}
