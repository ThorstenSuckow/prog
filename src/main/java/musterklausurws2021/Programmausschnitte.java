package musterklausurws2021;

public class Programmausschnitte {

    static void printArray(int[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + (i < a.length - 1 ? ", " : ""));
        }
        System.out.println();
    }

    public static void main(String ...args) {

        // testArr1
        int testArr1[] = {3, -6, -2 , 8, 5};
        for (int i = 0; i < 4; i++) {
            if (testArr1[i] < 0) {
                testArr1[i] = - testArr1[i];
            }
        }
        printArray(testArr1); // 3, 6, 2, 8, 5

        int testArr2[] = {3, -6, -2, 8, 5};
        for (int i = 0; i < 5; i++) {
            testArr2[i] = (i + 1) * testArr2[i];
        }
        printArray(testArr2); // 3, -12, -6, 32, 25

        int testArr3[] = {3, -6, -2, 8, 5};
        for (int i = 0; i < 4; i++) {
            if (testArr3[i] < testArr3[i + 1]) {
                int tmp = testArr3[i];
                testArr3[i] = testArr3[i + 1];
                testArr3[i + 1] = tmp;
            }
        }
        printArray(testArr3); // 3, -2, 8, 5, -6

    }
}
