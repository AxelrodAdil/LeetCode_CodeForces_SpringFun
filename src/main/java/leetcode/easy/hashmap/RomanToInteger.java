package leetcode.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    // https://leetcode.com/problems/roman-to-integer/

    private Map<Character, Integer> getHashMap() {
        Map<Character, Integer> hashmap = new HashMap<>();
        hashmap.put('I', 1);
        hashmap.put('V', 5);
        hashmap.put('X', 10);
        hashmap.put('L', 50);
        hashmap.put('C', 100);
        hashmap.put('D', 500);
        hashmap.put('M', 1000);
        return hashmap;
    }

    private int romanToInt(String s) {
        Map<Character, Integer> hashmap = getHashMap();
        int year = 0;
        int previous = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = hashmap.get(s.charAt(i));
            if (current < previous) {
                year -= current;
            } else {
                year += current;
            }
            previous = current;
        }
        return year;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }
}
