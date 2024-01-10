package sandbox;


public class QuickSort {


    public static int[] sort(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    public static int[] sort(int[] arr, int start, int end) {


        if (start >= end) {
            return arr;
        }

        int tmp;
        int i = start;
        int j = end - 1;
        int pivot = arr[end];

        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                if (j - 1 < 0) {
                    break;
                }
                j--;
            }

            if (i >= j) {
                break;
            }

            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        tmp = arr[i];
        arr[i] = pivot;
        arr[end] = tmp;

        if (start < i - 1) {
            arr = sort(arr, start ,  i -1);
        }

        if (i + 1 < end) {
            arr = sort(arr, i + 1, end);
        }


        return arr;
    }


}
