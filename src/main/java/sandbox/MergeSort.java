package sandbox;


/**
 * @see <a href="https://www.baeldung.com/java-merge-sort">https://www.baeldung.com/java-merge-sort</a>
 */
public class MergeSort {


    public static int[] sort(int[] arr) {
        return sort(arr, arr.length);
    }

    public static int[] sort(int[] arr, int length) {

        if (length < 2) {
            return arr;
        }
        int pivot = length / 2;
        int[] lft = new int[pivot];
        int[] rgt = new int[length - pivot];

        for (int i = 0; i < pivot; i++) {
            lft[i] = arr[i];
        }
        for (int i = pivot; i < length; i++) {
            rgt[i - pivot] = arr[i];
        }
        sort(lft, pivot);
        sort(rgt, length - pivot);

        merge(arr, lft, rgt, pivot, length - pivot);

        return arr;
    }

    private static void merge(int[] arr, int[] lft, int[] rgt, int left, int right) {
        

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (lft[i] <= rgt[j]) {
                arr[k++] = lft[i++];
            }
            else {
                arr[k++] = rgt[j++];
            }
        }
        while (i < left) {
            arr[k++] = lft[i++];
        }
        while (j < right) {
            arr[k++] = rgt[j++];
        }
    }

}
