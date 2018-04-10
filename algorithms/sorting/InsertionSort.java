package algorithms.sorting;

/**
 * Insertion sort
 * Time complexity: O(n2)
 * - uses two nested loops
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {12, 2, 11, 8, 13, 5, 6};

        insertionSort(arr);

        for (int v : arr) {
            System.out.print(v + " ");
        }
    }

    protected static void insertionSort(int[] arr) {
        int n = arr.length;

        //take the first element j=0 and compare it with the "unsorted part" of the array
        for (int i = 1; i < n; i++) {
            int key = arr[i]; //first unsorted element
            int j = i - 1;

            //shifting elements of arr[0...i-1] that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
    }

}
