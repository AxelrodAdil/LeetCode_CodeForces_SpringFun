package leetcode.level.easy.nospecifictopic;

public class PalindromeNumber {

    // https://leetcode.com/problems/palindrome-number/

    private boolean isPalindrome(int x) {
        StringBuilder s = new StringBuilder();
        s.append(x);
        return s.toString().equals(s.reverse().toString());
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(121));
    }
}
