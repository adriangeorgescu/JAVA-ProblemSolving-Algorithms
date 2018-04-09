package algorithms.sorting;

/**
 * Bubble sort
 * uses two nested loops, so it's time complexity will be close to O(n2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 9, 4, 2, 15, 3, 8, 5, 7};
        bubbleSort(arr);

        for (int x : arr) {
            System.out.println(x);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int tmp;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

}
