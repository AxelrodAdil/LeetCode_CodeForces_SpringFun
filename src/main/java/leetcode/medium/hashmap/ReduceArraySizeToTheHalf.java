package leetcode.medium.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReduceArraySizeToTheHalf {

    // https://leetcode.com/problems/reduce-array-size-to-the-half/

    public int minSetSize(int[] arr) {
        /*
        Runtime: 164 ms, faster than 12.73% of Java online submissions for Reduce Array Size to The Half.
        Memory Usage: 100.7 MB, less than 9.49% of Java online submissions for Reduce Array Size to The Half.
        */
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i : arr) {
            hashmap.put(i, hashmap.getOrDefault(i, 0) + 1);
            if (hashmap.get(i) >= arr.length / 2) {
                return 1;
            }
        }
        hashmap = hashmap.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, b1) -> a1, LinkedHashMap::new));
        int temp = 0;
        int ans = 0;
        for (int i : hashmap.keySet()) {
            temp += hashmap.get(i);
            ans++;
            if (temp >= arr.length / 2) {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ReduceArraySizeToTheHalf reduceArraySizeToTheHalf = new ReduceArraySizeToTheHalf();
        System.out.println(reduceArraySizeToTheHalf.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        System.out.println(reduceArraySizeToTheHalf.minSetSize(new int[]{7, 7, 7, 7, 7, 7}));
    }
}
