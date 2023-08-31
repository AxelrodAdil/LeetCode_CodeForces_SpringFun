package leetcode.y2023m07.tinkoff;

import java.util.Scanner;
import java.util.stream.IntStream;

public class A_Sumeris {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        var costs = calculateCost(n);
        IntStream.range(0, n).mapToObj(i -> costs[i] + " ").forEachOrdered(System.out::print);
    }

    public static int[] calculateCost(int n) {
        int[] costs = new int[n];
        int[] bases = new int[n];
        bases[0] = 1;
        for (int h = 2; h <= n; h++) {
            int base = (2 * h - 1) * (2 * h - 1) + bases[h - 2];
            int cost = (2 * h - 1) * (2 * h - 1) * (2 * h - 1) - base;
            bases[h - 1] = base;
            costs[h - 1] = cost;
        }
        return costs;
    }
}
