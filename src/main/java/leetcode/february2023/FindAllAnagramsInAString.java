package leetcode.february2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindAllAnagramsInAString {

    // https://leetcode.com/problems/find-all-anagrams-in-a-string/

    public List<Integer> findAnagrams(String s, String p) {
        /*
        Runtime 9 ms
        Beats 73.74%
        Memory 43.8 MB
        Beats 32.82%
        */
        var answer = new ArrayList<Integer>();
        if (s.length() < p.length()) return answer;
        var first = new int[26];
        var second = new int[26];
        IntStream.range(0, p.length()).forEachOrdered(i -> first[p.charAt(i) - 'a']++);
        var id = 0;
        for (int i = 0; i < s.length(); i++) {
            id++;
            second[s.charAt(i) - 'a']++;
            if (id == p.length()) {
                if (Arrays.equals(first, second)) answer.add(i - p.length() + 1);
                id--;
                second[s.charAt(i + 1 - p.length()) - 'a']--;
            }
        }
        return answer;
    }
}
