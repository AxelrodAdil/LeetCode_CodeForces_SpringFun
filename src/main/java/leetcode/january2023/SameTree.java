package leetcode.january2023;

public class SameTree {

    // https://leetcode.com/problems/same-tree/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 39.5 MB
        Beats 94.15%
         */
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
