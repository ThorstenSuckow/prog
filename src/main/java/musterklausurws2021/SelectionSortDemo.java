package musterklausurws2021;

public class SelectionSortDemo {

    public static int[] sort(int[] arr) {

        int i=0, min=0, minIndex=0, vergleiche = 0;

        int c1 = 0;
        while (i<arr.length-1) {
            min = arr[i];
            minIndex = i;
            c1++;
            for (int j = i + 1; j < arr.length; j++) {
                vergleiche++;
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
            i++;
        }

        System.out.println(c1 + " " + vergleiche);

        return arr;

    }


    public static void main(String[] args) {

        int length = 5;

        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }

        sort(arr);

    }

}
