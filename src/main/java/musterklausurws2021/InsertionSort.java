package musterklausurws2021;

public class InsertionSort {


    public static int[] sort(int[] arr) {


        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            /*while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }*/

            while (j >= 0) {
                if (key < arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }

            arr[j + 1] = key;

        }

        return arr;
    }

}
