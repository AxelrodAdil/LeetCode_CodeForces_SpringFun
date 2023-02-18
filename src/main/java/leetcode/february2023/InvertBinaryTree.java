package leetcode.february2023;

public class InvertBinaryTree {

    // https://leetcode.com/problems/invert-binary-tree/

    public TreeNodeInvertBinaryTree invertTree(TreeNodeInvertBinaryTree root) {
        /*
        Runtime 0 ms
        Beats 100%
        Memory 40 MB
        Beats 36.51%
        */
        invertTreeNode(root);
        return root;
    }

    private void invertTreeNode (TreeNodeInvertBinaryTree root){
        if (root == null) return;
        var t1 = root.right;
        root.right = root.left;
        root.left = t1;
        invertTreeNode(root.right);
        invertTreeNode(root.left);
    }
}

class TreeNodeInvertBinaryTree {

    int val;
    TreeNodeInvertBinaryTree left;
    TreeNodeInvertBinaryTree right;

    TreeNodeInvertBinaryTree() {
    }

    TreeNodeInvertBinaryTree(int val) {
        this.val = val;
    }

    TreeNodeInvertBinaryTree(int val, TreeNodeInvertBinaryTree left, TreeNodeInvertBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
