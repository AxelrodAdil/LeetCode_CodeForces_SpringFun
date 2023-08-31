package leetcode.y2023m08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        var answer = new int[nums.length];
        var arrayList = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(arrayList);
        for (int i = 0; i < nums.length; i++) {
            int n = 0;
            int index = arrayList.indexOf(nums[i]);
            for (int j = index-1; j >= 0; j--) {
                if (nums[i] > arrayList.get(j)) n++;
            }
            answer[i] = n;
        }
        return answer;
    }
}
