package leetcode.easy.stackqueue;

import java.util.Stack;

public class ValidParentheses {

    // https://leetcode.com/problems/valid-parentheses/

    public boolean isValid(String s) {
        /*
        Runtime: 2 ms, faster than 90.79% of Java online submissions for Valid Parentheses.
        Memory Usage: 40.4 MB, less than 91.49% of Java online submissions for Valid Parentheses.
        */
        if (s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.add(current);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            if (current == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            }
            if (current == '}') {
                if (stack.pop() != '{') {
                    return false;
                }
            }
            if (current == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("){"));
    }
}
