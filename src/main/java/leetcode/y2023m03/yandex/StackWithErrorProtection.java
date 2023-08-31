package leetcode.y2023m03.yandex;

import java.util.Scanner;
import java.util.Stack;

public class StackWithErrorProtection {

    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        while (bool) {
            String command = sc.nextLine();
            if (command.equals("exit")) {
                System.out.println("bye");
                bool = false;
                while (!stack.empty()) stack.pop();
            } else if (command.contains("push")) {
                stack.push(Integer.valueOf(command.split(" ")[1]));
                System.out.println("ok");
            } else if (command.equals("back")) {
                if (stack.size() == 0) System.out.println("error");
                else System.out.println(stack.peek());
            } else if (command.equals("pop")) {
                if (stack.size() == 0) System.out.println("error");
                else System.out.println(stack.pop());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("clear")) {
                while (!stack.empty()) stack.pop();
                System.out.println("ok");
            }
        }
    }
}
