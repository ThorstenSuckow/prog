package test5;

import java.util.Arrays;

public class AnzahlDerVergleiche {

    public static void swap(int[] list, int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
    public static int[] first(int[] feld) {

        int i, j;
        int n = feld.length;
        int distanz = n / 2;
        int count = 0;

        while (distanz > 0) {                           // lg n
            for (i = distanz; i < feld.length; i++) {   // n / 2
                j = i - distanz;
                count++;
                while (j >= 0) {                        // n / 2
                    if (feld[j] > feld[j + distanz]) {
                        swap(feld, j, j + distanz);
                        j = j - distanz;
                    } else {
                        j=-1;
                    }

                }
            }
            distanz = distanz / 2;
        }

        System.out.println("COUNT A: " + count + ", " + (count/ (double)n));
        return feld;
    }


    public static int[] second(int[] feld) {

        System.out.println(Arrays.toString(feld));

        int i, j;
        int temp;
        int n = feld.length;
        int distanz = n/2;

        int innerCount = 0;
        int whileCount = 0;

        int count = 0;
        int swaps = 0;
        System.out.println("N: " + n);
        while (distanz > 0)                                      // lg n
        {
            whileCount = 0;
            int loopSwaps = 0;
            for (i = distanz; i < feld.length; i++)
            {
                j =  i - distanz;

                count++;
                innerCount++;
                while (j >= 0){// && feld[j] > feld[j + distanz]) { //


                    whileCount++;

                    System.out.println("[incr] " + distanz +"; i,j: [" + i + "," +j + "] ->          " + Arrays.toString(feld));

                    if (feld[j] > feld[j + distanz]) { // n
                        System.out.print("   [swap]       [" + j +", " + (j + distanz) +"]; j: " + (j - distanz));
                        swaps++;
                        innerCount++;
                        loopSwaps++;
                        //Vertauschen der beiden Feldwerte
                        temp = feld[j];
                        feld[j] = feld[j + distanz];
                        feld[j + distanz] = temp;
                        j = j - distanz;
                        System.out.println( " -> " + Arrays.toString(feld) );
                    } else {
                        j = -1;
                    }
                }
             }
            System.out.println(" -- loop swaps: " + loopSwaps);
            System.out.println(" -- while count: " + whileCount);
            System.out.println();
            distanz = distanz / 2;
        }

        System.out.println("COUNT B - total:" + innerCount +"; count: "+ count+";  while: " + (innerCount - count)+ "; swaps: " + swaps);
        return feld;
    }

    public static void main(String[] args) {



    }

}
