import java.math.BigInteger;

/**
 * Created by AstureS on 01.06.2017.
 */

public class SecretaryProblem
{
    //private static final int MAX_LONG = 2147483;
    private static final int MAX_LONG = 3;

    public static BigInteger factorial(BigInteger n) {
        if(n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return factorial(n.subtract(BigInteger.ONE)).multiply(n);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void copy(int[] input, int[] output) {
        for(int i = 0; i < input.length; i++) {
            output[i] = input[i];
        }
    }

    public static boolean nextSet(int[] array) {
        int j = array.length - 2;
        while (j != -1 && array[j] >= array[j + 1])
            j--;
        if (j == -1)
            return false; // больше перестановок нет
        int k = array.length - 1;
        while (array[j] >= array[k])
            k--;
        swap(array, j, k);
        int l = j + 1, r = array.length - 1; // сортируем оставшуюся часть последовательности
        while (l<r)
            swap(array, l++, r--);
        return true;
    }

    public static void print(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static boolean optimalStrategy(int[] array, int sampleSize) {
        int best = 0, max = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > best) {
                best = array[i];
            }
        }

        for(int i = 0; i < sampleSize; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }

        for(int i = sampleSize; i < array.length; i++) {
            if(array[i] > max ) {
                if(array[i] == best) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    /*public static void secretaryProblem(int n) {
        int[] sampleSize = new int[n];

        BigInteger factorialOfN = factorial(BigInteger.valueOf(n));
        BigInteger factorialTemp = factorialOfN;
        while (true) {
            int[][] array = new int[MAX_LONG][n];
            for (int i = 0; i < n; i++) {
                array[0][i] = i + 1;
            }
            for (int i = 1; i < array.length; i++) {
                copy(array[i - 1], array[i]);
                nextSet(array[i]);
            }

            for (int i = 0; i < sampleSize.length; i++) {
                for (int f = 0; f < array.length; f++) {
                    if (optimalStrategy(array[f], i)) {
                        sampleSize[i]++;
                    }
                }
            }
            factorialTemp = factorialTemp.subtract(BigInteger.valueOf(MAX_LONG));
            if(factorialTemp)
        }
        print(sampleSize);
    }*/

    public static void secretaryProblem(int n) {
        int[] sampleSize = new int[n];
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        BigInteger factorialOfN = factorial(BigInteger.valueOf(n));
        while((factorialOfN = factorialOfN.subtract(BigInteger.ONE)).compareTo(BigInteger.ZERO) != -1) {
            for (int i = 0; i < sampleSize.length; i++) {
                if (optimalStrategy(array, i)) {
                    sampleSize[i]++;
                }
            }
            nextSet(array);
            System.out.println(factorialOfN);
        }
        print(sampleSize);
    }

    public static void main(String[] args) {
        secretaryProblem(12 );
    }
}
