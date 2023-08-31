package leetcode.y2023m03;

import java.util.ArrayList;

public class LinkedListRandomNode {

    // https://leetcode.com/problems/linked-list-random-node/

    private final ArrayList<Integer> arrayList = new ArrayList<>();

    public LinkedListRandomNode(ListNodeLinkedListRandomNode head) {
        /*
        Runtime 15 ms
        Beats 16.93%
        Memory 44.6 MB
        Beats 35.47%
        */
        while (head != null) {
            this.arrayList.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int randomIndex = (int) (Math.random() * this.arrayList.size());
        return this.arrayList.get(randomIndex);
    }
}

class ListNodeLinkedListRandomNode {
    int val;
    ListNodeLinkedListRandomNode next;

    ListNodeLinkedListRandomNode() {
    }

    ListNodeLinkedListRandomNode(int val) {
        this.val = val;
    }

    ListNodeLinkedListRandomNode(int val, ListNodeLinkedListRandomNode next) {
        this.val = val;
        this.next = next;
    }
}
