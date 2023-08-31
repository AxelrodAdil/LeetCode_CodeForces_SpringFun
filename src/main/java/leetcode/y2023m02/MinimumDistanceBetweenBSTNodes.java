package leetcode.y2023m02;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {

    // https://leetcode.com/problems/minimum-distance-between-bst-nodes/
    // https://leetcode.com/problems/minimum-absolute-difference-in-bst/

    static List<Integer> ansList = new ArrayList<>();
    Integer ans = Integer.MAX_VALUE, prev = null;

    public int minDiffInBST2ndSolution(TreeNodeMinimumDistanceBetweenBSTNodes root) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 40.1 MB
        Beats 47.22%
        */
        if (root.left != null) minDiffInBST2ndSolution(root.left);
        if (prev != null) ans = Math.min(ans, root.val - prev);
        prev = root.val;
        if (root.right != null) minDiffInBST2ndSolution(root.right);
        return ans;
    }

    public int minDiffInBST(TreeNodeMinimumDistanceBetweenBSTNodes root) {
        helper(root);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < ansList.size(); i++) {
            ans = Math.min(ans, ansList.get(i) - ansList.get(i - 1));
        }
        return ans;
    }

    private void helper(TreeNodeMinimumDistanceBetweenBSTNodes root) {
        if (root == null) return;
        helper(root.left);
        ansList.add(root.val);
        helper(root.right);
    }
}

class TreeNodeMinimumDistanceBetweenBSTNodes {

    int val;
    TreeNodeMinimumDistanceBetweenBSTNodes left;
    TreeNodeMinimumDistanceBetweenBSTNodes right;

    TreeNodeMinimumDistanceBetweenBSTNodes() {
    }

    TreeNodeMinimumDistanceBetweenBSTNodes(int val) {
        this.val = val;
    }

    TreeNodeMinimumDistanceBetweenBSTNodes(int val, TreeNodeMinimumDistanceBetweenBSTNodes left,
                                           TreeNodeMinimumDistanceBetweenBSTNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
