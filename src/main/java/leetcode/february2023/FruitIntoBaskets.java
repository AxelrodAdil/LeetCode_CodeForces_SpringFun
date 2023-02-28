package leetcode.february2023;

import java.util.HashMap;

public class FruitIntoBaskets {

    // https://leetcode.com/problems/fruit-into-baskets/

    public int totalFruit(int[] fruits) {
        /*
        Runtime 53 ms
        Beats 60.93%
        Memory 50.3 MB
        Beats 84.54%
        */
        if (fruits.length <= 2) return fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, max = 0, windowSize = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], (map.getOrDefault(fruits[right], 0) + 1));
            while (map.size() > 2) {
                Integer currFreq = map.get(fruits[left]);
                map.put(fruits[left], --currFreq);
                if (currFreq == 0) map.remove(fruits[left]);
                left++;
            }
            windowSize = right - left + 1;
            max = Math.max(max, windowSize);
        }
        return max;
    }
}
