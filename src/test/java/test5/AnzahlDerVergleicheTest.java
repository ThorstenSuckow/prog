package test5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AnzahlDerVergleicheTest {



    @Test
    @DisplayName("Vergleiche")
    public void testVergleiche() {

        //int[] f1 = new int[]{92, 1, 23, 2, 93, 245, 32, 235325, 523, 32, 44, 55, 22, 11};
        //int[] f2 = new int[]{92, 1, 23, 2, 93, 245, 32, 235325, 523, 32, 44, 55, 22, 11};

        int l = 16;
        int[] f1 = new int[l];
        int[] f2 = new int[l];

        for (int i = l; i > 0; i--) {
            f1[l - i] = i;
            f2[l - i] = i;
        }

        assertArrayEquals(
            AnzahlDerVergleiche.first(f1),
            AnzahlDerVergleiche.second(f2)
        );



    }

}
