package sandbox;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test5.AnzahlDerVergleiche;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShellSortTest {


     @Test
     @DisplayName("Papertest")
     public void paperTest() {

         ShellSort.paperrandom();

     }

    @Test
    @DisplayName("ValidateLogN")
    public void testValidateLogN() {

        int n = 100;


        while ((n * Math.log(n) / Math.log(2)) > Math.pow(n, 4/3d)) {
            n++;
        }

        assertEquals(982, n);

    }

    @Test
    @DisplayName("ShellSortLognHits")
    public void testShellSortLognits() {

        HashMap<String, Integer> hits = new HashMap<String, Integer>();

        int epochs = 100;
        while(epochs-- > 0) {
            int[] tests = new int[]{(int)Math.pow(2, 20)};

            for (int i = 0; i < tests.length; i++) {
                int l = tests[i];
                int[] arr = new int[l];

                for (int j = l; j > 0; j--) {
                    arr[l - j] = j;
                }

                ShellSort.sortLog(Arrays.copyOfRange(arr, 0, arr.length), hits);
            }
        }

        for (Map.Entry<String, Integer> entry : hits.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    @DisplayName("ShellSortN2Hits")
    public void testShellSortN2its() {

        HashMap<String, Integer> hits = new HashMap<String, Integer>();

        int epochs = 1;
        while(epochs-- > 0) {
            int[] tests = new int[]{(int)Math.pow(2, 20)};

            for (int i = 0; i < tests.length; i++) {
                int l = tests[i];
                int[] arr = new int[l];

                for (int j = 0; j < l; j++) {
                    if (j % 2 != 0) {
                        arr[j] = l / 2 + j - 1;
                    } else {
                        arr[j] = j / 2;
                    }
                }

                ShellSort.sortLog(Arrays.copyOfRange(arr, 0, arr.length), hits);
            }
        }

        for (Map.Entry<String, Integer> entry : hits.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }



    @Test
    @DisplayName("ShellSortHits")
    public void testShellSortHits() {

        HashMap<String, Integer> hits = new HashMap<String, Integer>();

        int epochs = 100;
        while(epochs-- > 0) {
            int[] tests = new int[]{2_000_000};
            Random r = new Random();
            for (int i = 0; i < tests.length; i++) {
                int l = tests[i];
                int[] arr = new int[l];

                for (int j = l; j > 0; j--) {
                    arr[l - j] = r.nextInt(l + 1);
                }

                ShellSort.sortLog(Arrays.copyOfRange(arr, 0, arr.length), hits);
            }
        }

        for (Map.Entry<String, Integer> entry : hits.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    @Test
    @DisplayName("ShellSort")
    public void testShellSort() {

        int[] arr;

        arr = new int[]{15, 2, 43, 17, 4, 8, 47};
        assertArrayEquals(
                new int[]{2, 4, 8, 15, 17, 43, 47},
                ShellSort.sort(arr)
        );

        arr = new int[]{3, 2, 1};
        assertArrayEquals(
                new int[]{1, 2, 3},
                ShellSort.sort(arr)
        );

        arr = new int[]{1, 98, 12, 3, 4, 2, 8};
        assertArrayEquals(
            new int[]{1, 2, 3, 4, 8, 12, 98},
                ShellSort.sort(arr)
        );

        arr = new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                ShellSort.sort(arr)
        );

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                ShellSort.sort(arr)
        );

        arr = new int[]{15, 6, 27, 2, 34, 62, 19, 25};
        assertArrayEquals(
                new int[]{2, 6, 15, 19, 25, 27, 34, 62},
                ShellSort.sort(arr)
        );

        arr = new int[]{15, 2, 43, 17, 4, 8, 47};
        assertArrayEquals(
                new int[]{2, 4, 8, 15, 17, 43, 47},
                ShellSort.sort(arr)
        );

    }


}
