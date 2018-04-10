package algorithms.problems;

import java.util.Arrays;

/**
 * Equilibrium index problem. Also known as Balanced sum.
 * <p>
 * The main idea is that you should find the index from a given array
 * for which the left sum is equal to the right sum
 * <p>
 * For example, let's say you have the following array A = {1, 2, 3, 3},
 * the index for which we are looking for is therefore 2 because
 * the left sum: A[0] + A[1] is equal to the right one: A[3],
 * therefore it is named the equilibrium index of this array
 */
public class EquilibriumIndex {

    public static void main(String[] args) {
        //the equilibrium index is, obviously 2
        int[] firstArr = {1, 2, 3, 3};

        //there are two equilibrium indexes: 3 and 6
        int[] secondArr = {-7, 1, 5, 2, -4, 3, 0};

        System.out.println(equilibriumIndex(firstArr));
        System.out.println(equilibriumIndex(secondArr));
    }

    /**
     * Preferred method
     * Time Complexity: O(n)
     * More efficient than the other method
     * <p>
     * The idea is to firstly get the total sum of the array, then Iterate through it and keep updating the left sum.
     * <p>
     * Returns the first equilibrium index found or -1 if not found
     */
    public static int equilibriumIndex(int[] arr) {
        long leftSum = 0L;
        long rightSum = Arrays.stream(arr).asLongStream().sum();

        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }

    /**
     * Slower so definitely not the best aproach
     * Time complexity: O(n2)
     * Returns the first equilibrium index found or -1 if not found
     */
    public static int equilibriumIndexSecondMethod(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            long leftSum = 0;
            long rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            for (int k = i + 1; k < n; k++) {
                rightSum += arr[k];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

}
