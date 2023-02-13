package leetcode.level.easy.stackqueue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    // https://leetcode.com/problems/implement-queue-using-stacks/

    // A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations,
    // which should be used in preference to this class.
    // For example: Deque<Integer> stack = new ArrayDeque<Integer>();
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public ImplementQueueUsingStacks() {  // MyQueue
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1.push(x);
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
        Memory Usage: 40.2 MB, less than 91.41% of Java online submissions for Implement Queue using Stacks.
        */
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }
}
