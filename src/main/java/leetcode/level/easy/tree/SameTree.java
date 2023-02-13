package leetcode.level.easy.tree;

public class SameTree {

    // https://leetcode.com/problems/same-tree/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
        Memory Usage: 40.6 MB, less than 84.68% of Java online submissions for Same Tree.
        */
        if (p == null && q == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree sameTree = new SameTree();
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1, treeNode11, treeNode12);

        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode21 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1, treeNode21, treeNode22);
        System.out.println(sameTree.isSameTree(treeNode1, treeNode2));
    }
}
