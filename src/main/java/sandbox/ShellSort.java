package sandbox;

import java.util.Arrays;

public class ShellSort {


    public static int[] sort(int[] arr) {
        return sort(arr, new int[]{6,5,4,3,2,1});
    }
    public static int[] sort(int[] arr, int[] increments) {


        for (int a = 0; a < increments.length; a++) {

            for (int i = increments[a]; i < arr.length; i++) {
                int delta = increments[a];
                int min = arr[i];
                int n = i;
                while (n - delta >= 0 && min < arr[n - delta]) {
                    arr[n] = arr[n - delta];
                    n -= delta;
                }
                arr[n] = min;
            }

        }

        return arr;
    }


}
