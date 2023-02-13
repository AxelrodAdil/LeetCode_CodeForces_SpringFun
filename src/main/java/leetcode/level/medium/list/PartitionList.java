package leetcode.level.medium.list;

class LinkedNode {
    int val;
    LinkedNode next;

    LinkedNode() {
    }

    LinkedNode(int val) {
        this.val = val;
    }

    LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }
}


public class PartitionList {

    // https://leetcode.com/problems/partition-list/
    public LinkedNode partition(LinkedNode head, int x) {
        /*
        Runtime 1 ms
        Beats 81.77%
        Memory 42.6 MB
        Beats 41.62%
         */
        LinkedNode lesserHead = new LinkedNode(-1);
        LinkedNode greatHead = new LinkedNode(-1);
        LinkedNode before = lesserHead;
        LinkedNode after = greatHead;
        LinkedNode node = head;
        while (node != null) {
            if (node.val < x) {
                before.next = node;
                before = before.next;
            } else {
                after.next = node;
                after = after.next;
            }
            node = node.next;
        }
        after.next = null;
        before.next = greatHead.next;
        return lesserHead.next;
    }

    private void printList(LinkedNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1);
        LinkedNode l1 = new LinkedNode(4);
        head.next = l1;
        LinkedNode l2 = new LinkedNode(3);
        l1.next = l2;
        LinkedNode l3 = new LinkedNode(2);
        l2.next = l3;
        LinkedNode l4 = new LinkedNode(5);
        l3.next = l4;
        l4.next = new LinkedNode(2);
        PartitionList list = new PartitionList();
        list.printList(head);
        System.out.println();
        list.printList(list.partition(head, 3));
    }
}
