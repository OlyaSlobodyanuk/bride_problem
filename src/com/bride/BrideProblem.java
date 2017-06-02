package com.bride;

/**
 * Bride problem program
 *
 * @author  Olga Slobodyanuk
 * @version 0.1
 */

import java.math.BigInteger;
import java.util.Comparator;
import com.bride.Comparator.*;

public class BrideProblem
{
    private static Comparator gComparator;
    private static Groom[] groom;
    private static final int n = 5;

    /**
     * Calculate factorial
     * @param n - number
     * @return BigInteger factorial
     */
    public static BigInteger factorial(BigInteger n) {
        if(n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return factorial(n.subtract(BigInteger.ONE)).multiply(n);
    }

    /**
     * Swap two elements in groom array
     * @param array - array of Groom
     * @param i - index of first groom
     * @param j - index of second groom
     */
    public static void swap(Groom[] array, int i, int j) {
        Groom temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Generate new permutation of elements
     * @param array - array of groom
     * @return boolean - false if there is no another permutation
     */
    public static boolean nextSet(Groom[] array) {
        int j = array.length - 2;
        while (j != -1 && array[j].getId() >= array[j + 1].getId())
            j--;
        if (j == -1)
            return false; // больше перестановок нет
        int k = array.length - 1;
        while (array[j].getId() >= array[k].getId())
            k--;
        swap(array, j, k);
        int l = j + 1, r = array.length - 1; // сортируем оставшуюся часть последовательности
        while (l<r)
            swap(array, l++, r--);
        return true;
    }

    /**
     * Print elements from array
     * @param array
     */
    public static void print(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Simulate optimal strategy. Skip sampleSize grooms and select first better groom
     * @param array - array of grooms
     * @param sampleSize - size of set, which we skip
     * @return boolean - true if we win
     */
    public static boolean optimalStrategy(Groom[] array, int sampleSize) {
        Groom best = new Groom(0), max = best;
        for(int i = 0; i < array.length; i++) {
            if(gComparator.compare(array[i], best) == 1) {
                best = array[i];
            }
        }

        for(int i = 0; i < sampleSize; i++) {
            if(gComparator.compare(array[i], max) == 1) {
                max = array[i];
            }
        }

        for(int i = sampleSize; i < array.length; i++) {
            if(gComparator.compare(array[i], max) == 1) {
                if(gComparator.compare(array[i], best) == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Simulate situation on all permutation of grooms.
     */
    public static void bridgeProblem() {
        int[] sampleSize = new int[n];

        BigInteger factorialOfN = factorial(BigInteger.valueOf(n));
        while((factorialOfN = factorialOfN.subtract(BigInteger.ONE)).compareTo(BigInteger.ZERO) != -1) {
            for (int i = 0; i < sampleSize.length; i++) {
                if (optimalStrategy(groom, i)) {
                    sampleSize[i]++;
                }
            }
            nextSet(groom);
            System.out.println(factorialOfN);
        }
        print(sampleSize);
    }

    /**
     * Initialize array of grooms
     */
    private static void initializeGroom() {
        groom = new Groom[n];
        for (int i = 0; i < n; i++) {
            groom[i] = new Groom(i + 1, new int[] {(i+5)*(i+5), (6-i), (i+5)*(i+5), (i+5)*(i+5)});
        }
    }

    /**
     * Main function. Uncomment line with necessary comparator
     */
    public static void main(String[] args) {
        initializeGroom();
        //gComparator = new GroomIdComparator();
        //gComparator = new GroomIdealPointComparator(groom);
        //gComparator = new GroomLinearComparator(new double[] {0.2, 0.2, 0.2, 0.4});
        //gComparator = new GroomMainCriterionComparator(0, new int[] {0, 30});
        //gComparator = new GroomMaxMinComparator();
        gComparator = new GroomMultiplComparator(new double[] {0.2, 0.2, 0.2, 0.4});

        bridgeProblem();
    }
}
