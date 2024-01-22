package sandbox;

import java.util.Arrays;
import java.util.HashMap;

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
                //c2++;
                int min = arr[i];
                int n = i;
                while (n -delta  >= 0) {
                    c2++;
                    if (min < arr[n - delta]) {

                        //c3++;
                        arr[n] = arr[n - delta];
                        n -= delta;
                    } else {break;}
                }
                arr[n] = min;
            }
          // System.out.println(Arrays.toString(arr));
        }

      //  System.out.println("result: " + Arrays.toString(arr));
       // System.out.println("c1: " + c1+ "; c2: " + c2 +"; c3: " +c3);

        long n = arr.length;
        long total = c1 + c2 + c3;

        double logn = 3 * n * (Math.log(n) / Math.log(2));



        double s = n * (Math.log(n) / Math.log(2)) - n +1 + ((Math.pow(n, 2) - n) / 2);

        double lgn = ceilbinlog((int)n);
        double c2log = n * lgn - uppern((int)n);
//System.out.println(uppern((int)n));
       /* System.out.println("n: " + n+ ", s: " + s + "; shifts: " + total + "(" + (((Math.pow(n, 2) - n) / 4)) + "); outer: " + total);
        System.out.println("n * log (n) > count? " + logn + " ~ " + total +"; " +   (logn > total) );
        System.out.println("n^2  > count? " + Math.pow(n, 2) + " ~ " + total + "; " +   (Math.pow(n, 2) > total));
        System.out.println("n^1.1  > count? " + Math.pow(n, 1.1) + " ~ " + total + "; " +   (Math.pow(n, 1.1) > total));
*/
        System.out.println(
            "$" + n + "$ & $" +
                c2log + "$ $" +
                    Math.pow(n, 1.1) + "$ & $" +
                    Math.pow(n, 1.3)  + "$ & $" +
                (n* (Math.log(n) / Math.log(2))) + "$ & $" +

                Math.pow(n, 2)  +"$ & "
                );
        //

        System.out.println("["+n+"] " +(c2 < n*lgn) +" " + (c2  < Math.pow(n, 1.3)) + " " + ( n*lgn < Math.pow(n, 1.3)));// c2log < n*lgn && Math.pow(n, 1.3) < n*lgn ));
        //System.out.println("["+n+"] " + (c2log > n*lgn && c2log <  Math.pow(n, 1.3) && Math.pow(n, 1.3) < lgn));

       // System.out.println("["+n+"] 1.1: " + (Math.pow(n, 1.1) > c2log) + "; 1.3: " + (Math.pow(n, 1.3) > c2log) + "(" + (Math.pow(n, 1.3) > n*lgn ) +", " + c2log +", " + c2 + "); n*lg(n): " + (n*lgn > c2log));
  //      System.out.println("n^1.3  > count? " + Math.pow(n, 1.3) + " ~ " + total + "; " +   (Math.pow(n, 1.3) > total));

        return arr;
    }

    public static int[] sortLog(int[] feld, HashMap<String, Integer> hits) {

        int i, j;
        int n = feld.length;
        int distanz = n / 2;
        int temp;
        long c1 = 0, c2 = 0, c3 = 0, c4 = 0;

        while (distanz > 0) {

            c1++;

            for (i = distanz; i < feld.length; i++) {
                j = i - distanz;

                c2++;

                while (j >= 0) {
                    c3++;
                    if (feld[j] > feld[j + distanz]) {
                        c4++;
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

        increment(n, c4, hits);

        return feld;
    }

    public static void increment(double n, double x, HashMap<String, Integer> hits) {
        String key;
        double n1_1 = Math.pow(n, 1.1);
        double n1_3 = Math.pow(n, 1.3);
        double n2 = Math.pow(n, 2);
        double nlgn = n * (Math.log(n) / Math.log(2));


        if (x <= n1_1) {
            key = "x < n^1.1";
            hits.put(key, hits.get(key) != null ? hits.get(key) + 1 : 1);
        } else if (x <= nlgn && nlgn <= n1_3) {

            key = "x < nlgn < n^1.3";
            hits.put(key, hits.get(key) != null ? hits.get(key) + 1 : 1);

        } else if (x <= n1_3 && n1_3 <= nlgn) {

            key = "x < n^1.3 < nlgn";
            hits.put(key, hits.get(key) != null ? hits.get(key) + 1 : 1);

        } else if (nlgn <= x && x <= n1_3) {
            key = "nlgn < x < n^1.3";
            hits.put(key, hits.get(key) != null ? hits.get(key) + 1 : 1);

        } else if (n1_3 <= x  && x <= nlgn) {

            key = "n^1.3 < x < nlgn";
            hits.put(key, hits.get(key) != null ? hits.get(key) + 1 : 1);

        } else if (n1_3 <= nlgn && nlgn <= x && x <= n2) {

            key = "n^1.3 < nlgn < x < n^2";
            hits.put(key, hits.get(key) != null ? hits.get(key) + 1 : 1);

        } else if (nlgn <= n1_3 && n1_3 <= x && x <= n2) {
            key = "nlgn < n^1.3 < x < n^2";
            hits.put(key, hits.get(key) != null ? hits.get(key) + 1 : 1);
        }

    }


    public static int uppern(int n) {

        int i = ceilbinlog(n);
        int res = 0;

        while (i > 0) {
            int floored = (n / (int)Math.pow(2, i));
          //  if (floored == 0 || res + floored >= n) {
            //    break;
          //  }
            res += floored;
            i--;
        }

        return res;
    }
    public static int ceilbinlog(int bits) // returns 0 for bits=0
    {
        int log = 0;
        if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
        if( bits >= 256 ) { bits >>>= 8; log += 8; }
        if( bits >= 16  ) { bits >>>= 4; log += 4; }
        if( bits >= 4   ) { bits >>>= 2; log += 2; }
        return log + ( bits >>> 1 );
    }
}
