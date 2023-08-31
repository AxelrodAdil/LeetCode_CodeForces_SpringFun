package leetcode.y2023m03.yandex;

import java.util.Scanner;
import java.util.Stack;

public class CorrectBracketSequence {

    private static String solve(String input) {
        var stack = new Stack<Character>();
        for (var c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return "no";
            }
        }
        return stack.empty() ? "yes" : "no";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solve(input));
    }
}
