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
    return 0;
}
}
