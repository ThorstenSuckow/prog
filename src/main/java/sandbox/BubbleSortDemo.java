package sandbox;

public class BubbleSortDemo {

    public static int[] sort(int[] arr) {

        int i, j;
        int n = arr.length;
        int vergleiche = 0;
        boolean swapped = true;
        for (i = n - 1; i >= 0; i--) {
            swapped = false;
            for (j = 0; j < i; j++) {
                vergleiche++;
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        System.out.println(vergleiche);
        return arr;

    }

}
