package leetcode.july2023;

import java.util.Arrays;

public class FinalValueOfVariableAfterPerformingOperations {

    // https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

    public int finalValueAfterOperations(String[] operations) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 41.5 MB
        Beats 78.89%
         */
        int sum = 0;
        for (String s : operations) sum += 44 - s.charAt(1);
        return sum;
    }

//    public int finalValueAfterOperations(String[] operations) {
//        /*
//        Runtime 3 ms
//        Beats 6.20%
//        Memory 42.1 MB
//        Beats 20.34%
//         */
//        return Arrays.stream(operations).mapToInt(s -> 44 - s.charAt(1)).sum();
//    }

//    public int finalValueAfterOperations(String[] operations) {
//        /*
//        Runtime 1 ms
//        Beats 75.81%
//        Memory 41.9 MB
//        Beats 37.90%
//         */
//        int answer = 0, temp = 0;
//        for (String operation : operations) {
//            answer += temp;
//            temp = 0;
//            if (operation.equals("++X")) temp++;
//            else if (operation.equals("X++")) answer++;
//            else if (operation.equals("--X")) temp--;
//            else answer--;
//        }
//        return answer + temp;
//    }
}
