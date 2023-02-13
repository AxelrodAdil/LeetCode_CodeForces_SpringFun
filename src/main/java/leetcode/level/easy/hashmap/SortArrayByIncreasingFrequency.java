package leetcode.level.easy.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class SortArrayByIncreasingFrequency {

    // https://leetcode.com/problems/sort-array-by-increasing-frequency/

    public int[] frequencySort(int[] nums) {
        /*
        Runtime: 13 ms, faster than 34.65% of Java online submissions for Sort Array by Increasing Frequency.
        Memory Usage: 42.6 MB, less than 91.88% of Java online submissions for Sort Array by Increasing Frequency.
        */
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i: nums){
            hashMap.put(i, hashMap.getOrDefault(i,0)+1);
        }

        list.sort((o1, o2) -> {
            int frequencyO1 = hashMap.get(o1);
            int frequencyO2 = hashMap.get(o2);
            if (frequencyO1 > frequencyO2) {
                return 1;
            } else if (frequencyO1 < frequencyO2) {
                return -1;
            } else {
                return o2 - o1;
            }
        });
        return list.stream().mapToInt(e -> e).toArray();
    }

    public static void main(String[] args) {
        SortArrayByIncreasingFrequency sortArrayByIncreasingFrequency = new SortArrayByIncreasingFrequency();
        System.out.println(Arrays.toString(sortArrayByIncreasingFrequency.frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(sortArrayByIncreasingFrequency.frequencySort(new int[]{1, 5, 0, 5})));
        System.out.println(Arrays.toString(sortArrayByIncreasingFrequency.frequencySort(new int[]{2, 3, 1, 3, 2})));
    }
}
