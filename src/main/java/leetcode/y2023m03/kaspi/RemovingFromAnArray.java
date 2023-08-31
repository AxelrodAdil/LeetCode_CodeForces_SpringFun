package leetcode.y2023m03.kaspi;

import java.util.Arrays;

public class RemovingFromAnArray {

    //do not change code here
    public static void main(String[] args) {
        var array = new int[]{1, 2, -1, 0, 1, 5, 0, 2, 2, 0};
        System.out.println(Arrays.toString(removeFromArray(array)));
    }

    public static int[] removeFromArray(int[] a) {
        //write your implementation here
        int count = 0, j = 0;
        for (int value : a) {
            if (value != 0) {
                count++;
            }
        }
        var result = new int[count];
        for (int k : a) {
            if (k != 0) {
                result[j] = k;
                j++;
            }
        }
        return result;
    }
}
