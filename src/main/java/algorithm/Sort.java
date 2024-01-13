package algorithm;

import java.util.Arrays;

public class Sort {

    public static void bubbleSort(int[] list) {
        bubbleSort(list, 0, list.length -1);
    }

    public static void bubbleSort(int[] list, int leftIdx, int rightIdx) {

        checkBoundaries(list.length, leftIdx, rightIdx);

        for (int i = leftIdx; i < rightIdx; i++) {
            bubbleUp(list, leftIdx, rightIdx);
        }
    }



    public static void bubbleUp(int[] list, int leftIdx, int i) {

        checkBoundaries(list.length, leftIdx, i);

        for (int a = leftIdx; a < i; a++) {
            if (list[a] > list[a + 1]) {
                swap(list, a, a+1);
            }
        }
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static void quickSort(int[] list, int leftIdx, int rightIdx) {
        checkBoundaries(list.length, leftIdx, rightIdx);

        int pivotIdx = divide(list, leftIdx, rightIdx);

        if (pivotIdx - leftIdx > 0) {
            quickSort(list, leftIdx, pivotIdx - 1);
        }

        if (rightIdx - pivotIdx > 0) {
            quickSort(list, pivotIdx + 1, rightIdx);
        }

    }


    public static int divide(int[] list, int leftIdx, int rightIdx) {
        checkBoundaries(list.length, leftIdx, rightIdx);

        if (leftIdx == rightIdx) {
            return leftIdx;
        }

        int i     = leftIdx;
        int j     = rightIdx - 1;
        int pivot = list[rightIdx];
        while (true) {
            while (list[i] < pivot) {
                i++;
            }
            while (j >= 0 && list[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }

            swap(list, i, j);
        }
        swap(list, i, rightIdx);

        return i;
    }


    public static void swap(int[] list, int i, int j) {
        checkBoundaries(list.length, i, j);

        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }


    public static String toString(int[] list, int start, int end) {
        checkBoundaries(list.length, start, end);

        return Arrays.toString(Arrays.copyOfRange(list, start, end + 1));
    }


    public static String toString(int[] list) {
        return Arrays.toString(list);
    }


    private static boolean checkBoundaries(int n, int i, int j) throws IllegalArgumentException {
        if (i < 0 || i > j || i >= n || j >= n) {
            throw new IllegalArgumentException();
        }

        return true;
    }


    protected static int[] quickSortRet(int[] list) {
        quickSort(list);
        return list;
    }
}
