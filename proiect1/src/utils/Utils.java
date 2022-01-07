package utils;

import java.util.List;

public class Utils {
    public Utils() { }

    public static double getMean(List<Double> list) {
        return Utils.getSum(list) / list.size();
    }

    public static double getWeightedMean(List<Double> list) {
        double sum = 0;

        for (int i = 0; i < list.size(); ++i) {
            sum += (i + 1) * list.get(i);
        }

        return 2 * sum / (list.size() * list.size() + list.size());
    }

    public static double getSum(List<Double> list) {
        double sum = 0;
        for (Double number : list) {
            sum += number;
        }

        return sum;
    }
}
