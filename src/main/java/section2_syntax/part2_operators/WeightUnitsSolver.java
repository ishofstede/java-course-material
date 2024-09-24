/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section2_syntax.part2_operators;

public class WeightUnitsSolver {

    /**
     * Returns the number of Pounds, Ounces, and Grams represented by this quantity of grams,
     * encapsulated in a BritishWeightUnits object.
     * @param grams the grams quantity
     * @return a BritishWeightUnits instance
     * @throws IllegalArgumentException when the grams quantity is negative
     */
    public BritishWeightUnits convertFromGrams(int grams) {
        // Ensure grams is not negative
        if (grams < 0) {
            throw new IllegalArgumentException("Error: grams cannot be negative. Given: " + grams);
        }

        // Conversion constants
        final int GRAMS_PER_POUND = 454;
        final int GRAMS_PER_OUNCE = 28;

        // Calculate pounds
        int pounds = grams / GRAMS_PER_POUND;

        // Calculate the remaining grams after pounds
        int remainingGrams = grams % GRAMS_PER_POUND;

        // Calculate ounces
        int ounces = remainingGrams / GRAMS_PER_OUNCE;

        // Calculate remaining grams after ounces
        remainingGrams = remainingGrams % GRAMS_PER_OUNCE;

        // Create and return a BritishWeightUnits instance
        return new BritishWeightUnits(pounds, ounces, remainingGrams);
    }
}

