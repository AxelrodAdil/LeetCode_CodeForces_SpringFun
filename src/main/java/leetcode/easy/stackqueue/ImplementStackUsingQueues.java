package leetcode.easy.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    // https://leetcode.com/problems/implement-stack-using-queues/

    Queue<Integer> queue;

    public ImplementStackUsingQueues() {  // MyStack
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size()-1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }

    public static void main(String[] args) {
        /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
        Memory Usage: 41.6 MB, less than 71.65% of Java online submissions for Implement Stack using Queues.
        */
        ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
        System.out.println(obj.queue);
    }
}
