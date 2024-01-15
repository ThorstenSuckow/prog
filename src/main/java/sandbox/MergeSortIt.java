package sandbox;

import java.util.Arrays;

public class MergeSortIt {


    public static int[] sort(int[] arr) {

        if (arr.length == 1) {
            return arr;
        }

        arr = sort(arr, 0,  arr.length -1);

        return arr;
    }


    protected static int[] sort(int[] arr, int start, int end) {

        if (arr.length == 1) {
            return arr;
        }

        int mid = (start + end) / 2;
        int[] left = partition(arr, start, mid);
        int[] right = partition(arr, mid + 1, end);

        left = sort(left);
        right = sort(right);

        arr = merge(arr, left, right, start);

        return arr;
    }

    protected static int[] partition(int[] arr, int start, int end) {

        if (start < 0 || start > end || start >= arr.length || end >= arr.length) {
            throw new IllegalArgumentException();
        }

        return Arrays.copyOfRange(arr, start, end + 1);
    }

    protected static int[] merge(int[] arr, int[] left, int[] right, int start) {

        int length = left.length + right.length;

        if (arr.length < length) {
            throw new IllegalArgumentException();
        }

        left = sentinel(left);
        right = sentinel(right);

        int leftIdx = 0;
        int rightIdx = 0;
        int pos = start;
        while (pos < arr.length) {
            if (left[leftIdx] < right[rightIdx]) {
                arr[pos] = left[leftIdx++];
            } else {
                arr[pos] = right[rightIdx++];
            }

            pos++;
        }

        return arr;
    }


    protected static int[] sentinel(int[] target) {
        int[] sentinel = Arrays.copyOf(target, target.length + 1);
        sentinel[target.length] = Integer.MAX_VALUE;

        return sentinel;
    }

}
