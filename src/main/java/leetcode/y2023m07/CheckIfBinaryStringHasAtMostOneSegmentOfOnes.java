package leetcode.y2023m07;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    // https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

    public boolean checkOnesSegment(String s) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 40.5 MB
        Beats 86.10%
         */
        return !s.contains("01");
    }
}
