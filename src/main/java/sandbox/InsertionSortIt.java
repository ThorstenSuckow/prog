package sandbox;

public class InsertionSortIt {


    public static int[] sort(int[] arr) {

        int vergleiche = 0;
        for (int i = 1; i < arr.length; i++) {

            int min = arr[i];
            int n = i;
            while (n > 0 && arr[n - 1] > min) {
                vergleiche++;
                arr[n] = arr[n - 1];
                n--;
            }

            arr[n] = min;

        }
        System.out.println(vergleiche);
        return arr;

    }

}
