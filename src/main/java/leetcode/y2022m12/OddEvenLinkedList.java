package leetcode.y2022m12;

public class OddEvenLinkedList {

    // https://leetcode.com/problems/odd-even-linked-list/

    public ListNode oddEvenList(ListNode head) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 41.6 MB
        Beats 94.91%
         */
        if (head == null) return head;
        ListNode root = head, tail = head, rootNext = head.next, tailNext = head.next;
        head = head.next != null ? head.next.next : null;
        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                tail.next = head;
                tail = tail.next;
            } else {
                tailNext.next = head;
                tailNext = tailNext.next;
            }
            head = head.next;
            tailNext.next = null;
            isOdd = !isOdd;
        }
        tail.next = rootNext;
        return root;
    }
}
