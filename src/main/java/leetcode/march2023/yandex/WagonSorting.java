package leetcode.march2023.yandex;

import java.util.*;
import java.util.stream.IntStream;

public class WagonSorting {

    private static String canReorder(int[] trains) {
        Stack<Integer> stack = new Stack<>();
        var arrList = new ArrayList<Integer>();
        stack.push(trains[0]);
        IntStream.range(1, trains.length).forEachOrdered(i -> {
            if (!stack.isEmpty() && stack.peek() < trains[i]) {
                while (!stack.isEmpty() && stack.peek() < trains[i]) arrList.add(stack.pop());
                stack.push(trains[i]);
            } else {
                stack.push(trains[i]);
            }
        });
        while (!stack.isEmpty()) arrList.add(stack.pop());
//        arrList.stream().map(i -> i + " ").forEach(System.out::print);
        if (arrList.size() != trains.length) return "NO";
        for (int i = 1; i < arrList.size(); i++) {
            if (arrList.get(i - 1) > arrList.get(i)) return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(canReorder(arr));
    }
}
