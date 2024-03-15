package sandbox;

import java.util.Arrays;

public class InsertionSortProtocol {


    // 3 2 1

    public static int[] sort(int[] arr) {


        for (int i = 0; i < arr.length; i++) {

            int min = arr[i];
            int j = i;

            while (j > 0 && min < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;

                System.out.println(" >> " + Arrays.toString(arr));
            }

            arr[j] = min;
            System.out.println(" " + Arrays.toString(arr));
        }

        return arr;
    }

}
