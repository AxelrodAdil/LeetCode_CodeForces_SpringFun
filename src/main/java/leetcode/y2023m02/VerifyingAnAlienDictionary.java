package leetcode.y2023m02;

import java.util.stream.IntStream;

public class VerifyingAnAlienDictionary {

    // https://leetcode.com/problems/verifying-an-alien-dictionary/

    public boolean isAlienSorted(String[] words, String order) {
        /*
        Runtime 2 ms
        Beats 20.4%
        Memory 40.6 MB
        Beats 92.34%
        */
        int[] arr = new int[26];
        IntStream.range(0, order.length()).forEachOrdered(i -> arr[order.charAt(i) - 'a'] = i);
        for (int i = 1; i < words.length; i++) {
            var w1 = words[i - 1];
            var w2 = words[i];
            var length = Math.min(w1.length(), w2.length());
            for (int j = 0; j < length; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (arr[w1.charAt(j) - 'a'] > arr[w2.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
            }
            if (w1.length() > w2.length() && w1.startsWith(w2)) return false;
        }
        return true;
    }
}
