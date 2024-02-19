package sandbox;

import java.util.Arrays;

public class BubbleSortIt {


    public static int[] sort(int[] arr) {

        boolean swapped = true;
        int tmp;

        String org = Arrays.toString(arr);

        int c = 0;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    c++;
                    tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                    swapped = true;
                }
            }
        }

        System.out.println(org + ": required " + c + " swaps");
        return arr;
    }


}
