package leetcode.y2023m02;

import java.util.HashMap;

public class WordPattern {

    // https://leetcode.com/problems/word-pattern/

    public boolean wordPattern(String pattern, String s) {
        /*
        Runtime 1 ms
        Beats 90.70%
        Memory 40.3 MB
        Beats 54.76%
        */
        var hashMap = new HashMap<Character, String>();
        var strings = s.split(" ");
        var chars = pattern.toCharArray();
        int i = 0;
        if (strings.length != chars.length) return false;
        while (i < chars.length) {
            if (hashMap.containsKey(chars[i]) && !hashMap.get(chars[i]).equals(strings[i])) return false;
            else if (!hashMap.containsKey(chars[i]) && hashMap.containsValue(strings[i])) return false;
            hashMap.put(chars[i], strings[i]);
            i++;
        }
        return true;
    }
}
