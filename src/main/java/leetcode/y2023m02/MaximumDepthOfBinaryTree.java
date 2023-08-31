package leetcode.y2023m02;

public class MaximumDepthOfBinaryTree {

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/

    public int maxDepth(TreeNodeMaximumDepthOfBinaryTree root) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 41.7 MB
        Beats 97.72%
        */
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }
}

class TreeNodeMaximumDepthOfBinaryTree {

    int val;
    TreeNodeMaximumDepthOfBinaryTree left;
    TreeNodeMaximumDepthOfBinaryTree right;

    TreeNodeMaximumDepthOfBinaryTree() {
    }

    TreeNodeMaximumDepthOfBinaryTree(int val) {
        this.val = val;
    }

    TreeNodeMaximumDepthOfBinaryTree(int val, TreeNodeMaximumDepthOfBinaryTree left, TreeNodeMaximumDepthOfBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
