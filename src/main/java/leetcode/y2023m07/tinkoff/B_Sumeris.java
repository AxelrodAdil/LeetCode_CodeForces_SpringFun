package leetcode.y2023m07.tinkoff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_Sumeris {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        List<Integer> lostQueue = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int x = scanner.nextInt();
                lostQueue.add(x);
            } else if (queryType == 2) {
                List<Integer> resultList = new ArrayList<>(lostQueue.size() * 2);
                for (int num : lostQueue) {
                    resultList.add(num);
                    resultList.add(num);
                }
                lostQueue = resultList;
            } else if (queryType == 3) {
                System.out.println(lostQueue.remove(0));
            }
        }
    }
}
