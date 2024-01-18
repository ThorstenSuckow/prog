package sandbox;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test5.AnzahlDerVergleiche;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShellSortTest {

    @Test
    @DisplayName("ShellSort")
    public void testShellSort32() {

        //int[] tests = new int[]{1024*1024, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2};//10, 100, 1000, 10_000, 100_000};
        int[] tests = new int[]{10, 100, 1000, 10_000, 100_000, 500_000};

        for (int i = 0; i < tests.length; i++) {
            int l = tests[i];
            int[] arr = new int[l];

            for (int j = l; j > 0; j--) {
                arr[l - j] = j;
            }

            ShellSort.sort(arr);
            for (int o = 0; o < arr.length - 1; o++) {
                if (arr[o] > arr[o + 1]) {
                    fail();
                }
            }
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
