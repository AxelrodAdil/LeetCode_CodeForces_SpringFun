package leetcode.y2022m12;

public class MiddleOfTheLinkedList {

    // https://leetcode.com/problems/middle-of-the-linked-list/

    public ListNode middleNode(ListNode head) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 40.7 MB
        Beats 79.31%
         */
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode p = head;
        ListNode q = head;
        while (p != null && q != null) {
            p = p.next;
            q = q.next.next;
            if (q != null && q.next == null) return p;
        }
        return p;
    }
}
