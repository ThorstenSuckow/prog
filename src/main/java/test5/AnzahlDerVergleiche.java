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
                while (j >= 0) {                        // n / 2
                    if (feld[j] > feld[j + distanz]) {
                        swap(feld, j, j + distanz);
                        j = j - distanz;
                    } else {
                        j=-1;
                    }
                    count++;
                }
            }
            distanz = distanz / 2;
        }

        System.out.println("COUNT A: " + count);
        return feld;
    }


    public static int[] second(int[] feld) {

        int i, j;
        int temp;
        int n = feld.length;
        int distanz = n / 2;

        int count = 0;
        System.out.println("N: " + n);
        while (distanz > 0)                                      // lg n
        {
            System.out.println("DISTANZ: " + distanz);
            for (i = distanz; i < feld.length; i++)
            {
                j =  i - distanz;

                while (j >= 0) { //
                    if (feld[j] > feld[j + distanz]) { // n
                        //Vertauschen der beiden Feldwerte
                        temp = feld[j];
                        feld[j] = feld[j + distanz];
                        feld[j + distanz] = temp;
                        j = j - distanz;
                    } else {
                        break;
                    }
                    count++;

                }

             }
            distanz = distanz / 2;
        }

        System.out.println("COUNT B: " + count);
        return feld;
    }

    public static void main(String[] args) {



    }

}
