package leetcode.y2023m03;

public class ConvertSortedListToBinarySearchTree {

    // https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

    public TreeNodeConvertSortedListToBinarySearchTree sortedListToBST(ListNodeConvertSortedListToBinarySearchTree head) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 43.8 MB
        Beats 27.99%
        */
        if (head == null) return null;
        if (head.next == null) return new TreeNodeConvertSortedListToBinarySearchTree(head.val);
        ListNodeConvertSortedListToBinarySearchTree slow = head, fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        var mid = slow.next;
        slow.next = null;
        var root = new TreeNodeConvertSortedListToBinarySearchTree(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}

class ListNodeConvertSortedListToBinarySearchTree {
    int val;
    ListNodeConvertSortedListToBinarySearchTree next;

    ListNodeConvertSortedListToBinarySearchTree() {
    }

    ListNodeConvertSortedListToBinarySearchTree(int val) {
        this.val = val;
    }

    ListNodeConvertSortedListToBinarySearchTree(int val, ListNodeConvertSortedListToBinarySearchTree next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNodeConvertSortedListToBinarySearchTree {
    int val;
    TreeNodeConvertSortedListToBinarySearchTree left;
    TreeNodeConvertSortedListToBinarySearchTree right;

    TreeNodeConvertSortedListToBinarySearchTree() {
    }

    TreeNodeConvertSortedListToBinarySearchTree(int val) {
        this.val = val;
    }

    TreeNodeConvertSortedListToBinarySearchTree(int val, TreeNodeConvertSortedListToBinarySearchTree left,
                                                TreeNodeConvertSortedListToBinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
