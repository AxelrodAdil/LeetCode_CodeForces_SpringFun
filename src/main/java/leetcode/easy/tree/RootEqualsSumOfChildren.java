package leetcode.easy.tree;

public class RootEqualsSumOfChildren {

    // https://leetcode.com/problems/root-equals-sum-of-children/

    public boolean checkTree(TreeNode root) {
        /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Root Equals Sum of Children.
        Memory Usage: 39.4 MB, less than 99.97% of Java online submissions for Root Equals Sum of Children.
        */
        return root.val == (root.left.val + root.right.val);
    }

    public static void main(String[] args) {
        RootEqualsSumOfChildren rootEqualsSumOfChildren = new RootEqualsSumOfChildren();
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode = new TreeNode(10, treeNode2, treeNode3);
        System.out.println(rootEqualsSumOfChildren.checkTree(treeNode));
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
