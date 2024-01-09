package sandbox;

import java.util.Arrays;

public class BubbleSort {


    public static int[] sort(int[] arr) {

        boolean bubbled;
        for (int i = arr.length - 1; i > 0; i--) {
            bubbled = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j +1]) {
                    int min = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = min;
                    bubbled = true;
                }
            }
            if (!bubbled) {
                break;
            }
        }

        return arr;

    }


}
