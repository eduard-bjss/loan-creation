package com.bjss.accelerator.generator;

import java.util.PrimitiveIterator;
import java.util.Random;

public class DoubleInRangeNumberGenerator {
    private final PrimitiveIterator.OfDouble randomIterator;

    public DoubleInRangeNumberGenerator(double min, double max) {
        randomIterator = new Random().doubles(min, max + 0.1).iterator();
    }

    public double nextDouble() {
        return randomIterator.nextDouble();
    }
}
