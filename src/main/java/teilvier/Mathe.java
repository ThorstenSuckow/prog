package teilvier;

import java.util.ArrayList;
import java.util.List;

public class Mathe {

    private static Integer[] findeTeiler(int number) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                list.add(i);
            }
        }

        return list.toArray(Integer[]::new);
    }

    private static int teilerSumme(Integer[] teiler, int toCheck) {
        int sum = 0;

        for (int i = 0; i < teiler.length; i++) {
            if (teiler[i] != toCheck) {
                sum += teiler[i];
            }
        }

        return sum;
    }

    public static boolean isAbundant(int toCheck) {

        Integer[] teiler = findeTeiler(toCheck);
        int sum = teilerSumme(teiler, toCheck);

        if (sum > toCheck) {
            return true;
        }

        return false;
    }

    public static Integer[] calcAbundants(int upperBoundary) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= upperBoundary; i++) {
            if (isAbundant(i)) {
                list.add(i);
            }
        }

        return list.toArray(Integer[]::new);
    }

    public static boolean isDeficient(int toCheck){

        Integer[] teiler = findeTeiler(toCheck);
        int sum = teilerSumme(teiler, toCheck);

        if (sum < toCheck) {
            return true;
        }

        return false;
    }

    public static Integer[] calcDeficients(int upperBoundary) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= upperBoundary; i++) {
            if (isDeficient(i)) {
                list.add(i);
            }
        }

        return list.toArray(Integer[]::new);
    }

    public static boolean isPerfect(int toCheck) {
        if (toCheck == 0) {
            return false;
        }
        Integer[] teiler = findeTeiler(toCheck);
        int sum = teilerSumme(teiler, toCheck);

        if (sum == toCheck) {
            return true;
        }

        return false;
    }

    public static Integer[] calcPerfects(int upperBoundary) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= upperBoundary; i++) {
            if (isPerfect(i)) {
                list.add(i);
            }
        }

        return list.toArray(Integer[]::new);
    }

    private static int quersumme(int i) {
        if (i <= 9) {
            return i;
        }

        return i % 10 + quersumme(i / 10);
    }
    public static boolean isNiven(int toCheck) {
        if (toCheck == 0) {
            return false;
        }
        if (toCheck < 10 && toCheck > 0) {
            return true;
        }



        int quersumme = quersumme(toCheck);

        if (toCheck % quersumme == 0) {
            return true;
        }

        return false;
    }

    public static Integer[] calcNivenNumbers(int upperBoundary) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= upperBoundary; i++) {
            if (isNiven(i)) {
                list.add(i);
            }
        }

        return list.toArray(Integer[]::new);
    }

    public static boolean isPrime(int toCheck) {

        if (toCheck <= 1) {
            return false;
        }


        // Check from 2 to n/2
        for (int i = 2; i <= toCheck / 2; i++) {
            if (toCheck % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static Integer[] calcPrimes(int upperBoundary) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= upperBoundary; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }

        return list.toArray(Integer[]::new);
    }

    public static boolean isPrimeTwin(int toCheckA, int toCheckB) {

        if (Math.abs(toCheckB) - Math.abs(toCheckA) == 2 && isPrime(toCheckA) && isPrime(toCheckB)) {
            return true;
        }

        return false;
    }

    public static Integer[] calcPrimeTwins(int upperBoundary) {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= upperBoundary; i++) {
            if (isPrimeTwin(i-2, i)) {
                list.add(i-2);
                list.add(i);
            }
        }

        return list.toArray(Integer[]::new);
    }


}

