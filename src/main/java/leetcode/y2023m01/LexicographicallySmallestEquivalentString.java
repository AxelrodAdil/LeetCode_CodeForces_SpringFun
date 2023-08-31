package leetcode.y2023m01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class LexicographicallySmallestEquivalentString {

    // https://leetcode.com/problems/lexicographically-smallest-equivalent-string/

    private char searchSmallest(char c, HashMap<Character, Set<Character>> charMap, Set<Character> visited) {
        if (!charMap.containsKey(c)) return c;
        var smallestChar = c;
        visited.add(c);
        for (char charKey : charMap.get(c)) {
            if (!visited.contains(charKey)) {
                visited.add(charKey);
                var charValue = searchSmallest(charKey, charMap, visited);
                smallestChar = smallestChar < charValue ? smallestChar : charValue;
            }
        }
        return smallestChar;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        /*
        Runtime 32 ms
        Beats 7.39%
        Memory 42.2 MB
        Beats 68.75%
        */
        var characterSetHashMap = new HashMap<Character, Set<Character>>();
        var sb = new StringBuilder();
        var charArray = baseStr.toCharArray();
        IntStream.range(0, s1.length()).forEachOrdered(i -> {
            characterSetHashMap.computeIfAbsent(s1.charAt(i), val -> new HashSet<>()).add(s2.charAt(i));
            characterSetHashMap.computeIfAbsent(s2.charAt(i), val -> new HashSet<>()).add(s1.charAt(i));
        });
        IntStream.range(0, charArray.length).forEachOrdered(i -> {
            var c = charArray[i];
            var smallestChar = searchSmallest(c, characterSetHashMap, new HashSet<>());
            sb.append(smallestChar);
        });
        return sb.toString();
    }
}
