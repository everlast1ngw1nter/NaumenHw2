package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task1 {

    private final static int MIN_LIMIT = -100;

    private final static int MAX_LIMIT = 100;

    public static void executeTask() {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var genArray = generateArray(n);
        System.out.println(Arrays.toString(genArray));
        var lastPositive = getLastPositive(genArray);
        if (lastPositive != null) {
            System.out.println(lastPositive);
        } else {
            System.out.println("No positive numbers in array");
        }
    }

    private static Integer getLastPositive(int[] array) {
        for (int i = array.length - 1; i > -1; i--) {
            if (array[i] > 0) {
                return array[i];
            }
        }
        return null;
    }

    private static int[] generateArray(int n) {
        return IntStream.generate(() ->  getRandom(MIN_LIMIT, MAX_LIMIT))
                .limit(n)
                .toArray();

    }

    private static int getRandom(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
}
