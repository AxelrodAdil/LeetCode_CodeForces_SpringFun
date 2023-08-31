package leetcode.y2023m02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringPalindrome {

    public static boolean canPalindromeString(String s) {
        if (s.length() % 2 == 1) return false;
        int[] count = new int[26];
        IntStream.range(0, s.length()).forEachOrdered(i -> count[s.charAt(i) - 'a']++);
        int odd = (int) Arrays.stream(count).filter(c -> c % 2 == 1).count();
        return odd <= 1;
    }

    public static void main(String[] args) {
        System.out.println(canPalindromeString("aaaaccaaaa"));
    }
}
