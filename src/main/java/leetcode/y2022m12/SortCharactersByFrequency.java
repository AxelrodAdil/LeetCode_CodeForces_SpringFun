package leetcode.y2022m12;

import java.util.*;
import java.util.stream.IntStream;

public class SortCharactersByFrequency {

    // https://leetcode.com/problems/sort-characters-by-frequency/description/

    public String frequencySort(String s) {
        /*
        Runtime 17 ms
        Beats 79.42%
        Memory 42.8 MB
        Beats 96.77%
         */
        HashMap<Character, Integer> hashMap = new HashMap<>();
        StringBuilder res = new StringBuilder();
        char[] charArray = s.toCharArray();
        IntStream.range(0, charArray.length).forEach(i -> {
            char ch = charArray[i];
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        });
        List<Map.Entry<Character, Integer>> toSort = new ArrayList<>(hashMap.entrySet());
        toSort.sort(Map.Entry.comparingByValue());
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> characterIntegerEntry : toSort) {
            sortedMap.putIfAbsent(characterIntegerEntry.getKey(), characterIntegerEntry.getValue());
        }

        Object[] arr = sortedMap.keySet().toArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            int size = hashMap.get(arr[i]);
            while (size > 0) {
                res.append(arr[i]);
                size--;
            }
        }
        return res.toString();
    }
}
