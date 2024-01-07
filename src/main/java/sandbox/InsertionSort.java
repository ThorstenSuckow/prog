package sandbox;

import java.util.Arrays;

public class InsertionSort {



    public static int[] sortLower(int[] arr) {

        int min, tmp;
        for (int i = 0; i < arr.length - 1; i++) {

            int n = i + 1;
            while (n > 0 && arr[n] < arr[n - 1]) {
                    System.out.print(" -- " + Arrays.toString(arr) + ": " + arr[n] + " < " + arr[n - 1]);
                    tmp = arr[n - 1];
                    arr[n - 1] = arr[n];
                    arr[n] = tmp;
                    System.out.println(": " + Arrays.toString(arr));

                n--;
            }
        }


        return arr;
    }


    public static int[] sort(int[] arr) {

        int min;
        for (int i = 1; i < arr.length; i++) {

            int n = i;
            min = arr[i];
            while (n > 0 && arr[n - 1] > min) {
                //System.out.println(arr[n - 1] +" > " + min + ": " + Arrays.toString(arr));
                arr[n] = arr[n - 1];
                n--;
            }
            arr[n] = min;
            //System.out.println("   -> (" + min + ") " + Arrays.toString(arr));
        }


        return arr;
    }


}
