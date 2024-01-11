package sandbox;

public class SelectionSortIt {


    public static int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }

        }

        return arr;
    }
}
