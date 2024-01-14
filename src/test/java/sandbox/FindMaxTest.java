package sandbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class FindMaxTest {

    @Test
    @DisplayName("findMax")
    public void testfindMax() {

        int[] f = new int[]{92, 1, 23, 2, 93, 245, 32, 235325, 523, 32, 44, 55, 22, 11};


        assertEquals(235325, FindMax.max(f));

    }
}
