package leetcode.medium.list;

public class AddTwoNumbers {

    // https://leetcode.com/problems/add-two-numbers/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        Runtime: 3 ms, faster than 80.48% of Java online submissions for Add Two Numbers.
        Memory Usage: 47.9 MB, less than 40.50% of Java online submissions for Add Two Numbers.
        */
        ListNode answerListNode = new ListNode(0);
        ListNode current = answerListNode;
        int keepInMind = 0;
        while (l1 != null || l2 != null || keepInMind != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + keepInMind;
            current.next = new ListNode(sum % 10);
            current = current.next;
            keepInMind = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return answerListNode.next;
    }

    private int addNodes(ListNode l1, ListNode l2) {
        return getNumber(l1, new StringBuilder()) + getNumber(l2, new StringBuilder());
    }

    private int getNumber(ListNode listNode, StringBuilder sb) {
        sb.append(listNode.val);
        listNode = listNode.next;
        while (listNode != null) {
            sb.append(listNode.val);
            listNode = listNode.next;
        }
        return Integer.parseInt(sb.reverse().toString());
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers.addTwoNumbers(l1, l2);
//        System.out.println(addTwoNumbers.addNodes(l1, l2));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
