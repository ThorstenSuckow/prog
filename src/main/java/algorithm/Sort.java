package algorithm;

import java.util.Arrays;

public class Sort {

    public static void bubbleSort(int[] list) {
        bubbleSort(list, 0, list.length -1);
    }

    public static void bubbleSort(int[] list, int leftIdx, int rightIdx) {

        if (leftIdx < 0 || rightIdx >= list.length || leftIdx > rightIdx) {
            throw new IllegalArgumentException();
        }

        for (int i = leftIdx; i < rightIdx; i++) {
            bubbleUp(list, leftIdx, rightIdx);
        }
    }



    public static void bubbleUp(int[] list, int leftIdx, int i) {

        if (leftIdx < 0 || i >= list.length || leftIdx > i) {
            throw new IllegalArgumentException();
        }

        for (int a = leftIdx; a < i; a++) {
            if (list[a] > list[a + 1]) {
                swap(list, a, a+1);
            }
        }
    }


    public static void quickSort(int[] list) {

    }

    public static void quickSort(int[] list, int leftIdx, int rightIdx) {

    }


    public static int divide(int[] list, int leftIdx, int rightIdx) {

        int res = 0;

        return res;
    }

    public static void swap(int[] list, int i, int j) {
        if (i < 0 || i > j || j >= list.length) {
            throw new IllegalArgumentException();
        }

        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;

    }


    public static String toString(int[] list, int start, int end) {
        if (start < 0 || start > end || end >= list.length) {
            throw new IllegalArgumentException();
        }
        return Arrays.toString(Arrays.copyOfRange(list, start, end + 1));
    }

    public static String toString(int[] list) {

        return Arrays.toString(list);

    }

}
