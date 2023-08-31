package leetcode.y2023m01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PalindromePartitioning {

    // https://leetcode.com/problems/palindrome-partitioning/

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private static void backtrack(String s, List<String> partition, List<List<String>> ans) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(partition));
            return;
        }
        int bound = s.length();
        IntStream.rangeClosed(1, bound).forEachOrdered(i -> {
            String substring = s.substring(0, i);
            if (isPalindrome(substring)) {
                partition.add(substring);
                backtrack(s.substring(i), partition, ans);
                partition.remove(partition.size() - 1);
            }
        });
    }

    public static List<List<String>> partition(String s) {
        /*
        Runtime 62 ms
        Beats 5.4%
        Memory 135.3 MB
        Beats 36.62%
        */
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, new ArrayList<>(), ans);
        return ans;
    }
}
