package leetcode.level.easy.nospecifictopic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class SortArrayByIncreasingFrequency {

    // https://leetcode.com/problems/sort-array-by-increasing-frequency/

    public int[] frequencySort(int[] nums) {
        /*
        Runtime 175 ms
        Beats 5.15%
        Memory 53.7 MB
        Beats 5.9%
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted, (a, b) -> {
            if (Objects.equals(hashMap.get(a), hashMap.get(b))) {
                return b.compareTo(a);
            }
            return hashMap.get(a) - hashMap.get(b);
        });
        return Arrays.stream(sorted).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        SortArrayByIncreasingFrequency sortArrayByIncreasingFrequency = new SortArrayByIncreasingFrequency();
        int[] arr = new int[]{1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(sortArrayByIncreasingFrequency.frequencySort(arr)));
    }
}
