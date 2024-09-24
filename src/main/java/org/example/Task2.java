package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Task2 {

    private final static int MIN_LIMIT = -100;

    private final static int MAX_LIMIT = 100;

    public static void executeTask() {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var genList = generateArrayList(n);
        System.out.println(genList);
        doSelectionSort(genList);
        System.out.println(genList);
    }

    private static void doSelectionSort(ArrayList<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(minIndex) > list.get(j)) {
                    minIndex = j;
                }
            }
            var temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
    }

    private static ArrayList<Double> generateArrayList(int n) {
        return DoubleStream.generate(() ->  getRandom(MIN_LIMIT, MAX_LIMIT))
                .limit(n)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

    }

    private static Double getRandom(int min, int max) {
        return (Math.random() * (max - min + 1)) + min;
    }
}
