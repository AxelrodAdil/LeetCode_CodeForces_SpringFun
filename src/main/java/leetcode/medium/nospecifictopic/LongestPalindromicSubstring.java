package leetcode.medium.nospecifictopic;

public class LongestPalindromicSubstring {

    // https://leetcode.com/problems/longest-palindromic-substring/

    public String longestPalindrome(String s) {
        /*
        Runtime: 487 ms, faster than 22.09% of Java online submissions for Longest Palindromic Substring.
        Memory Usage: 119.4 MB, less than 11.40% of Java online submissions for Longest Palindromic Substring.
        */
        int length = s.length();
        String ans = "";
        int countMax = 0;
        Boolean[][] booleans = new Boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                boolean validation = s.charAt(j) == s.charAt(i);
                booleans[j][i] = i - j > 2 ? booleans[j + 1][i - 1] && validation : validation;
                if (booleans[j][i] && i - j + 1 > countMax) {
                    countMax = i - j + 1;
                    ans = s.substring(j, i + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
    }
}
