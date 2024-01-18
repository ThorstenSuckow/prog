package sandbox;

import java.util.Arrays;

public class ShellSort {


    public static int[] sort(int[] arr) {

        int[] increments = new int[(int) (Math.log(arr.length) / Math.log(2))];

        int n = arr.length / 2;
        int i = 0;
        while (n > 0) {
            increments[i++] = n;
            n /= 2;
        }

        return sort(arr, increments);
    }
    public static int[] sort(int[] arr, int[] increments) {
        int count = 0;
        for (int a = 0; a < increments.length; a++) {

            int delta = increments[a];

            for (int i = delta; i < arr.length; i++) {
                count++;
                int min = arr[i];
                int n = i;
                while (n - delta >= 0 && min < arr[n - delta]) {
                    count++;
                    arr[n] = arr[n - delta];
                    n -= delta;
                }
                arr[n] = min;
            }

        }

        int n = arr.length;
        double logn = 3 * n * (Math.log(n) / Math.log(2));
        System.out.println("n: " + n);
        System.out.println("n * log (n) > count? " + logn + " ~ " + count +"; " +   (logn > count) );
        System.out.println("n^2  > count? " + Math.pow(n, 2) + " ~ " + count + "; " +   (Math.pow(n, 2) > count));
        System.out.println("n^1.1  > count? " + Math.pow(n, 1.1) + " ~ " + count + "; " +   (Math.pow(n, 1.1) > count));
        System.out.println("n^1.3  > count? " + Math.pow(n, 1.3) + " ~ " + count + "; " +   (Math.pow(n, 1.3) > count));

        System.out.println("runtime?: " + ((3*logn/2 - n +1)) + " = " + count);

        System.out.println();


        return arr;
    }


}
