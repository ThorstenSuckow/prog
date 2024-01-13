package algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {

    @Test
    @DisplayName("Sort.toString")
    public void testToString() {

        int[] arr;

        arr = new int[]{1, 2, 3, 4, 5, 6};

        assertEquals("[1, 2, 3, 4, 5, 6]", Sort.toString(arr));
        assertEquals("[2, 3, 4]", Sort.toString(arr, 1, 3));
    }

    @Test
    @DisplayName("Sort.swap")
    public void testSwap() {

        int[] arr;

        arr = new int[]{1, 2, 3, 4, 5, 6};

        Sort.swap(arr, 1, 4);
        assertEquals("[1, 5, 3, 4, 2, 6]", Sort.toString(arr));
    }


    @Test
    @DisplayName("Sort.bubbleUp")
    public void testBubbleUp() {

        int[] arr;
        arr = new int[]{6, 5, 4, 3, 2, 1};

        Sort.bubbleUp(arr, 1, 3);
        assertEquals("[6, 4, 3, 5, 2, 1]", Sort.toString(arr));
    }

    @Test
    @DisplayName("Sort.bubbleSort")
    public void testBubblSort() {

        int[] arr;
        arr = new int[]{6, 5, 4, 3, 2, 1};

        Sort.bubbleSort(arr, 1, 3);
        assertEquals("[6, 3, 4, 5, 2, 1]", Sort.toString(arr));

        arr = new int[]{6, 5, 4, 3, 2, 1};
        Sort.bubbleSort(arr);
        assertEquals("[1, 2, 3, 4, 5, 6]", Sort.toString(arr));
    }

    @Test
    @DisplayName("Sort.divide")
    public void testDivide() {

        int[] arr;
        arr = new int[]{7, 6, 5, 3, 2, 4};

        assertEquals(2, Sort.divide(arr, 0, arr.length - 1));
        assertEquals("[2, 3, 4, 6, 7, 5]", Sort.toString(arr));

        arr = new int[]{2, 3, 4, 6, 7, 5};
        assertEquals(3, Sort.divide(arr, 3, 5));
        assertEquals("[2, 3, 4, 5, 7, 6]", Sort.toString(arr));
    }


    @Test
    @DisplayName("Sort.quickSort")
    public void testQuickSort() {

        int[] arr;
        arr = new int[]{7, 6, 5, 3, 2, 4};

        Sort.quickSort(arr, 0, arr.length - 1);
        assertEquals("[2, 3, 4, 5, 6, 7]", Sort.toString(arr));

        arr = new int[]{3, 2, 4};
        Sort.quickSort(arr, 0, arr.length - 1);
        assertEquals("[2, 3, 4]", Sort.toString(arr));

        arr = new int[]{6, 7, 5, 3, 2, 4};
        Sort.quickSort(arr, 3, arr.length - 1);
        assertEquals("[6, 7, 5, 2, 3, 4]", Sort.toString(arr));
    }


    @Test
    @DisplayName("Sort.quickSort()")
    public void testQuickSortNoArgs() {

        int[] arr;

        arr = new int[]{1};
        assertArrayEquals(
                new int[]{1},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{1, 2};
        assertArrayEquals(
                new int[]{1, 2},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{2, 1};
        assertArrayEquals(
                new int[]{1, 2},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{1, 2, 1};
        assertArrayEquals(
                new int[]{1, 1, 2},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{6, 2, 27, 15, 34, 62, 19, 25};
        assertArrayEquals(
                new int[]{2, 6, 15, 19, 25, 27, 34, 62},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{15, 2, 43, 17, 4, 8, 47};
        assertArrayEquals(
                new int[]{2, 4, 8, 15, 17, 43, 47},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{3, 2, 1};
        assertArrayEquals(
                new int[]{1, 2, 3},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{1, 98, 12, 3, 4, 2, 8};
        assertArrayEquals(
                new int[]{1, 2, 3, 4, 8, 12, 98},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{15, 6, 27, 2, 34, 62, 19, 25};
        assertArrayEquals(
                new int[]{2, 6, 15, 19, 25, 27, 34, 62},
                Sort.quickSortRet(arr)
        );

        arr = new int[]{15, 2, 43, 17, 4, 8, 47};
        assertArrayEquals(
                new int[]{2, 4, 8, 15, 17, 43, 47},
                Sort.quickSortRet(arr)
        );

    }


}
