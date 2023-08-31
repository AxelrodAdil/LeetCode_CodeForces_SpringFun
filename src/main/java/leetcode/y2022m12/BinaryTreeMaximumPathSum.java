package leetcode.y2022m12;

public class BinaryTreeMaximumPathSum {

    // https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        getMaxPathSum(root);
        return max;
    }

    public int getMaxPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getMaxPathSum(root.left));
        int right = Math.max(0, getMaxPathSum(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
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
