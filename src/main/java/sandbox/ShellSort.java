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

        long c1 = 0;
        long c2 = 0;
        long c3 = 0;

        for (int a = 0; a < increments.length; a++) {

            c1++;

            int delta = increments[a];

            for (int i = delta; i < arr.length; i++) {
                c2++;
                int min = arr[i];
                int n = i;
                while (n -delta  >= 0 && min < arr[n - delta]) {
                    c3++;
                    arr[n] = arr[n - delta];
                    n -= delta;
                }
                arr[n] = min;
            }
            System.out.println(Arrays.toString(arr));
        }

      //  System.out.println("result: " + Arrays.toString(arr));
        System.out.println("c1: " + c1+ "; c2: " + c2 +"; c3: " +c3);

        long n = arr.length;
        long total = c1 + c2 + c3;

        double logn = 3 * n * (Math.log(n) / Math.log(2));

        double s = n * (Math.log(n) / Math.log(2)) - n +1 + ((Math.pow(n, 2) - n) / 2);

        System.out.println("n: " + n+ ", s: " + s + "; shifts: " + total + "(" + (((Math.pow(n, 2) - n) / 4)) + "); outer: " + total);
        System.out.println("n * log (n) > count? " + logn + " ~ " + total +"; " +   (logn > total) );
        System.out.println("n^2  > count? " + Math.pow(n, 2) + " ~ " + total + "; " +   (Math.pow(n, 2) > total));
        System.out.println("n^1.1  > count? " + Math.pow(n, 1.1) + " ~ " + total + "; " +   (Math.pow(n, 1.1) > total));
        System.out.println("n^1.3  > count? " + Math.pow(n, 1.3) + " ~ " + total + "; " +   (Math.pow(n, 1.3) > total));

        return arr;
    }

    public static int[] sortAlt(int[] feld) {

        int i, j;
        int n = feld.length;
        int distanz = n / 2;
        int temp;
        int c1 = 0, c2 = 0, c3 = 0;

        while (distanz > 0) {

            c1++;

            for (i = distanz; i < feld.length; i++) {
                j = i - distanz;
                c2++;
                while (j >= 0) {
                    if (feld[j] > feld[j + distanz]) {
                        c3++;
                        temp = feld[j];
                        feld[j] = feld[j + distanz];
                        feld[j + distanz] = temp;
                        j = j - distanz;
                    } else {
                        j=-1;
                    }

                }
            }
            distanz = distanz / 2;
        }

       // System.out.println("result: " + Arrays.toString(feld));
        System.out.println("c1: " + c1+ "; c2: " + c2 +"; c3: " +c3);


        return feld;
    }

}
