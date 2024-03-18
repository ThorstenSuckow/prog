package sandbox;

import java.util.Arrays;

/***************************  Heap.java  **********************************/

/*
 *  Iteratives Sortieren mit Heapsort
 *  Entnimm einem Heap so lange das kleinste Element, bis er leer ist.
 *  Die entnommenen Elemente werden im selben Array gespeichert.
 */

public class HeapDemo
{
    private static long vergleiche = 0;


    public static void heapSort(int[] a) {

        heapSort(a, a.length - 1);

    }


    private static void lasseEinsinken(int[] feld, int root, int m)
    {
        int tmp = feld[root];
        int rootValue = Integer.MIN_VALUE;

        int lft = (root) * 2 + 1;
        int rgt = (root) * 2 + 2;

        if (lft >= m && rgt >= m) {
            return;
        }

        int childLeft = lft < m ? feld[lft] : Integer.MIN_VALUE;
        int childRight = rgt < m ? feld[rgt] : Integer.MIN_VALUE;

        vergleiche++;
        if (tmp < Math.max(childLeft, childRight)) {
            if (childLeft < childRight) {
                rootValue = feld[rgt];
                feld[rgt] = tmp;
                feld[root] = rootValue;
                lasseEinsinken(feld, rgt, m);
            } else {
                rootValue = feld[lft];
                feld[lft] = tmp;
                feld[root] = rootValue;
                lasseEinsinken(feld, lft, m);
            }
        }

        if (root > 0) {
           lasseEinsinken(feld, --root, m);
        }
    }


    public static void heapSort (int[] feld, int n)
    {

        lasseEinsinken(feld, feld.length/2, n);

        while (n > 0) {
            int last = feld[n];
            feld[n] = feld[0];

            feld[0] = last;
            System.out.println(Arrays.toString(feld));
            lasseEinsinken(feld, 0, n--);
        }
    }


    private static void feldAusgabe (int[] feld)
    {
        for (int i = 0; i < feld.length; i++)
            System.out.print(feld[i] + " ");
        System.out.println();
    }


    public static void main (String[] args)
    {

        int[] feld = {56,22,79,27,9,30,61,4,69,38,52,89,23,17,68,30};
        System.out.println(Arrays.toString(feld));
        heapSort(feld);
        System.out.println(Arrays.toString(feld));

        System.out.println(vergleiche);
        //vergleiche = 0;
        //int feld[] = {56,22,79,27,9,30,61,4,69,38,52,89,23,17,68,30};

        //heapSort(feld);
        /*
        heapSort(feld, feld.length - 1);
        feldAusgabe(feld);
        System.out.println("Anzahl Vergleiche: " + vergleiche );


        int[] zahlenfolge = new int[100000];
        for (int i = 0; i < zahlenfolge.length; i++)
            zahlenfolge[i] = (int) (Math.random() * 10000000);
        //feldAusgabe(zahlenfolge);

        vergleiche = 0;
        // Laufzeit bestimmen usw.

        // ....
*/
    }
}

