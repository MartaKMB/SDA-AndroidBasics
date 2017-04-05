package sdacademy.pl.simplelistofnumbers;


import java.util.List;

public class Statistic {

    public static int maxValue(List<Integer> numbers) {

        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List can't be empty!");
        }

        int max = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static int minValue(List<Integer> numbers) {

        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List can't be empty!");
        }

        int min = numbers.get(0);

        for (int i = 0; i < numbers.size(); i++) {
            if (min > numbers.get(i)) {
                min = numbers.get(i);
            }
        }
        return min;
    }

    public static double avgValue(List<Integer> numbers) {
        double sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        return sum / numbers.size();
    }
}
