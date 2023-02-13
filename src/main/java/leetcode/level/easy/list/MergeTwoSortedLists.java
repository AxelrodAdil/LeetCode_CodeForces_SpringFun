package leetcode.level.easy.list;

public class MergeTwoSortedLists {

    // https://leetcode.com/problems/merge-two-sorted-lists/

    /*
    Runtime: 1 ms, faster than 82.51% of Java online submissions for Merge Two Sorted Lists.
    Memory Usage: 41.5 MB, less than 96.63% of Java online submissions for Merge Two Sorted Lists.
     */

    private static ListNodeMerge mergeTwoLists(ListNodeMerge list1, ListNodeMerge list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNodeMerge head = new ListNodeMerge(0);
        ListNodeMerge curr = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 != null ? list1 : list2;
        return head.next;
    }

    public static void main(String[] args) {
        ListNodeMerge l1 = new ListNodeMerge(1);
        l1.next = new ListNodeMerge(10);
        l1.next.next = new ListNodeMerge(25);
        ListNodeMerge l2 = new ListNodeMerge(1);
        l2.next = new ListNodeMerge(3);
        l2.next.next = new ListNodeMerge(5);
        l2.next.next.next = new ListNodeMerge(15);
        l2.next.next.next.next = new ListNodeMerge(17);
        l2.next.next.next.next.next = new ListNodeMerge(20);

        var ans = mergeTwoLists(l1, l2);
        while (ans.next != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}

class ListNodeMerge {
    int val;
    ListNodeMerge next;

    ListNodeMerge() {
    }

    ListNodeMerge(int val) {
        this.val = val;
    }

    ListNodeMerge(int val, ListNodeMerge next) {
        this.val = val;
        this.next = next;
    }
}
