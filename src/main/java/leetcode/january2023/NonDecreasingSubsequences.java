package leetcode.january2023;

import java.util.*;
import java.util.stream.IntStream;

public class NonDecreasingSubsequences {

    // https://leetcode.com/problems/non-decreasing-subsequences/

    private List<List<Integer>> result;

    private void backProp(int[] nums, int start, ArrayList<Integer> list) {
        if (list.size() >= 2) result.add(new ArrayList<>(list));
        Set<Integer> hashSet = new HashSet<>();
        IntStream.range(start, nums.length).filter(i -> !hashSet.contains(nums[i])).forEachOrdered(i -> {
            hashSet.add(nums[i]);
            if (list.isEmpty() || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                backProp(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        });
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        /*
        Runtime 19 ms
        Beats 42%
        Memory 48.8 MB
        Beats 77.45%
        */
        result = new ArrayList<>();
        backProp(nums, 0, new ArrayList<Integer>());
        return result;
    }
}
