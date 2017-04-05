package sdacademy.pl.simplelistofnumbers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RENT on 2017-04-05.
 */
public class StatisticTest {

//    nie mozna tej listy edytowac

    List<Integer> testList = Arrays.asList(2,32,3,1,12);

    @Test
    public void maxValue() throws Exception {
        int result = Statistic.maxValue(testList);
        assert 32 == result;

    }

    @Test(expected = IllegalArgumentException.class)
    public void maxEmptyList() throws Exception {
        Statistic.maxValue(Collections.EMPTY_LIST);

    }


    @Test
    public void minValue() throws Exception {
        int result = Statistic.minValue(testList);
        assert 1 == result;
    }

    @Test(expected = IllegalArgumentException.class)
    public void minEmptyList() throws Exception {
        Statistic.minValue(Collections.EMPTY_LIST);
    }

    @Test
    public void avgValue() throws Exception {
        double result = Statistic.avgValue(testList);
        assert 10.0 == result;
    }

    @Test
    public void avgEmptyList() throws Exception {
        assert Statistic.avgValue(Collections.EMPTY_LIST) == 0;
    }


}