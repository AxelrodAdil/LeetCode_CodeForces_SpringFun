package leetcode.y2023m02;

import java.util.stream.IntStream;

public class ZigzagConversion {

    // https://leetcode.com/problems/zigzag-conversion/

    public static String convert(String s, int numRows) {
        /*
        Runtime 7 ms
        Beats 65.44%
        Memory 42.7 MB
        Beats 72.96%
        */
        if (numRows == 1) return s;
        var sb = new StringBuilder[numRows];
        IntStream.range(0, numRows).forEachOrdered(i -> sb[i] = new StringBuilder());
        int i = 0, length = s.length();
        while (i < length) {
            for (int j = 0; j < numRows && i < length; j++) sb[j].append(s.charAt(i++));
            for (int j = numRows - 2; j > 0 && i < length; j--) sb[j].append(s.charAt(i++));
        }
        IntStream.range(1, numRows).forEachOrdered(ij -> sb[0].append(sb[ij]));
        return sb[0].toString();
    }
}
