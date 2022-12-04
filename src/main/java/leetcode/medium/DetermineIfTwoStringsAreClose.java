package leetcode.medium;

import java.util.*;
import java.util.stream.IntStream;

public class DetermineIfTwoStringsAreClose {

    // https://leetcode.com/problems/determine-if-two-strings-are-close/description/

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        var cc1 = new int[26];
        var cc2 = new int[26];
        IntStream.range(0, word1.length()).forEachOrdered(i -> {
            cc1[word1.charAt(i) - 'a']++;
            cc2[word2.charAt(i) - 'a']++;
        });
        {
            int i = 0;
            while (i < 26) {
                if ((cc1[i] == 0) != (cc2[i] == 0)) return false;
                i++;
            }
        }
        Arrays.sort(cc1);
        Arrays.sort(cc2);
        return IntStream.range(0, 26).noneMatch(i -> cc1[i] != cc2[i]);
    }
}
