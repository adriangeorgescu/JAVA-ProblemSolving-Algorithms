package algorithms.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayPairSum {


    /**
     * Find the pairs with given Sum in an Array
     */
    public static void main(String[] args) {
        int set1[] = {2, 4, 3, 5, 6, -2, 7, 8, 9};
        int givenSum1 = 7;

//        int set2[] = {8, 7, 2, 5, 3, 1};
//        int givenSum2 = 10;
//
//        int set3[] = {2, 6, 3, 9, 11};
//        int givenSum3 = 9;

        System.out.print("values = ");
        for (int x : set1) {
            System.out.print(x + " ");
        }
        System.out.println("\ngiven sum = " + givenSum1);
        System.out.println("\n1st Method:");
        arrayPairsWithGivenSumMethod1(set1, givenSum1);
        System.out.println("\n2nd Method:");
        arrayPairsWithGivenSumMethod2(set1, givenSum1);
        System.out.println("#########################\n");
    }


    /**
     * O(nlog(n))
     * <p>
     * Sort the given array beforehand, in ascending order
     * Iterate the array from the leftmost l=0 to the rightmost r=length-1 indexes, while l < r
     * If A[l] + A[r] == sum print it, else if A[l] + A[r] < sum increment l , else decrement r
     *
     * @param values
     * @param givenSum
     */
    public static void arrayPairsWithGivenSumMethod1(int[] values, int givenSum) {
        int n = values.length;
        if (n < 2) {
            return;
        }

        Arrays.sort(values);

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int sum = values[l] + values[r];

            if (sum > givenSum) {
                r--;
            } else if (sum < givenSum) {
                l++;
            } else {
                System.out.println(values[l] + " + " + values[r] + " = " + givenSum);
                r--;
                l++;
            }
        }
    }

    /**
     * O(n). Magical, eh?
     * We'll store all numbers in a hashtable and just check if it contains its complement like so: givenSum-value.
     *
     * @param values
     * @param givenSum
     */
    public static void arrayPairsWithGivenSumMethod2(int[] values, int givenSum) {
        int n = values.length;
        if (n < 2) {
            return;
        }

        HashSet<Integer> hashSet = new HashSet<>(n);

        for (int value : values) {
            int complement = givenSum - value;

            if (!hashSet.contains(complement)) {
                hashSet.add(value);
            } else {
                System.out.println(complement + " + " + value + " = " + givenSum);
            }
        }
    }

}

