package sandbox;

import java.util.Arrays;

public class QuicksortDemo {

    public static int[] sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quicksort (int[] arr, int l , int r) {

        if (l >= r) {
            return;
        }
        int i = l;
        int j = r - 1;
        int pivot = arr[r];

        while (i <= j) {
            while (i < r && arr[i] <= pivot) {
                i++;
            }

            while (j >= 0 && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }

        }

        arr[r] = arr[i];
        arr[i] = pivot;


        quicksort(arr, l, i - 1);
        quicksort(arr, i + 1, r);
    }

}
