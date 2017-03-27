package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayMathTest {

    @Test(expected = IllegalArgumentException.class)
    public void throwException() throws Exception {
        ArrayMath.max(new int[0]);
    }

    @Test
    public void findMax() {
        assertEquals(ArrayMath.max(new int[]{1,-2,23,32, 12}), 32);
        assertEquals(ArrayMath.max(new int[]{1,-2,23,-32, 121}), 121);
    }

}