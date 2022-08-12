package leetcode.easy;

public class ReverseString {

    // https://leetcode.com/problems/reverse-string/

    public void reverseString(char[] s) {
        /*
        Runtime: 1 ms, faster than 99.91% of Java online submissions for Reverse String.
        Memory Usage: 49.4 MB, less than 88.50% of Java online submissions for Reverse String.
        */
        int j = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
