package sdacademy.pl.simplelistofnumbers;


import java.util.List;

public class Statistic {

public int maxValue(List<Integer> numbers) {
    int max = numbers.get(0);

    for (int i = 0; i < numbers.size(); i++) {
        if(max < numbers.get(i)) {
            max = numbers.get(i);
        }
    }
    return max;
}

public int minValue(List<Integer> numbers) {
    int min = numbers.get(0);

    for (int i = 0; i < numbers.size(); i++) {
        if(min > numbers.get(i)) {
            min = numbers.get(i);
        }
    }
    return min;
}

public int avgValue(List<Integer> numbers) {
    int sum = 0;

    for (int i = 0; i < numbers.size(); i++) {
        sum += numbers.get(i);
    }

    return sum/numbers.size();
}
}
