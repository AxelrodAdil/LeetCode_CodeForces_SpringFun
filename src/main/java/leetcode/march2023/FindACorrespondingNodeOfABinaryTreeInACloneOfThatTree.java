package leetcode.march2023;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    // https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

    TreeNodeFindACorrespondingNode result, tempTarget;

    public final TreeNodeFindACorrespondingNode getTargetCopy(final TreeNodeFindACorrespondingNode original,
                                                              final TreeNodeFindACorrespondingNode cloned,
                                                              final TreeNodeFindACorrespondingNode target) {
        /*
        Runtime 2 ms
        Beats 65.42%
        Memory 50.3 MB
        Beats 38.44%
        */
        this.tempTarget = target;
        inorderTreeNode(original, cloned);
        return result;
    }

    private void inorderTreeNode(TreeNodeFindACorrespondingNode original, TreeNodeFindACorrespondingNode cloned) {
        if (original != null) {
            inorderTreeNode(original.left, cloned.left);
            if (original == tempTarget) result = cloned;
            inorderTreeNode(original.right, cloned.right);
        }
    }
}

class TreeNodeFindACorrespondingNode {
    int val;
    TreeNodeFindACorrespondingNode left;
    TreeNodeFindACorrespondingNode right;

    TreeNodeFindACorrespondingNode(int x) {
        val = x;
    }
}
