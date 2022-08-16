package leetcode.easy.tree;

public class DeepestLeavesSum {

    // https://leetcode.com/problems/deepest-leaves-sum/

    int ans = 0;

    private void getMaxDepthSum(TreeNode treeNode, int currentDepth, int maxDepth) {
        if (treeNode != null) {
            if (currentDepth == maxDepth) {
                ans += treeNode.val;
            }
            getMaxDepthSum(treeNode.left, currentDepth+1, maxDepth);
            getMaxDepthSum(treeNode.right, currentDepth+1, maxDepth);
        }
    }

    private int getMaxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + Math.max(getMaxDepth(treeNode.left), getMaxDepth(treeNode.right));
    }

    public int deepestLeavesSum(TreeNode root) {
        /*
        Runtime: 3 ms, faster than 80.44% of Java online submissions for Deepest Leaves Sum.
        Memory Usage: 55.6 MB, less than 67.15% of Java online submissions for Deepest Leaves Sum.
        */
        int maxDepth = getMaxDepth(root);
        getMaxDepthSum(root, 1, maxDepth);
        return ans;
    }
}
