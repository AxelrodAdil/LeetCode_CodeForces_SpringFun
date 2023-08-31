package leetcode.y2023m03.yandex;

import java.util.Scanner;
import java.util.stream.IntStream;

public class GreatLinelandMigration {

    private static int getFirstMinCityButTL(int[] cities, int i) {
        return IntStream.range(i + 1, cities.length).filter(j -> cities[i] > cities[j]).findFirst().orElse(-1);
    }

    private static void solve(int[] cities, int n) {
        var res = IntStream.range(0, n).map(i -> getFirstMinCityButTL(cities, i)).toArray();
//        var res = IntStream.range(0, n).map(i -> getFirstMinCity(cities, i)).toArray();
        IntStream.range(0, n).mapToObj(i -> res[i] + " ").forEachOrdered(System.out::print);
    }

    public static void main(String[] args) {
        //  10
        //  1 2 3 2 1 4 2 5 3 1
        // -1 4 3 4 -1 6 9 8 9 -1
        Scanner input = new Scanner(System.in);
        var n = input.nextInt();
        var cities = IntStream.range(0, n).map(i -> input.nextInt()).toArray();
        solve(cities, n);
    }
}
