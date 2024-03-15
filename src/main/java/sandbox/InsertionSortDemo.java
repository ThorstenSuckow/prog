package sandbox;

public class InsertionSortDemo {

    public static int[] sort(int[] arr) {

        int n = arr.length;

        int vergleiche = 0;

        for (int i = 1; i < n; i++) {
            int min = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > min) {
                vergleiche++;
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = min;
        }

        System.out.println(vergleiche);
        return arr;
    }

}
