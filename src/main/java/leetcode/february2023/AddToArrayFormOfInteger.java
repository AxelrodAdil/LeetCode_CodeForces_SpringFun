package leetcode.february2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {

    // https://leetcode.com/problems/add-to-array-form-of-integer/

    public static List<Integer> addToArrayForm(int[] num, int k) {
        /*
        Runtime 4 ms
        Beats 84.63%
        Memory 43.7 MB
        Beats 85.9%
        */
        var current = k;
        var ans = new ArrayList<Integer>();
        for (int i = num.length - 1; i >= 0 || current > 0; i--) {
            if (i >= 0) current += num[i];
            ans.add(current % 10);
            current /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}
