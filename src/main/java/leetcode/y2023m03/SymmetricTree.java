package leetcode.y2023m03;

public class SymmetricTree {

    // https://leetcode.com/problems/symmetric-tree/

    boolean isSym(TreeNodeSymmetricTree left, TreeNodeSymmetricTree right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }

    public boolean isSymmetric(TreeNodeSymmetricTree root) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 41 MB
        Beats 25.47%
        */
        return (root == null) || isSym(root.left, root.right);
    }
}


class TreeNodeSymmetricTree {
    int val;
    TreeNodeSymmetricTree left;
    TreeNodeSymmetricTree right;

    TreeNodeSymmetricTree() {
    }

    TreeNodeSymmetricTree(int val) {
        this.val = val;
    }

    TreeNodeSymmetricTree(int val, TreeNodeSymmetricTree left, TreeNodeSymmetricTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
