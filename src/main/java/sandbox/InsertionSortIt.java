package sandbox;

public class InsertionSortIt {


    public static int[] sort(int[] arr) {


        for (int i = 1; i < arr.length; i++) {

            int min = arr[i];
            int n = i;
            while (n > 0 && arr[n - 1] > min) {
                arr[n] = arr[n - 1];
                n--;
            }

            arr[n] = min;

        }

        return arr;

    }

}
