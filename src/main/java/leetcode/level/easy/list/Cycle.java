package leetcode.level.easy.list;

import java.util.HashSet;
import java.util.Set;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class Cycle {
    public static boolean detectCycle(Node head) {
        Node curr = head;
        Set<Node> set = new HashSet<>();
        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5};
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        head.next.next.next.next.next = head.next.next;
        System.out.println((detectCycle(head)));
    }
}
