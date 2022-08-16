package leetcode.easy.tree;

public class SymmetricTree {

    // https://leetcode.com/problems/symmetric-tree/

    private boolean validateTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return validateTree(left.left, right.right) && validateTree(left.right, right.left);
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
        Memory Usage: 40.5 MB, less than 92.18% of Java online submissions for Symmetric Tree.
        */
        return validateTree(root.left, root.right);
    }

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode treeNode22 = new TreeNode(3);
        TreeNode treeNode11 = new TreeNode(2, null, treeNode22);
        TreeNode treeNode21 = new TreeNode(3);
        TreeNode treeNode12 = new TreeNode(2, null, treeNode21);
        TreeNode treeNode = new TreeNode(1, treeNode11, treeNode12);
        System.out.println(symmetricTree.isSymmetric(treeNode));
    }
}
