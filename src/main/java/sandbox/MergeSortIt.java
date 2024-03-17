package sandbox;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MergeSortIt {

    public static int[] sort(int[] arr) {

        String orgArr = Arrays.toString(arr);
        AtomicInteger c =  new AtomicInteger(0);
        int[] res = sort(arr, c);

        System.out.println(orgArr + " required " + c.get() + " sorting steps");

        return res;
    }

    public static int[] sort(int[] arr, AtomicInteger c) {

        if (arr.length == 1) {
            return arr;
        }

        arr = sort(arr, 0,  arr.length -1, c);

        return arr;
    }


    protected static int[] sort(int[] arr, int start, int end, AtomicInteger c) {

        if (arr.length == 1) {
            return arr;
        }

        int mid = (start + end) / 2;
        int[] left = partition(arr, start, mid);
        int[] right = partition(arr, mid + 1, end);

        c.set(c.get() + 1);
        left = sort(left, c);
        right = sort(right, c);

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
        int c = 0;
        while (pos < arr.length) {
            if (left[leftIdx] < right[rightIdx]) {
                arr[pos] = left[leftIdx++];
            } else {
                arr[pos] = right[rightIdx++];
            }
            c++;
            pos++;
        }

        System.out.println( c +  " merges");
        return arr;
    }


    protected static int[] sentinel(int[] target) {
        int[] sentinel = Arrays.copyOf(target, target.length + 1);
        sentinel[target.length] = Integer.MAX_VALUE;

        return sentinel;
    }

}
