package leetcode.february2023;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PermutationInString {

    // https://leetcode.com/problems/permutation-in-string/

    public static boolean checkInclusion(String s1, String s2) {
        /*
        Runtime 7 ms
        Beats 65.18%
        Memory 42.1 MB
        Beats 78.65%
        */
        if (s2.contains(s1)) return true;
        var first = new int[26];
        var second = new int[26];
        IntStream.range(0, s1.length()).forEachOrdered(i -> first[s1.charAt(i) - 'a']++);
        var id = 0;
        for (int i = 0; i < s2.length(); i++) {
            id++;
            second[s2.charAt(i) - 'a']++;
            if (id == s1.length()) {
                if (Arrays.equals(first, second)) return true;
                id--;
                second[s2.charAt(i + 1 - s1.length()) - 'a']--;
            }
        }
        return false;
    }
}
