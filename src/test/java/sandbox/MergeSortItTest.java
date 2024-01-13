package sandbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortItTest {

    @Test
    @DisplayName("sort()")
    public void testSort() {

        int[] arr;

        arr = new int[]{5, 8, 3, 9, 1};
        assertArrayEquals(
                new int[]{1, 3, 5, 8, 9},
                MergeSortIt.sort(arr)
        );

    }


    @Test
    @DisplayName("partition()")
    public void testPartition() {

        int[] arr;

        arr = new int[]{1, 2, 3, 4};
        assertArrayEquals(
                new int[]{1, 2},
                MergeSortIt.partition(arr, 0, 1)
        );
        assertArrayEquals(
                new int[]{3, 4},
                MergeSortIt.partition(arr, 2, 3)
        );


        arr = new int[]{1, 2, 3, 4};
        assertArrayEquals(
                new int[]{2},
                MergeSortIt.partition(arr, 1, 1)
        );
        assertArrayEquals(
                new int[]{3, 4},
                MergeSortIt.partition(arr, 2, 3)
        );



    }


    @Test
    @DisplayName("merge()")
    public void testMerge() {

        int[] left;
        int[] right;
        int[] arr;

        left = new int[]{1, 2, 3};
        right = new int[]{4, 5, 6};
        arr = new int[6];

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6},
                MergeSortIt.merge(arr, left, right, 0)
        );


        left = new int[]{1, 4, 5};
        right = new int[]{2, 3, 6};
        arr = new int[6];

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6},
                MergeSortIt.merge(arr, left, right, 0)
        );

        left = new int[]{1, 4};
        right = new int[]{2};
        arr = new int[3];

        assertArrayEquals(
                new int[]{1, 2, 4},
                MergeSortIt.merge(arr, left, right, 0)
        );

        left = new int[]{1};
        right = new int[0];
        arr = new int[1];

        assertArrayEquals(
                new int[]{1},
                MergeSortIt.merge(arr, left, right, 0)
        );


    }

    @Test
    @DisplayName("MergeSortIt")
    public void testMergeSortIt() {

        int[] arr;

        arr = new int[]{1};
        assertArrayEquals(
                new int[]{1},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{1, 2};
        assertArrayEquals(
                new int[]{1, 2},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{2, 1};
        assertArrayEquals(
                new int[]{1, 2},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{1, 2, 1};
        assertArrayEquals(
                new int[]{1, 1, 2},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{6, 2, 27, 15, 34, 62, 19, 25};
        assertArrayEquals(
                new int[]{2, 6, 15, 19, 25, 27, 34, 62},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{15, 2, 43, 17, 4, 8, 47};
        assertArrayEquals(
                new int[]{2, 4, 8, 15, 17, 43, 47},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{3, 2, 1};
        assertArrayEquals(
                new int[]{1, 2, 3},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{1, 98, 12, 3, 4, 2, 8};
        assertArrayEquals(
            new int[]{1, 2, 3, 4, 8, 12, 98},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{15, 6, 27, 2, 34, 62, 19, 25};
        assertArrayEquals(
                new int[]{2, 6, 15, 19, 25, 27, 34, 62},
                MergeSortIt.sort(arr)
        );

        arr = new int[]{15, 2, 43, 17, 4, 8, 47};
        assertArrayEquals(
                new int[]{2, 4, 8, 15, 17, 43, 47},
                MergeSortIt.sort(arr)
        );

    }


}
