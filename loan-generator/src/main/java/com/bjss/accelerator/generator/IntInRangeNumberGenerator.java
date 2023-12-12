package com.bjss.accelerator.generator;

import java.util.PrimitiveIterator;
import java.util.Random;

public class IntInRangeNumberGenerator {
    private final PrimitiveIterator.OfInt randomIterator;

    public IntInRangeNumberGenerator(int min, int max) {
        randomIterator = new Random().ints(min, max + 1).iterator();
    }

    public int nextInt() {
        return randomIterator.nextInt();
    }
}
