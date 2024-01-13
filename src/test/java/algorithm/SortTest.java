package algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

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



}
