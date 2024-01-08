package sandbox;

import java.util.Arrays;

public class SelectionSort {


    public static int[] sort(int[] arr) {

        int min, tmp;
        for (int i = 0; i < arr.length; i++) {
            min = i;

            // find the minimum element in the remaining array
            // relative to index i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // change the elements, i becomes the new minimum
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;

        }


        return arr;
    }


}
