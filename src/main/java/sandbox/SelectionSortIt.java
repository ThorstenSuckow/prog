package sandbox;

public class SelectionSortIt {


    public static int[] sort(int[] arr) {

        int minIdx;
        for (int i = 0; i < arr.length; i++) {

            minIdx = i;

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;

        }

        return arr;
    }
}
