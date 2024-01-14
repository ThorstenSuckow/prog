package sandbox;

import java.util.Arrays;

public class FindMax {

    public static int max(int[] arr) {
       return max(arr, 0,  arr.length -1);
    }

    public static int max(int[] field, int start, int end) {

        if (end == start) {
            return field[end];
        }

        int mid = (start + end) / 2;

        int maxA = max(field, start, mid);
        int maxB = max(field, mid + 1, end);

        return Math.max(maxA, maxB);
    }

    public static int[] divide(int[] field, int start, int end) {
        return Arrays.copyOfRange(field, start, end + 1);
    }


}
